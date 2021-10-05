package com.robertompfm.avaliacao.service;

import com.robertompfm.avaliacao.model.Aluno;
import com.robertompfm.avaliacao.repository.AlunoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class AlunoService {
    private final AlunoRepository repository;

    public void save(Aluno aluno) { this.repository.save(aluno); }

    public List<Aluno> findAll() { return this.repository.findAll(); }

    public List<Aluno> findByCriteria(String nome, String curso) {
        if (nome == null) {
            nome = "";
        }
        if (curso == null) {
            curso = "";
        }
        return this.repository.findByNomeIgnoreCaseContainingAndCursoNomeIgnoreCaseContaining(nome, curso);
    }

    public List<Aluno> findByNome(String nome) { return this.repository.findByNomeIgnoreCaseContaining(nome); }

    public List<Aluno> findByCursoNome(String nome) { return this.repository.findByCursoNomeIgnoreCaseContaining(nome); }

    public void remove(Long id) { this.repository.deleteById(id); }

    public void edit(Aluno novoAluno, Long id) {
        this.repository.findById(id).map(aluno -> {
           aluno.setNome(novoAluno.getNome());
           aluno.setCpf(novoAluno.getCpf());
           aluno.setRg(novoAluno.getRg());
           aluno.setEndereco(novoAluno.getEndereco());
           aluno.setCurso(novoAluno.getCurso());
           return this.repository.save(aluno);
        });
    }
}
