package br.com.alura.forumhub.dto;

import br.com.alura.forumhub.domain.Curso;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoTopico(
        String titulo,
        String descricao) {
}
