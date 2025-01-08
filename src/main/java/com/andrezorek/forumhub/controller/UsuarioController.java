package com.andrezorek.forumhub.controller;

import com.andrezorek.forumhub.dto.DadosUsuarioCadastro;
import com.andrezorek.forumhub.dto.DadosUsuarioRetorno;
import com.andrezorek.forumhub.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<DadosUsuarioRetorno> getAllUsuarios(){
        return usuarioService.getAllUsers();
    }

    @PostMapping
    public void postUser(@RequestBody @Valid DadosUsuarioCadastro dados){
        usuarioService.createUser(dados);
    }

    @GetMapping("/{id}")
    public DadosUsuarioRetorno getUsuarioPorId(@PathVariable int id){
        return usuarioService.getUserById(id);
    }

}
