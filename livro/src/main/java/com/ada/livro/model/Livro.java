package com.ada.livro.model;

import org.modelmapper.ModelMapper;

import com.ada.livro.dtos.EstoqueDto;

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
    
	public EstoqueDto toDTOEstoque() {												// Ele irá converter apenas os ATRIBUTOS em COMUM das CLASSES
		ModelMapper mapper = new ModelMapper();
		EstoqueDto dto = mapper.map(this, EstoqueDto.class);
		return dto;
	}

}
