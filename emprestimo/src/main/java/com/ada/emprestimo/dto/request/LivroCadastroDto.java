package com.ada.emprestimo.dto.request;

import com.ada.emprestimo.dto.LivroDto;
import org.modelmapper.ModelMapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 																											//Inclui todos os Gte e Set
@AllArgsConstructor 																							//Inclui os construtores com todos os paramentros
@NoArgsConstructor 
public class LivroCadastroDto {
    private Integer idLivros;
    
	public LivroDto toModelLivro() {											// Ele irá converter apenas os ATRIBUTOS em COMUM das CLASSES
		ModelMapper mapper = new ModelMapper();
		return mapper.map(this, LivroDto.class);
	}
}
