package com.ada.emprestimo.service.Impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ada.emprestimo.dtos.EmprestimoCadastroDTO;
import com.ada.emprestimo.dtos.LivroCadastroDto;
import com.ada.emprestimo.model.Cliente;
import com.ada.emprestimo.model.Emprestimo;
import com.ada.emprestimo.model.Livro;
import com.ada.emprestimo.repository.EmprestimoRepository;
import com.ada.emprestimo.service.ClienteService;
import com.ada.emprestimo.service.EmprestimoService;
import com.ada.emprestimo.service.LivroService;
import com.ada.emprestimo.util.Status;
@Service

public class EmprestimoServiceImpl implements EmprestimoService {
	@Autowired
	EmprestimoRepository emprestimoRepository;

	@Autowired
	ClienteService clienteService;

	@Autowired
	LivroService livroService;

	@Override
	public EmprestimoCadastroDTO save(EmprestimoCadastroDTO emprestimoCadastroDTO) {

		Emprestimo emprestimo = new Emprestimo();
		emprestimo.setLivros(new ArrayList<>());

		Cliente cliente = clienteService.getOne(emprestimoCadastroDTO.getCliente().getId());
		emprestimo.setCliente(cliente);

		for (LivroCadastroDto livroEmprestimo: emprestimoCadastroDTO.getLivros()) {
			Livro livro = livroService.getOne(livroEmprestimo.getId());
			emprestimo.getLivros().add(livro);
		}

		emprestimo.setDataEmprestimo(LocalDate.now());
		emprestimo.setDataDevolucao(emprestimo.getDataEmprestimo().plusDays(5));
		emprestimo.setQuantidade(1);
		emprestimo.setStatus(Status.EMPRESTADO.getStatus());
		emprestimo.setProtocolo(1231223345);

		return emprestimoRepository.save(emprestimo).toResponse();
	}
	
	public List<Emprestimo> getAll() {
		
		return emprestimoRepository.findAll();
	}
}
