package com.ada.emprestimo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.ada.emprestimo.model.Cliente;
import com.ada.emprestimo.model.Livro;
import com.ada.emprestimo.repositories.ClienteRepository;


@Service
public class ClienteService {
	@Autowired
	ClienteRepository clienteRepository;
	

	public Cliente retornaDadosCliente(int idCliente) {
		String url = "http://localhost:8080";
		String uri = "clientes/{id}";
		
		Cliente dadosCliente = WebClient
                .create(url)
                .get()
                .uri(uri, idCliente)
                .retrieve()
                .bodyToMono(Cliente.class).block();
		//.block() - sicrona
		save(dadosCliente);
		return dadosCliente;
	}
	
	public Cliente getOne(int id) {
		return clienteRepository.findById(id).orElse(new Cliente());
	}
	
	public Cliente save(Cliente dadosCliente) {
		System.out.println(dadosCliente);
		return clienteRepository.save(dadosCliente);
	}

	
}
