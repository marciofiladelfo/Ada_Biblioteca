package com.ada.emprestimo.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;
import org.modelmapper.ModelMapper;

import com.ada.emprestimo.dtos.EmprestimoCadastroDTO;
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

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

	@OneToMany(mappedBy = "emprestimo")
	private List<Livro> livros;

	public EmprestimoCadastroDTO toResponse() {
		ModelMapper mapper = new ModelMapper();
		EmprestimoCadastroDTO dto = mapper.map(this, EmprestimoCadastroDTO.class);
		return dto;
	}
}
