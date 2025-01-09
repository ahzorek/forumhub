package com.andrezorek.forumhub.dto;

import com.andrezorek.forumhub.model.UsuarioForum;
import jakarta.validation.constraints.NotBlank;

public record DadosUsuarioRetorno(
        int id,
        String nome,
        String email

){
    public DadosUsuarioRetorno(UsuarioForum u){
        this(u.getId(), u.getNome(), u.getEmail());
    }
}
