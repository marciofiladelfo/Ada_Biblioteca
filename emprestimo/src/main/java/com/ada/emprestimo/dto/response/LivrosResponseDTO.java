package com.ada.emprestimo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LivrosResponseDTO {
    private String nome;
    private String autor;
    private String categoria;
    private String descricao;
}
