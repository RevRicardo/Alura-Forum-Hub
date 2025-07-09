package br.com.alura.forumhub.dto;

import br.com.alura.forumhub.domain.Curso;
import br.com.alura.forumhub.domain.Usuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;

import java.time.LocalDateTime;

public record DadosCadastroTopico(
        String titulo,
        @Column(nullable = false, columnDefinition = "TEXT")
        String descricao,
        @Column(nullable = false)
        @Future
        LocalDateTime dataCriacao,
        @Enumerated(EnumType.STRING)
        Curso curso,
        @ManyToOne(optional = false)
        @JoinColumn(name = "usuario_id")
        Usuario autor) {
}
