package br.com.alura.forumhub.controller;

import br.com.alura.forumhub.domain.Topico;
import br.com.alura.forumhub.domain.Usuario;
import br.com.alura.forumhub.dto.*;
import br.com.alura.forumhub.repository.TopicoRepository;
import br.com.alura.forumhub.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@Log4j2
@RequestMapping("topico")
public class TopicoController {
    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroTopico dadosCadastroTopico) {
        log.info("[INICIOU] cadastrar --> postUSUARO");
        topicoRepository.save(new Topico(dadosCadastroTopico));
        log.info("[FINALIZOU] cadastrar --> postUSUARO");
    }

    @PutMapping("/{id}")
    @Transactional
    public void atualizar(@PathVariable Long id, @RequestBody DadosAtualizacaoTopico dadosAtualizacaoTopico) {
        var topico = topicoRepository.getReferenceById(id);
        topico.atualizarInformacoes(dadosAtualizacaoTopico);
    }

    @GetMapping
    public Page<DadosListagemTopico> listarTopicos(@PageableDefault(size = 10, sort = {"dataCriacao"}) Pageable paginacao) {
        return topicoRepository.findAll(paginacao)
                .map(DadosListagemTopico::new);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosListagemTopico> listarTopicosPorId(@PathVariable Long id) {
        Optional<Topico> topicoOptional = topicoRepository.findById(id);
        if (topicoOptional.isPresent()) {
            DadosListagemTopico dados = new DadosListagemTopico(topicoOptional.get());
            return ResponseEntity.ok(dados);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        // Verifica se o tópico existe antes de tentar excluir
        if (topicoRepository.existsById(id)) {
            topicoRepository.deleteById(id);
            // Retorna um status 204 No Content para indicar sucesso na exclusão sem corpo de resposta
            return ResponseEntity.noContent().build();
        } else {
            // Se o tópico não for encontrado, retorna um status 404 Not Found
            return ResponseEntity.notFound().build();
        }
    }
}
