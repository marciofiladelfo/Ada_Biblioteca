package com.ada.emprestimo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PendentesDevolucaoResponse {

    private Integer idLivro;
    private String nome;


}
