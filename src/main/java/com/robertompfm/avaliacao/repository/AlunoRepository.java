package com.robertompfm.avaliacao.repository;

import com.robertompfm.avaliacao.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    List<Aluno> findByNomeIgnoreCaseContainingAndCursoNomeIgnoreCaseContaining(String nome, String curso);

    List<Aluno> findByNomeIgnoreCaseContaining(String nome);

    List<Aluno> findByCursoNomeIgnoreCaseContaining(String curso);
}

