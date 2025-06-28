package br.com.alura.forumhub.domain;

import br.com.alura.forumhub.dto.DadosCadastroUsuario;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Builder
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false, unique = true)
    private String email;

    public Usuario(DadosCadastroUsuario dadosCadastroUsuario) {
        this.nome = dadosCadastroUsuario.nome();
        this.email = dadosCadastroUsuario.email();
    }
}
