package com.andrezorek.forumhub.model;

import com.andrezorek.forumhub.dto.DadosCurso;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "cursos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")
public class Curso {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nomeCurso;

    @Enumerated(EnumType.STRING)
    private CategoriaCurso categoria;

    @OneToMany(mappedBy = "curso")
    private List<Topico> topicos;

    public Curso(DadosCurso dados) {
        this.nomeCurso = dados.nome();
        this.categoria = dados.categoria();
    }


}
