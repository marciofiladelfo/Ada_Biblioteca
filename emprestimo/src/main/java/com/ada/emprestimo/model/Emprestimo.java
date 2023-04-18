package com.ada.emprestimo.model;

import java.time.LocalDate;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.ada.emprestimo.dtos.EmprestimoDtoCadastro;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
    
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

	@OneToMany(mappedBy = "emprestimo")
	private List<Livro> livro;
    
	public EmprestimoDtoCadastro toEmprestimoDtoCadastro() {												
		ModelMapper mapper = new ModelMapper();
		EmprestimoDtoCadastro dto = mapper.map(this, EmprestimoDtoCadastro.class);
		return dto;
	}
}
