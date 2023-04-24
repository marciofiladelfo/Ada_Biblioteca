package com.ada.emprestimo.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PendenteDevolucaoClienteResponse {

    private Integer idCliente;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataEmprestimo;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataDevolucao;
}
