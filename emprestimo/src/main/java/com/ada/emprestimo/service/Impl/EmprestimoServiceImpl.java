package com.ada.emprestimo.service.Impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import com.ada.emprestimo.dtos.response.ClienteEmprestimoResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ada.emprestimo.model.Emprestimo;
import com.ada.emprestimo.model.EmprestimoLivro;
import com.ada.emprestimo.model.dto.ClienteDto;
import com.ada.emprestimo.model.dto.LivroDto;
import com.ada.emprestimo.repository.EmprestimoLivroRepository;
import com.ada.emprestimo.repository.EmprestimoRepository;
import com.ada.emprestimo.request.DevolucaoEmprestimoDTO;
import com.ada.emprestimo.request.EmprestimoCadastroDTO;
import com.ada.emprestimo.request.LivroCadastroDto;
import com.ada.emprestimo.service.ClienteService;
import com.ada.emprestimo.service.EmprestimoService;
import com.ada.emprestimo.service.LivroService;
import com.ada.emprestimo.util.Status;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmprestimoServiceImpl implements EmprestimoService {

	private final EmprestimoRepository emprestimoRepository;
    private final EmprestimoLivroRepository emprestimoLivroRepository;
    private final ClienteService clienteService;
    private final LivroService livroService;

	@Override
	public Emprestimo save(EmprestimoCadastroDTO emprestimoCadastroDTO) {

		Emprestimo emprestimo = new Emprestimo();

		ClienteDto clienteDto = clienteService.retornaDadosCliente(emprestimoCadastroDTO.getCliente().getIdCliente());
		emprestimo.setIdCliente(clienteDto.getId());

		emprestimo.setDataEmprestimo(LocalDate.now());
		emprestimo.setDataDevolucao(emprestimo.getDataEmprestimo().plusDays(5));
		emprestimo.setQuantidade(1);
		emprestimo.setStatus(Status.EMPRESTADO.getStatus());
		emprestimo.setProtocolo(numberProtocol());

		for (LivroCadastroDto livroEmprestimo: emprestimoCadastroDTO.getLivros()) {
			EmprestimoLivro emprestimoLivro = new EmprestimoLivro();
			LivroDto livroDto = livroService.retornaDadosLivro(livroEmprestimo.getIdLivros());
			emprestimoLivro.setIdLivros(livroDto.getId());
			emprestimoLivro.setProtocolo(emprestimo.getProtocolo());
			emprestimoLivroRepository.save(emprestimoLivro);
		}

		return emprestimoRepository.save(emprestimo);
	}

	private Integer numberProtocol(){
		Random gerador = new Random();
		var protocolo = gerador.nextInt();
		if( protocolo <= 0){
			protocolo = protocolo * (-1);
			return protocolo;
		}
		return protocolo;
	}

	public Emprestimo devolucao(DevolucaoEmprestimoDTO devolucaoEmprestimoDTO) {
		Optional<Emprestimo> optionalEmprestimo = emprestimoRepository.findByIdClienteAndStatus(devolucaoEmprestimoDTO.getCliente().getIdCliente(), Status.EMPRESTADO.getStatus());
		if (optionalEmprestimo.isPresent()){
			Emprestimo emprestimoBD = optionalEmprestimo.get();
			emprestimoBD.setStatus(Status.DEVOLVIDO.toString());
			emprestimoRepository.save(emprestimoBD);
		}
//		int protocolo = emprestimo.getProtocolo();
		
		for (LivroCadastroDto livroEmprestimo: devolucaoEmprestimoDTO.getLivros()) {
			Emprestimo emprestimoBD = optionalEmprestimo.get();
			int idLivro = livroEmprestimo.getIdLivros();
			Optional<EmprestimoLivro> optionalEmprestimoLivro = emprestimoLivroRepository.findByIdLivrosAndProtocolo(idLivro, emprestimoBD.getProtocolo());
			if (optionalEmprestimoLivro.isPresent()){
				EmprestimoLivro emprestimoLivro = optionalEmprestimoLivro.get();
				int idLivroEmprestimo = emprestimoLivro.getId();
				emprestimoLivroRepository.deleteById(idLivroEmprestimo);
				
			}
			System.out.println(idLivro);
		}
		return optionalEmprestimo.get();
		
	}


	public List<Emprestimo> getAll() {
		return emprestimoRepository.findAll();
	}

	@Override
	public ResponseEntity<ClienteEmprestimoResponseDTO> getEmprestimosByIdCliente(int idCliente) {
		List<Emprestimo> emprestimos = emprestimoRepository.findByIdCliente(idCliente);
		return null;
	}
}
