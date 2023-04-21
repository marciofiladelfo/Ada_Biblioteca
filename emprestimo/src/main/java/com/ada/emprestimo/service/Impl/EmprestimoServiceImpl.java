package com.ada.emprestimo.service.Impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import com.ada.emprestimo.model.EmprestimoLivro;
import com.ada.emprestimo.repository.EmprestimoLivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ada.emprestimo.request.EmprestimoCadastroDTO;
import com.ada.emprestimo.request.LivroCadastroDto;
import com.ada.emprestimo.model.dto.ClienteDto;
import com.ada.emprestimo.model.Emprestimo;
import com.ada.emprestimo.model.dto.LivroDto;
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
	EmprestimoLivroRepository emprestimoLivroRepository;

	@Autowired
	ClienteService clienteService;

	@Autowired
	LivroService livroService;

	@Override
	public Emprestimo save(EmprestimoCadastroDTO emprestimoCadastroDTO) {

		Emprestimo emprestimo = new Emprestimo();

		ClienteDto clienteDto = clienteService.retornaDadosCliente(emprestimoCadastroDTO.getCliente().getIdCliente());
		emprestimo.setIdCliente(clienteDto.getId());

		emprestimo.setDataEmprestimo(LocalDate.now());
		emprestimo.setDataDevolucao(emprestimo.getDataEmprestimo().plusDays(5));
		emprestimo.setQuantidade(1);
		emprestimo.setStatus(Status.EMPRESTADO.getStatus());
		emprestimo.setProtocolo(numberRandom());

		for (LivroCadastroDto livroEmprestimo: emprestimoCadastroDTO.getLivros()) {
			EmprestimoLivro emprestimoLivro = new EmprestimoLivro();
			LivroDto livroDto = livroService.retornaDadosLivro(livroEmprestimo.getIdLivros());
			emprestimoLivro.setIdLivros(livroDto.getId());
			emprestimoLivro.setProtocolo(emprestimo.getProtocolo());
			emprestimoLivroRepository.save(emprestimoLivro);
		}

		return emprestimoRepository.save(emprestimo);
	}

	private Integer numberRandom(){
		Random gerador = new Random();

		//imprime sequência de 10 números inteiros aleatórios
//		for (int i = 0; i < 10; i++) {
//			gerador.nextInt();
//		}
		return gerador.nextInt();
	}
	
	public List<Emprestimo> getAll() {
		return emprestimoRepository.findAll();
	}
}
