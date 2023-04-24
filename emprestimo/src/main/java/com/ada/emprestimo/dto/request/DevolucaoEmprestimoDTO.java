package com.ada.emprestimo.dto.request;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DevolucaoEmprestimoDTO {
    private ClienteCadastroDTO cliente;
    private List<LivroCadastroDto> livros;

}
