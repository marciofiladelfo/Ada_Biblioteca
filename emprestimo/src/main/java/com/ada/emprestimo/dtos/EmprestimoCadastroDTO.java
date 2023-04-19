package com.ada.emprestimo.dtos;

import org.modelmapper.ModelMapper;

import com.ada.emprestimo.model.Emprestimo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor 
public class EmprestimoCadastroDTO {

    private ClienteCadastroDTO cliente;
    private LivroCadastroDto livro;
    
	public Emprestimo toCadastroDTO() {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(this, Emprestimo.class);
	}
}
