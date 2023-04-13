package com.ada.cliente.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cliente {

    private Integer id;
    private String nome;
    private Integer idade;
    private String telefone;
    private String endereco;
    private String email;
}
