package br.com.alura.forumhub.domain;

import br.com.alura.forumhub.dto.DadosAtualizacaoTopico;
import br.com.alura.forumhub.dto.DadosAtualizacaoUsuario;
import br.com.alura.forumhub.dto.DadosCadastroTopico;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "topicos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String titulo;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String descricao;
    @Column(nullable = false)
    private LocalDateTime dataCriacao;
    private boolean status = true;
    @Enumerated(EnumType.STRING)
    private Curso Curso;
    @ManyToOne(optional = false)
    @JoinColumn(name = "usuario_id")
    private Usuario autor;

    public Topico(DadosCadastroTopico dadosCadastroTopico) {
        this.titulo = dadosCadastroTopico.titulo();
        this.descricao = dadosCadastroTopico.descricao();
        this.dataCriacao = LocalDateTime.now();
        this.status = true;
        this.Curso = dadosCadastroTopico.curso();
        this.autor = dadosCadastroTopico.autor();
    }

    public void atualizarInformacoes(DadosAtualizacaoTopico dadosAtualizacaoTopico) {
        if (dadosAtualizacaoTopico.titulo() != null) {
            this.titulo = dadosAtualizacaoTopico.titulo();
        }
        if (dadosAtualizacaoTopico.descricao() != null) {
            this.descricao = dadosAtualizacaoTopico.descricao();
        }
    }
}
