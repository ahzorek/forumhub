package com.andrezorek.forumhub.dto;

public record DadosAtualizaTopico(
        int id,
        String titulo,
        String mensagem,
        int cursoId
){}

