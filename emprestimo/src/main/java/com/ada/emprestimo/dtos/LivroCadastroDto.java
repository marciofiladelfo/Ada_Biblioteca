package com.ada.emprestimo.dtos;

import org.modelmapper.ModelMapper;

import com.ada.emprestimo.model.Livro;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 																											//Inclui todos os Gte e Set
@AllArgsConstructor 																							//Inclui os construtores com todos os paramentros
@NoArgsConstructor 
public class LivroCadastroDto {
    private Integer id;
    
	public com.ada.emprestimo.model.Livro toModelLivro() {											// Ele irá converter apenas os ATRIBUTOS em COMUM das CLASSES
		ModelMapper mapper = new ModelMapper();
		return mapper.map(this, Livro.class);
	}
}
