package com.ada.emprestimo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmprestimoResponseDTO {
    private String protocoloEmprestimo;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private List<LivrosResponseDTO> livros;
}
