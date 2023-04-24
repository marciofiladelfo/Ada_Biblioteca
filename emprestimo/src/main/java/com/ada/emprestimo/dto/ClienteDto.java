package com.ada.emprestimo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDto {

    private Integer id;
    private String nome;
    private Integer idade;
    private String telefone;
    private String endereco;
    private String email;

}
