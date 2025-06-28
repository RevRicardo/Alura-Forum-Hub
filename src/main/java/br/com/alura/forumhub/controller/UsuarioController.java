package br.com.alura.forumhub.controller;

import br.com.alura.forumhub.domain.Usuario;
import br.com.alura.forumhub.dto.DadosCadastroUsuario;
import br.com.alura.forumhub.repository.UsuarioRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequestMapping("usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroUsuario dadosCadastroUsuario) {
        log.info("[INICIOU] cadastrar --> postUSUARO");
        usuarioRepository.save(new Usuario(dadosCadastroUsuario));
        log.info("[FINALIZOU] cadastrar --> postUSUARO");
    }
}
