package com.ada.emprestimo.service.Impl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ada.emprestimo.dtos.EmprestimoDtoCadastro;
import com.ada.emprestimo.model.Cliente;
import com.ada.emprestimo.model.Emprestimo;
import com.ada.emprestimo.model.Livro;
import com.ada.emprestimo.repository.EmprestimoRepository;
import com.ada.emprestimo.service.ClienteService;
import com.ada.emprestimo.service.EmprestimoService;
import com.ada.emprestimo.service.LivroService;
@Service

public class EmprestimoServiceImpl implements EmprestimoService {
	@Autowired
	EmprestimoRepository emprestimoRepository;
	
	@Autowired
	ClienteService clienteService;
	
	@Autowired
	LivroService livroService;
	
	public EmprestimoDtoCadastro save(Emprestimo emprestimo) {

		//Recebendo valores de cliente e salvando no emprestimo
		Cliente cliente = clienteService.getOne(emprestimo.getCliente().getId());
		emprestimo.setCliente(cliente);
		
		//Recebendo valores de livro e salvando no emprestimo
		emprestimo.getLivro().forEach(livro ->{
			Livro livro2 = livroService.getOne(livro.getId());
			livro.setNome(livro2.getNome());
			livro.setAutor(livro2.getAutor());
			livro.setCategoria(livro2.getCategoria());
			livro.setDescricao(livro2.getDescricao());
			livro.setQuantidade(1);
		});
//		clienteService.retornaDadosCliente(101);
//		livroService.retornaDadosLivro(101);
		

		//Emprestimo
		emprestimo.setDataEmprestimo(LocalDate.now());
		emprestimo.setDataDevolucao(emprestimo.getDataEmprestimo().plusDays(5));
		emprestimo.setQuantidade(1);
		emprestimo.setStatus("Emprestado");
		
		
		
		//emprestimo.getCliente().getEmprestimo();
		//livroService.retornaDadosLivro(101);
		return emprestimoRepository.save(emprestimo).toEmprestimoDtoCadastro();
	}
}
