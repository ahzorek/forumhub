package com.andrezorek.forumhub.dto;

import com.andrezorek.forumhub.model.CategoriaCurso;
import com.andrezorek.forumhub.model.Curso;

public record DadosCurso(String nome, CategoriaCurso categoria) {
    public DadosCurso(Curso curso){
        this(curso.getNomeCurso(), curso.getCategoria());
    }
}
