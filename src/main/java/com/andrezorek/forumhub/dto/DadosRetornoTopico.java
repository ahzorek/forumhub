package com.andrezorek.forumhub.dto;

import com.andrezorek.forumhub.model.Topico;

import java.time.LocalDateTime;

public record DadosRetornoTopico(
        int id,
        String titulo,
        String mensagem,
        DadosCurso curso,
        DadosUsuarioRetorno autor,
        LocalDateTime createdAt
){

    public DadosRetornoTopico(Topico topico){
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                new DadosCurso(topico.getCurso()),
                new DadosUsuarioRetorno(topico.getUsuarioForum()),
                topico.getCreatedAt()
        );
    }
    
}
