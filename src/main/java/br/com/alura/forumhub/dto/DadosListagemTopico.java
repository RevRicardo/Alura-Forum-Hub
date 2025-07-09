package br.com.alura.forumhub.dto;

import br.com.alura.forumhub.domain.Topico;
import java.time.LocalDateTime;

public record DadosListagemTopico(
        Long id,
        String titulo,
        String descricao,
        LocalDateTime dataCriacao,
        boolean status,
        String curso,
        String nomeAutor)
{
        // Construtor que recebe um objeto Topico
        public DadosListagemTopico(Topico topico) {
                this(topico.getId(),
                        topico.getTitulo(),
                        topico.getDescricao(),
                        topico.getDataCriacao(),
                        topico.isStatus(),
                        topico.getCurso().name(),
                        topico.getAutor().getNome());
        }
}
