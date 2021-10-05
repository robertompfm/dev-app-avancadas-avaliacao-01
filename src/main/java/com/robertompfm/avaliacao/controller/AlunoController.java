package com.robertompfm.avaliacao.controller;

import com.robertompfm.avaliacao.model.Aluno;
import com.robertompfm.avaliacao.service.AlunoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/aluno")
public class AlunoController {

    private AlunoService service;

    @GetMapping
    public List<Aluno> findAll() {
        return this.service.findAll();
    }

    @GetMapping("/criterio")
    public List<Aluno> findByCriteria(@RequestParam(name = "nome", required = false) String nome, @RequestParam(name = "curso", required = false) String curso) {
        return this.service.findByCriteria(nome, curso);
    }

    @GetMapping("/nome")
    public List<Aluno> findByNome(@RequestParam("nome") String nome) {
        return this.service.findByNome(nome);
    }

    @GetMapping("/curso")
    public List<Aluno> findByCursoNome(@RequestParam("curso") String curso) {
        return this.service.findByCursoNome(curso);
    }

    @PostMapping
    public void post(@RequestBody Aluno aluno) {
        this.service.save(aluno);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        this.service.remove(id);
    }

    @PutMapping("/{id}")
    public void put(@RequestBody Aluno novoAluno, @PathVariable Long id) {
        this.service.edit(novoAluno, id);
    }
}
