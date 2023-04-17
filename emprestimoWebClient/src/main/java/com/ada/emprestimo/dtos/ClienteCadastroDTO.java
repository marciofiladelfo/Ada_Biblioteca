package com.ada.emprestimo.dtos;

import org.modelmapper.ModelMapper;

import com.ada.emprestimo.model.Cliente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 																											//Inclui todos os Gte e Set
@AllArgsConstructor 																							//Inclui os construtores com todos os paramentros
@NoArgsConstructor 
public class ClienteCadastroDTO {
	private Integer id;
	
	public Cliente toModelEstoque() {											// Ele irá converter apenas os ATRIBUTOS em COMUM das CLASSES
		ModelMapper mapper = new ModelMapper();
		return mapper.map(this, Cliente.class);
	}
}
