package com.ada.emprestimo.model;

import org.modelmapper.ModelMapper;

import com.ada.emprestimo.dtos.LivroCadastroDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	@Column(name = "id_livro")
    private Integer id;
	@Column(name = "nome_livro")
    private String nome;
    private String autor;
    private String categoria;
    private String descricao;
	@Column(name = "quantidade_livro")
    private Integer quantidade;
	
    @ManyToOne
    @JoinColumn(name = "id_emprestimo")
    private Emprestimo emprestimo;
	
	public LivroCadastroDto toLivroCadastroDto() {												
		ModelMapper mapper = new ModelMapper();
		LivroCadastroDto dto = mapper.map(this, LivroCadastroDto.class);
		return dto;
	}
}
