package com.ada.emprestimo.services;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ada.emprestimo.dtos.EmprestimoDtoCadastro;
import com.ada.emprestimo.model.Cliente;
import com.ada.emprestimo.model.Emprestimo;
import com.ada.emprestimo.model.Livro;
import com.ada.emprestimo.repositories.EmprestimoRepository;

@Service
public class EmprestimoService {
	@Autowired
	EmprestimoRepository emprestimoRepository;
	
	@Autowired
	ClienteService clienteService;
	
	@Autowired
	LivroService livroService;
	
	public EmprestimoDtoCadastro save(Emprestimo emprestimo) {

		Cliente cliente = clienteService.getOne(emprestimo.getCliente().getId());
		emprestimo.setCliente(cliente);
		Livro livroBD = new Livro();

		
		emprestimo.getLivro().forEach(livro ->{
			Livro livro2 = livroService.getOne(livro.getId());
		});
				
		clienteService.retornaDadosCliente(101);
		livroService.retornaDadosLivro(101);
		Emprestimo emprestimo2 = new Emprestimo();
		//Cliente
		emprestimo2.setCliente(clienteService.retornaDadosCliente(101));
		//Livro
		emprestimo2.getLivro().forEach(livro ->{
			livro.setId(1);
			livro.setNome("sa");
			livro.setAutor("sasa");
			livro.setDescricao("sasasasa");
			livro.setCategoria("sasasasassas");
			livro.setQuantidade(1);
		});
		//Emprestimo
		emprestimo2.setDataEmprestimo(LocalDate.now());
		emprestimo2.setDataDevolucao(emprestimo2.getDataEmprestimo().plusDays(5));
		emprestimo2.setQuantidade(1);
		emprestimo2.setStatus("Emprestado");
		
		
		
		//emprestimo.getCliente().getEmprestimo();
		//livroService.retornaDadosLivro(101);
		return emprestimoRepository.save(emprestimo2).toEmprestimoDtoCadastro();
	}
	
}
