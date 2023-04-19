package com.ada.emprestimo.service.Impl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ada.emprestimo.dtos.EmprestimoCadastroDTO;
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

	@Override
	public EmprestimoCadastroDTO save(Emprestimo emprestimo) {

		Cliente cliente = clienteService.getOne(emprestimo.getCliente().getId());
		emprestimo.setCliente(cliente);

		Livro livro = livroService.getOne(emprestimo.getLivro().getId());
		emprestimo.setLivro(livro);

		emprestimo.setDataEmprestimo(LocalDate.now());
		emprestimo.setDataDevolucao(emprestimo.getDataEmprestimo().plusDays(5));
		emprestimo.setQuantidade(1);
		emprestimo.setStatus("Emprestado");
		emprestimo.setProtocolo(1231223345);

		return emprestimoRepository.save(emprestimo).toResponse();
	}
}
