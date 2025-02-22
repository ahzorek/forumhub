package com.andrezorek.forumhub.controller;

import com.andrezorek.forumhub.dto.DadosCurso;
import com.andrezorek.forumhub.model.Curso;
import com.andrezorek.forumhub.repository.CursoRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RequestMapping("/curso")
@RestController
@SecurityRequirement(name = "bearer-key")
public class CursoController {

    @Autowired
    private CursoRepository repository;

    @PostMapping
    public ResponseEntity<DadosCurso> createCurso(@RequestBody @Valid DadosCurso dados, UriComponentsBuilder uriBuilder){
        var novoCurso = repository.save(new Curso(dados));
        return ResponseEntity
                .created(uriBuilder.path("/curso/{id}").buildAndExpand(novoCurso.getId()).toUri())
                .body(new DadosCurso(novoCurso));
    }

    @GetMapping
    public ResponseEntity<Page<DadosCurso>> getAllCursos(Pageable pagination){
        return ResponseEntity.ok().body(
                repository.findAll(pagination).map(DadosCurso::new)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosCurso> getAllCursos(@PathVariable Integer id){
        Curso curso = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Curso não encontrado"));
        System.out.println("Curso encontrado::: " + curso);
        return ResponseEntity.ok().body(
                new DadosCurso(curso)
        );
    }

}
