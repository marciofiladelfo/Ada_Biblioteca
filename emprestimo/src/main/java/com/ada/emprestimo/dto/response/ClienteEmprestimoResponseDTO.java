package com.ada.emprestimo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteEmprestimoResponseDTO {
    private String nome;
    private String contato;
    private String email;
    private Integer idade;
    private String endereco;
    private List<EmprestimoResponseDTO> emprestimos;

}
