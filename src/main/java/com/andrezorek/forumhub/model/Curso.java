package com.andrezorek.forumhub.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "cursos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Curso {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nomeCurso;

    @Enumerated(EnumType.STRING)
    private CategoriaCurso categoria;

    @OneToMany(mappedBy = "id")
    private List<Topico> topicos;

}