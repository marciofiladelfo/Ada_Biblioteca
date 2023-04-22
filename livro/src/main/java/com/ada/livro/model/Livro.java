package com.ada.livro.model;

import com.ada.livro.dto.response.EstoqueResponse;
import org.modelmapper.ModelMapper;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 																						
@AllArgsConstructor 																		
@NoArgsConstructor 																			
@Entity 																					
@Table(name="LIVRO") 	
public class Livro {

	@Id 																					
	@GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String autor;
    private String categoria;
    private String descricao;
    private Integer quantidade;
    
	public EstoqueResponse toDTOEstoque() {												// Ele irá converter apenas os ATRIBUTOS em COMUM das CLASSES
		ModelMapper mapper = new ModelMapper();
		EstoqueResponse dto = mapper.map(this, EstoqueResponse.class);
		return dto;
	}

}
