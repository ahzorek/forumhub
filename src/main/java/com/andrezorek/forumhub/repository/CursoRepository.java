package com.andrezorek.forumhub.repository;

import com.andrezorek.forumhub.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Integer> {
}
