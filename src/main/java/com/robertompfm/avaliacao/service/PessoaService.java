package com.robertompfm.avaliacao.service;

import com.robertompfm.avaliacao.model.Pessoa;
import com.robertompfm.avaliacao.model.PessoaRequest;
import com.robertompfm.avaliacao.model.PessoaResponse;
import com.robertompfm.avaliacao.repository.PessoaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PessoaService {
    private final PessoaRepository repository;

    public Pessoa save(PessoaRequest dto) { return this.repository.save(convertePessoaRequestParaPessoa(dto)); }

    public List<PessoaResponse> findAll() {
        return this.repository.findAll()
                .stream()
                .map(p-> convertePessoaResponse(p))
                .collect(Collectors.toList());
    }

    public List<PessoaResponse> findByCriteria(String nome, String curso) {
        if (nome == null) {
            nome = "";
        }
        if (curso == null) {
            curso = "";
        }
        return this.repository.findByNomeIgnoreCaseContainingAndCursoIgnoreCaseContaining(nome, curso)
                .stream()
                .map(p-> convertePessoaResponse(p))
                .collect(Collectors.toList());
    }

    public List<PessoaResponse> findByNome(String nome) { return this.repository.findByNomeIgnoreCaseContaining(nome)
            .stream()
            .map(p-> convertePessoaResponse(p))
            .collect(Collectors.toList()); }

    public List<PessoaResponse> findByCurso(String nome) { return this.repository.findByCursoIgnoreCaseContaining(nome)
            .stream()
            .map(p-> convertePessoaResponse(p))
            .collect(Collectors.toList()); }

    public void remove(Long id) { this.repository.deleteById(id); }

    public void edit(Pessoa novoAluno, Long id) {
        this.repository.findById(id).map(aluno -> {
           aluno.setNome(novoAluno.getNome());
           aluno.setCurso(novoAluno.getCurso());
           aluno.setEmail(novoAluno.getEmail());
           aluno.setTelefone(novoAluno.getTelefone());
           return this.repository.save(aluno);
        });
    }

    private Pessoa convertePessoaRequestParaPessoa(PessoaRequest dto) {
        return Pessoa.builder()
                .nome(dto.getNome())
                .email(dto.getEmail())
                .telefone(dto.getTelefone())
                .curso(dto.getCurso())
                .build();
    }

    private PessoaResponse convertePessoaResponse(Pessoa pessoa) {
        return PessoaResponse.builder()
                .nome(pessoa.getNome())
                .email(pessoa.getEmail())
                .telefone(pessoa.getTelefone())
                .curso(pessoa.getCurso())
                .build();
    }

}
