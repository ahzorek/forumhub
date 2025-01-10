package com.andrezorek.forumhub.controller;

import com.andrezorek.forumhub.dto.DadosUsuarioCadastro;
import com.andrezorek.forumhub.dto.DadosUsuarioRetorno;
import com.andrezorek.forumhub.model.UsuarioForum;
import com.andrezorek.forumhub.service.UsuarioService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.validation.Valid;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/usuario")
@SecurityRequirement(name = "bearer-key")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<Page<DadosUsuarioRetorno>> getAllUsuarios(@PageableDefault(sort = {"nome"}) Pageable pagination){
        return ResponseEntity.ok().body(usuarioService.getAllUsers(pagination));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosUsuarioRetorno> getUsuarioPorId(@PathVariable int id){
        return ResponseEntity.ok().body(usuarioService.getUserById(id));
    }

    @PostMapping
    public ResponseEntity<DadosUsuarioRetorno> createNewUsuario(@RequestBody @Valid DadosUsuarioCadastro dados, UriComponentsBuilder uriBuilder){
        UsuarioForum novoUsuario  = usuarioService.createUser(dados);

        return ResponseEntity
                .created(uriBuilder.path("/usuario/{id}").buildAndExpand(novoUsuario.getId()).toUri())
                .body(new DadosUsuarioRetorno(novoUsuario));
    }



}
