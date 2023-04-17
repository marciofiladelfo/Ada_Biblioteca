package com.ada.emprestimo.model;

import java.util.List;

import org.modelmapper.ModelMapper;

import com.ada.emprestimo.dtos.ClienteCadastroDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 																						
@AllArgsConstructor 																		
@NoArgsConstructor 																			
@Entity 																					//@Entity é o mapeamento entre a classe e tabela
@Table(name="CLIENTES") 
public class Cliente {		
	
	@Id 	
	@Column(name = "id_cliente")
    private Integer id;
	@Column(name = "nome_cliente")
    private String nome;
    private Integer idade;
    private String telefone;
    private String endereco;
    private String email;
    
	@JsonIgnore
	@OneToMany(mappedBy = "cliente")
	private List<Emprestimo> emprestimo;
	
	public ClienteCadastroDTO toClienteCadastroDTO() {												
		ModelMapper mapper = new ModelMapper();
		ClienteCadastroDTO dto = mapper.map(this, ClienteCadastroDTO.class);
		return dto;
	}
}
