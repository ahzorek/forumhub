package com.andrezorek.forumhub.controller;

import com.andrezorek.forumhub.dto.DadosCadastroTopico;
import com.andrezorek.forumhub.dto.DadosRetornoTopico;
import com.andrezorek.forumhub.model.Topico;
import com.andrezorek.forumhub.service.TopicoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topico")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @PostMapping
    public ResponseEntity<DadosRetornoTopico> createNewTopico(@RequestBody @Valid DadosCadastroTopico dadosCadastroTopico){
        return ResponseEntity.ok().body(
                new DadosRetornoTopico(topicoService.createNew(dadosCadastroTopico))
        );
    }

    @GetMapping
    public ResponseEntity<Page<DadosRetornoTopico>> getAllTopicos(@PageableDefault(direction= Sort.Direction.ASC) Pageable pagination){
        return ResponseEntity.ok().body(topicoService.getAll(pagination));
    }
}
