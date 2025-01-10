package com.andrezorek.forumhub.service;

import com.andrezorek.forumhub.model.UsuarioForum;
import com.andrezorek.forumhub.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return usuarioRepository.findByEmail(email);
    }

    public void authenticateUserRequest(String email) {
        UsuarioForum usuario = (UsuarioForum) usuarioRepository.findByEmail(email);
        var authenticator = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(authenticator);
        System.out.println("logado na req");
    }
}
