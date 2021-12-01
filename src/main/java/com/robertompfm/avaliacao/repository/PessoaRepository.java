package com.robertompfm.avaliacao.repository;

import com.robertompfm.avaliacao.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    List<Pessoa> findByNomeIgnoreCaseContainingAndCursoIgnoreCaseContaining(String nome, String curso);

    List<Pessoa> findByNomeIgnoreCaseContaining(String nome);

    List<Pessoa> findByCursoIgnoreCaseContaining(String curso);
}

