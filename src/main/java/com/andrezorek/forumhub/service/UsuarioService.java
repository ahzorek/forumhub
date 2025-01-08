package com.andrezorek.forumhub.service;

import com.andrezorek.forumhub.dto.DadosUsuarioCadastro;
import com.andrezorek.forumhub.dto.DadosUsuarioRetorno;
import com.andrezorek.forumhub.model.UsuarioForum;
import com.andrezorek.forumhub.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repositorioUsuario;

    public void createUser(DadosUsuarioCadastro dados){
        repositorioUsuario.save(new UsuarioForum(dados));
    }

    public List<DadosUsuarioRetorno> getAllUsers(){
        return repositorioUsuario.findAll()
                .stream()
                .map(u -> new DadosUsuarioRetorno(
                        u.getId(),
                        u.getNome(),
                        u.getEmail()
                )).collect(Collectors.toList());
    }


    public DadosUsuarioRetorno getUserById(int id){
        var u = repositorioUsuario.findById(id).get();
        return new DadosUsuarioRetorno(
                u.getId(),
                u.getNome(),
                u.getEmail()
        );
    }
}
