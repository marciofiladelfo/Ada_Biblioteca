package com.ada.emprestimo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LivroDto {

    private Integer id;
    private String nome;
    private String autor;
    private String categoria;
    private String descricao;
    private Integer quantidade;

}
