package com.andrezorek.forumhub.dto;

import com.andrezorek.forumhub.model.UsuarioForum;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DadosUsuarioCadastro(
        @NotBlank String nome,
        @NotBlank @Email String email,
        @NotBlank String senha
){
    public DadosUsuarioCadastro(UsuarioForum novoUsuario) {
        this(novoUsuario.getNome(), novoUsuario.getEmail(), novoUsuario.getSenha());
    }
}
