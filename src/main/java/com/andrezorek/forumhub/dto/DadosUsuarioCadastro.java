package com.andrezorek.forumhub.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DadosUsuarioCadastro(
        @NotBlank String nome,
        @NotBlank @Email String email,
        @NotBlank String senha
){}
