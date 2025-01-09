package com.andrezorek.forumhub.model;

import com.andrezorek.forumhub.dto.DadosUsuarioCadastro;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name="UsuarioForum")
@Table(name = "usuarios")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class UsuarioForum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;

    private String email;

    private String senha;

    @Transient
    @ManyToMany
    private List<Perfil> profiles;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Topico> topicos;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RespostaTopico> respostas;

    public UsuarioForum(DadosUsuarioCadastro dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.senha = dados.senha();
    }
}
