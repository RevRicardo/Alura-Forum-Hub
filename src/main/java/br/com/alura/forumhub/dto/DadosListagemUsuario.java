package br.com.alura.forumhub.dto;

import br.com.alura.forumhub.domain.Usuario;

public record DadosListagemUsuario(
        Long id,
        String nome,
        String email,
        boolean status)
{
     public DadosListagemUsuario(Usuario usuario) {
         this(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.isStatus());
     }
}
