package com.andrezorek.forumhub.service;

import com.andrezorek.forumhub.dto.DadosAtualizaTopico;
import com.andrezorek.forumhub.dto.DadosCadastroTopico;
import com.andrezorek.forumhub.dto.DadosRetornoTopico;
import com.andrezorek.forumhub.dto.DadosUsuarioRetorno;
import com.andrezorek.forumhub.model.Topico;
import com.andrezorek.forumhub.repository.CursoRepository;
import com.andrezorek.forumhub.repository.TopicoRepository;
import com.andrezorek.forumhub.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private CursoRepository cursoRepository;

    @Transactional
    public Topico createNew(DadosCadastroTopico dados){
        var user = usuarioRepository.findById(dados.usuarioId())
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));
        var curso = cursoRepository.findById(dados.cursoId())
                .orElseThrow(() -> new EntityNotFoundException("Curso não encontrado"));

        var topico = new Topico(dados, curso, user);

        return topicoRepository.save(topico);

    }

    @Transactional
    public DadosRetornoTopico updateTopico(DadosAtualizaTopico novosDados){
        var updating = topicoRepository.getReferenceById(novosDados.id());

        return new DadosRetornoTopico(updating.atualizaTopico(novosDados));

    }

    public Page<DadosRetornoTopico> getAll(Pageable pagination){
        return topicoRepository.findAll(pagination)
                .map(DadosRetornoTopico::new);
    }

    public DadosRetornoTopico getById(int id) {
        return new DadosRetornoTopico(topicoRepository.getReferenceById(id));
    }

    public void deleteById(int id) {
        topicoRepository.deleteById(id);
    }
}
