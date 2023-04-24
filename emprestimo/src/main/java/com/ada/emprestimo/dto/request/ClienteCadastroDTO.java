package com.ada.emprestimo.dto.request;

import com.ada.emprestimo.dto.ClienteDto;
import org.modelmapper.ModelMapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 																											//Inclui todos os Gte e Set
@AllArgsConstructor 																							//Inclui os construtores com todos os paramentros
@NoArgsConstructor 
public class ClienteCadastroDTO {
	private Integer idCliente;
	
	public ClienteDto toModelEstoque() {											// Ele irá converter apenas os ATRIBUTOS em COMUM das CLASSES
		ModelMapper mapper = new ModelMapper();
		return mapper.map(this, ClienteDto.class);
	}
}
