package com.robertompfm.avaliacao.controller;

import com.robertompfm.avaliacao.model.Pessoa;
import com.robertompfm.avaliacao.model.PessoaRequest;
import com.robertompfm.avaliacao.model.PessoaResponse;
import com.robertompfm.avaliacao.service.PessoaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/pessoa")
public class PessoaController {

    private PessoaService service;

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<List<PessoaResponse>> findAll() {
        return ResponseEntity.ok(this.service.findAll());
    }

    @GetMapping("/criterio")
    public ResponseEntity<List<PessoaResponse>> findByCriteria(@RequestParam(name = "nome", required = false) String nome, @RequestParam(name = "curso", required = false) String curso) {
        return ResponseEntity.ok(this.service.findByCriteria(nome, curso));
    }

    @GetMapping("/nome")
    public ResponseEntity<List<PessoaResponse>> findByNome(@RequestParam("nome") String nome) {
        return ResponseEntity.ok(this.service.findByNome(nome));
    }

    @GetMapping("/curso")
    public ResponseEntity<List<PessoaResponse>> findByCurso(@RequestParam("curso") String curso) {
        return ResponseEntity.ok(this.service.findByCurso(curso));
    }

    @PostMapping
    public ResponseEntity<Pessoa> post(@RequestBody PessoaRequest pessoa) {
        return new ResponseEntity<Pessoa>(this.service.save(pessoa), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        this.service.remove(id);
    }

    @PutMapping("/{id}")
    public void put(@RequestBody Pessoa novoAluno, @PathVariable Long id) {
        this.service.edit(novoAluno, id);
    }
}
