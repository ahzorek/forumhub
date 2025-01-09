package com.andrezorek.forumhub.dto;

import com.andrezorek.forumhub.model.Curso;
import com.andrezorek.forumhub.model.Topico;
import com.andrezorek.forumhub.model.UsuarioForum;

import java.time.LocalDateTime;

public record DadosRetornoTopico(
        String titulo,
        String mensagem,
        DadosCurso curso,
        DadosUsuarioRetorno autor,
        LocalDateTime createdAt
){

    public DadosRetornoTopico(Topico topico){
        this(
                topico.getTitulo(),
                topico.getMensagem(),
                new DadosCurso(topico.getCurso()),
                new DadosUsuarioRetorno(topico.getUsuarioForum()),
                topico.getCreatedAt()
        );
    }
    
}
