package com.robertompfm.avaliacao.repository;

import com.robertompfm.avaliacao.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

}
