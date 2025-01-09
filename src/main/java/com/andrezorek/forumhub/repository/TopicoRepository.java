package com.andrezorek.forumhub.repository;

import com.andrezorek.forumhub.model.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Integer> {
}
