package com.andrezorek.forumhub.repository;

import com.andrezorek.forumhub.model.UsuarioForum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<UsuarioForum, Integer> {
    UserDetails findByEmail(String email);
}
