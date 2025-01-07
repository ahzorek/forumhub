package com.andrezorek.forumhub.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    @NotBlank
    private String titulo;

    @NotBlank
    private String mensagem;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private StatusTopico status;

    @ManyToOne
    private UsuarioForum user;

    @ManyToOne
    private Curso curso;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RespostaTopico> respostas;



}
