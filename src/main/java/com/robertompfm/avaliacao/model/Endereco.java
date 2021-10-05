package com.robertompfm.avaliacao.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Embeddable
public class Endereco {

    private String rua;
    private String cidade;
    private String estado;
    private String cep;
}
