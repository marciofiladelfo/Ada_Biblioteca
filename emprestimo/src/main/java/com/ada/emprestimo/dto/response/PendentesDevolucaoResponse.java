package com.ada.emprestimo.dto.response;

import com.ada.emprestimo.model.Emprestimo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PendentesDevolucaoResponse {

    private Integer idLivro;
    private String nome;
    private List<PendenteDevolucaoClienteResponse> clientesPendenteDevolucao;

}
