package br.com.alura.forumhub.controller;

import br.com.alura.forumhub.domain.Usuario;
import br.com.alura.forumhub.dto.DadosAtualizacaoUsuario;
import br.com.alura.forumhub.dto.DadosCadastroUsuario;
import br.com.alura.forumhub.dto.DadosListagemUsuario;
import br.com.alura.forumhub.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@Log4j2
@RequestMapping("usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroUsuario dadosCadastroUsuario) {
        log.info("[INICIOU] cadastrar --> postUSUARO");
        usuarioRepository.save(new Usuario(dadosCadastroUsuario));
        log.info("[FINALIZOU] cadastrar --> postUSUARO");
    }

    @GetMapping("/ativos")
    public Page<DadosListagemUsuario> listarUsuariosAtivos(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return usuarioRepository.findAllByStatusTrue(paginacao)
                .map(DadosListagemUsuario::new);
    }

    @GetMapping("/inativos")
    public Page<DadosListagemUsuario> listarUsuariosInativos(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return usuarioRepository.findAllByStatusFalse(paginacao)
                .map(DadosListagemUsuario::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoUsuario dadosAtualizacaoUsuario) {
        var usuario = usuarioRepository.getReferenceById(dadosAtualizacaoUsuario.id());
        usuario.atualizarInformacoes(dadosAtualizacaoUsuario);
    }

    @PutMapping("/ativar/{id}")
    @Transactional
    public void ativaUsuario(@PathVariable Long id) {
        var usuario = usuarioRepository.getReferenceById(id);
        usuario.ativaUsuario();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void inativaUsuario(@PathVariable Long id) {
        var usuario = usuarioRepository.getReferenceById(id);
        usuario.inativaUsuario();
    }
}

//    Aqui exclui definitivamente
//    @DeleteMapping("/{id}")
//    @Transactional
//    public void excluir(@PathVariable Long id) {
//        usuarioRepository.deleteById(id);
//    }