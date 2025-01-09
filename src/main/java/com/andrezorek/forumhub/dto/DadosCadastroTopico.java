package com.andrezorek.forumhub.dto;

public record DadosCadastroTopico(
        String titulo,
        String mensagem,
        int usuarioId,
        int cursoId
) {

}
