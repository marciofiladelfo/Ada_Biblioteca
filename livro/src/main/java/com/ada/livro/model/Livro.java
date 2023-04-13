package com.ada.livro.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Livro {

    private Integer id;
    private String nome;
    private String autor;
    private String categoria;
    private String descricao;
    private Integer quantidade;

}
