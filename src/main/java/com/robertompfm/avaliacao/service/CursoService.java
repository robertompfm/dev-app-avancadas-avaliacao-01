package com.robertompfm.avaliacao.service;

import com.robertompfm.avaliacao.model.Aluno;
import com.robertompfm.avaliacao.model.Curso;
import com.robertompfm.avaliacao.repository.AlunoRepository;
import com.robertompfm.avaliacao.repository.CursoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CursoService {
    private final CursoRepository repository;

    public void save(Curso curso) { this.repository.save(curso); }

    public List<Curso> findAll() { return this.repository.findAll(); }

    public void remove(Long id) { this.repository.deleteById(id); }

    public void edit(Curso novoCurso, Long id) {
        this.repository.findById(id).map(curso -> {
            curso.setNome(novoCurso.getNome());
           return this.repository.save(curso);
        });
    }
}
