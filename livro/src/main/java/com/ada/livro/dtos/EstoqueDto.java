package com.ada.livro.dtos;

import org.modelmapper.ModelMapper;

import com.ada.livro.model.Livro;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 																											//Inclui todos os Gte e Set
@AllArgsConstructor 																							//Inclui os construtores com todos os paramentros
@NoArgsConstructor 
public class EstoqueDto {
    private Integer quantidade;
    
	public Livro toModelEstoque() {											// Ele irá converter apenas os ATRIBUTOS em COMUM das CLASSES
		ModelMapper mapper = new ModelMapper();
		return mapper.map(this, Livro.class);
	}
}
