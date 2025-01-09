package com.andrezorek.forumhub.controller;

import com.andrezorek.forumhub.dto.DadosAuth;
import com.andrezorek.forumhub.dto.DadosJwtToken;
import com.andrezorek.forumhub.infra.TokenService;
import com.andrezorek.forumhub.model.UsuarioForum;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<DadosJwtToken> autenticar(@RequestBody @Valid DadosAuth dadosAuth){
        var authToken = new UsernamePasswordAuthenticationToken(dadosAuth.email(), dadosAuth.senha());
        var auth = authManager.authenticate(authToken);
        var jwtToken = tokenService.gerarToken((UsuarioForum) auth.getPrincipal());

        return ResponseEntity.ok().body(new DadosJwtToken(jwtToken));
    }
}
