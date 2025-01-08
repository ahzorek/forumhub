package com.andrezorek.forumhub.repository;

import com.andrezorek.forumhub.model.UsuarioForum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioForum, Integer> {
}
