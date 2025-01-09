package com.andrezorek.forumhub.service;

import com.andrezorek.forumhub.dto.DadosUsuarioCadastro;
import com.andrezorek.forumhub.dto.DadosUsuarioRetorno;
import com.andrezorek.forumhub.model.UsuarioForum;
import com.andrezorek.forumhub.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

import static java.util.stream.Collectors.toList;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repositorioUsuario;

    @Transactional
    public UsuarioForum createUser(DadosUsuarioCadastro dados){
        return repositorioUsuario.save(new UsuarioForum(dados));
    }

    public Page<DadosUsuarioRetorno> getAllUsers(Pageable pagination){
        return repositorioUsuario.findAll(pagination)
                .map(DadosUsuarioRetorno::new);
    }


    public DadosUsuarioRetorno getUserById(int id) {
        return new DadosUsuarioRetorno(
                repositorioUsuario.findById(id).get()
        );
    }
}
