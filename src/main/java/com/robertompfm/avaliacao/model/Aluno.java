package com.robertompfm.avaliacao.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cpf;
    private String rg;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @Embedded
    private Endereco endereco;

}
