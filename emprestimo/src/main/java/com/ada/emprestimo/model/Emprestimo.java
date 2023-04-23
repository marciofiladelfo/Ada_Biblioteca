package com.ada.emprestimo.model;

import java.time.LocalDate;

import com.ada.emprestimo.dto.request.EmprestimoPendenteDevolucaoDTO;
import jakarta.persistence.*;
import org.modelmapper.ModelMapper;

import com.ada.emprestimo.dto.request.DevolucaoEmprestimoDTO;
import com.ada.emprestimo.dto.request.EmprestimoCadastroDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 																						
@AllArgsConstructor 																		
@NoArgsConstructor 																			
@Entity 																					
@Table(name="EMPRESTIMO")
public class Emprestimo {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id_emprestimo")
    private Integer id;
	@JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataEmprestimo;
	@JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataDevolucao;
	@Column(name = "quantidade_emprestimo")
    private Integer quantidade;
    private String status;

	private Integer protocolo;
    private Integer idCliente;

	public EmprestimoCadastroDTO toResponse() {
		ModelMapper mapper = new ModelMapper();
		EmprestimoCadastroDTO dto = mapper.map(this, EmprestimoCadastroDTO.class);
		return dto;
	}
	
	public DevolucaoEmprestimoDTO toRequestDevolucao() {
		ModelMapper mapper = new ModelMapper();
		DevolucaoEmprestimoDTO dto = mapper.map(this, DevolucaoEmprestimoDTO.class);
		return dto;
	}

	public EmprestimoPendenteDevolucaoDTO toRequestPendenteDevolucao() {
		ModelMapper mapper = new ModelMapper();
		EmprestimoPendenteDevolucaoDTO dto = mapper.map(this, EmprestimoPendenteDevolucaoDTO.class);
		return dto;
	}
}
