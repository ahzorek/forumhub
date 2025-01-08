package com.andrezorek.forumhub.dto;

import jakarta.validation.constraints.NotBlank;

public record DadosUsuarioRetorno(
        int id,
        String nome,
        String email

){}
