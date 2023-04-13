package com.ada.emprestimo.model;

import com.ada.cliente.model.Cliente;
import com.ada.emprestimo.util.Status;
import com.ada.livro.model.Livro;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Emprestimo {

    private Integer id;
    private Livro id_livro;
    private Cliente id_cliente;
    private Date dataEmprestimo;
    private Date dataDevolucao;
    private Integer quantidade;
    private Status status;
}
