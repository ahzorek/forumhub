package com.andrezorek.forumhub.model;

import com.andrezorek.forumhub.dto.DadosAtualizaTopico;
import com.andrezorek.forumhub.dto.DadosCadastroTopico;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "topicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String titulo;

    private String mensagem;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private StatusTopico status;

    @ManyToOne
    private UsuarioForum usuarioForum;

    @ManyToOne
    private Curso curso;

    @Transient
    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RespostaTopico> respostas;


    public Topico(DadosCadastroTopico dadosCadastroTopico, Curso curso, UsuarioForum user) {
        this.curso = curso;
        this.usuarioForum = user;
        this.titulo = dadosCadastroTopico.titulo();
        this.mensagem = dadosCadastroTopico.mensagem();
        this.status = StatusTopico.ABERTO;
    }

    public Topico atualizaTopico(DadosAtualizaTopico dados){
        if(dados.titulo() != null){
            this.titulo = dados.titulo();
        }
        if(dados.mensagem() != null){
            this.mensagem = dados.mensagem();
        }

        return this;
    }

    @Override
    public String toString() {
        return "Topico::: " +
                "titulo='" + titulo + '\'' +
                ", createdAt=" + createdAt +
                ", status=" + status +
                ", usuarioForum=" + usuarioForum.getNome() +
                ", curso=" + curso.getNomeCurso();
    }
}
