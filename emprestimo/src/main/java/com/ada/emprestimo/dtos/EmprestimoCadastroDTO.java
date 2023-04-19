package com.ada.emprestimo.dtos;

import org.modelmapper.ModelMapper;

import com.ada.emprestimo.model.Emprestimo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor 
public class EmprestimoCadastroDTO {

    private ClienteCadastroDTO cliente;
    private List<LivroCadastroDto> livros;
}
