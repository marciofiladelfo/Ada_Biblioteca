package com.ada.emprestimo.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LivrosResponseDTO {
    private String nome;
    private String autor;
    private String editora;
    private String descricao;
    private String genero;
}
