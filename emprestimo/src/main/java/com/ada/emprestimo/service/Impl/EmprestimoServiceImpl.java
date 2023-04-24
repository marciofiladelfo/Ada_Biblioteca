package com.ada.emprestimo.service.Impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import com.ada.emprestimo.dto.response.ClienteEmprestimoResponseDTO;
import com.ada.emprestimo.dto.response.EmprestimoResponseDTO;
import com.ada.emprestimo.dto.response.LivrosResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ada.emprestimo.model.Emprestimo;
import com.ada.emprestimo.model.EmprestimoLivro;
import com.ada.emprestimo.dto.ClienteDto;
import com.ada.emprestimo.dto.LivroDto;
import com.ada.emprestimo.repository.EmprestimoLivroRepository;
import com.ada.emprestimo.repository.EmprestimoRepository;
import com.ada.emprestimo.dto.request.DevolucaoEmprestimoDTO;
import com.ada.emprestimo.dto.request.EmprestimoCadastroDTO;
import com.ada.emprestimo.dto.request.LivroCadastroDto;
import com.ada.emprestimo.service.ClienteService;
import com.ada.emprestimo.service.EmprestimoService;
import com.ada.emprestimo.service.LivroService;
import com.ada.emprestimo.util.Status;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

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
			emprestimoLivro.setIdLivro(livroDto.getId());
			emprestimoLivro.setProtocolo(emprestimo.getProtocolo());
			emprestimoLivroRepository.save(emprestimoLivro);
		}

		return emprestimoRepository.save(emprestimo);
	}

	public Emprestimo devolucao(DevolucaoEmprestimoDTO devolucaoEmprestimoDTO) {
		Optional<Emprestimo> optionalEmprestimo = emprestimoRepository.findByIdClienteAndStatus(devolucaoEmprestimoDTO.getCliente().getIdCliente(), Status.EMPRESTADO.getStatus());
		if (optionalEmprestimo.isPresent()){
			Emprestimo emprestimoBD = optionalEmprestimo.get();
			emprestimoBD.setStatus(Status.DEVOLVIDO.toString());
			emprestimoRepository.save(emprestimoBD);
		}

		for (LivroCadastroDto livroEmprestimo: devolucaoEmprestimoDTO.getLivros()) {
			Emprestimo emprestimoBD = optionalEmprestimo.get();
			int idLivro = livroEmprestimo.getIdLivros();
			Optional<EmprestimoLivro> optionalEmprestimoLivro = emprestimoLivroRepository.findByIdLivroAndProtocolo(idLivro, emprestimoBD.getProtocolo());
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
		ClienteEmprestimoResponseDTO response = new ClienteEmprestimoResponseDTO();
		List<EmprestimoResponseDTO> emprestimosResponse = new ArrayList<>();
		EmprestimoResponseDTO emprestimoResponseDTO;

		ClienteDto dadosCliente = clienteService.retornaDadosCliente(idCliente);
		response.setNome(dadosCliente.getNome());
		response.setContato(dadosCliente.getTelefone());
		response.setEmail(dadosCliente.getEmail());
		response.setIdade(dadosCliente.getIdade());
		response.setEndereco(dadosCliente.getEndereco());

		List<Emprestimo> emprestimos = emprestimoRepository.findByIdCliente(idCliente);
		for (Emprestimo emprestimo : emprestimos) {
			emprestimoResponseDTO = new EmprestimoResponseDTO();
			emprestimoResponseDTO.setProtocoloEmprestimo(emprestimo.getProtocolo());
			emprestimoResponseDTO.setDataEmprestimo(emprestimo.getDataEmprestimo());
			emprestimoResponseDTO.setDataDevolucao(emprestimo.getDataDevolucao());

			List<LivrosResponseDTO> livrosResponseDTO = new ArrayList<>();
			LivrosResponseDTO livroResponseDTO;
			Optional<List<EmprestimoLivro>> emprestimoLivro = emprestimoLivroRepository.findByProtocolo(emprestimo.getProtocolo());
			if(emprestimoLivro.isPresent()){
				for (EmprestimoLivro livro : emprestimoLivro.get()) {
					livroResponseDTO = new LivrosResponseDTO();
					LivroDto livroResponse = livroService.retornaDadosLivro(livro.getIdLivro());
					livroResponseDTO.setNome(livroResponse.getNome());
					livroResponseDTO.setAutor(livroResponse.getAutor());
					livroResponseDTO.setDescricao(livroResponse.getDescricao());
					livroResponseDTO.setCategoria(livroResponse.getCategoria());
					livrosResponseDTO.add(livroResponseDTO);
				}
			}
			emprestimoResponseDTO.setLivros(livrosResponseDTO);
			emprestimosResponse.add(emprestimoResponseDTO);
		}
		response.setEmprestimos(emprestimosResponse);
		return ResponseEntity.ok(response);
	}

	@Override
	public Flux<LivroDto> available() {
		Flux<LivroDto> livroDtoFlux = livroService.livrosDisponiveis();
		return livroDtoFlux.filter(livro -> livro.getQuantidade() > 0);
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
}
