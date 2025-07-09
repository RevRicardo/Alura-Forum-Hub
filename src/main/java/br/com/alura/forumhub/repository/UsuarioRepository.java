package br.com.alura.forumhub.repository;

import br.com.alura.forumhub.domain.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Page<Usuario> findAllByStatusTrue(Pageable paginacao);

    Page<Usuario> findAllByStatusFalse(Pageable paginacao);

    UserDetails findByEmail(String email);
}
