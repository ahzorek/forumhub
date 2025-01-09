package com.andrezorek.forumhub.controller;

import com.andrezorek.forumhub.dto.DadosAtualizaTopico;
import com.andrezorek.forumhub.dto.DadosCadastroTopico;
import com.andrezorek.forumhub.dto.DadosRetornoTopico;
import com.andrezorek.forumhub.model.Topico;
import com.andrezorek.forumhub.service.TopicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    //C
    @PostMapping
    public ResponseEntity<DadosRetornoTopico> createNewTopico(@RequestBody @Valid DadosCadastroTopico dadosCadastroTopico, UriComponentsBuilder uriBuilder){
        Topico novoTopico = topicoService.createNew(dadosCadastroTopico);
        return ResponseEntity
                .created(uriBuilder.path("/topicos/{id}").buildAndExpand(novoTopico.getId()).toUri())
                .body(new DadosRetornoTopico(novoTopico));
    }

    //R
    @GetMapping
    public ResponseEntity<Page<DadosRetornoTopico>> getAllTopicos(@PageableDefault(direction= Sort.Direction.ASC) Pageable pagination){
        return ResponseEntity.ok().body(topicoService.getAll(pagination));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosRetornoTopico> getTopicoById(@PathVariable int id){
        return ResponseEntity.ok().body(topicoService.getById(id));
    }

    // U
    @PutMapping
    public ResponseEntity<DadosRetornoTopico> updateTopico(@RequestBody DadosAtualizaTopico dados){
        var update = topicoService.updateTopico(dados);
        return ResponseEntity.ok().body(update);
    }

    // D
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTopicoById(@PathVariable int id){
        topicoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
