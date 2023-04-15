package com.ada.cliente.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ada.cliente.model.Cliente;
import com.ada.cliente.repositories.ClienteRepository;


@Service
public class ClienteService {
	@Autowired
	ClienteRepository clienteRepository;
	
	public Cliente save(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	public List<Cliente> getAll(){
		return clienteRepository.findAll();
	}
	
	public Cliente getOne(int id) {
		return clienteRepository.findById(id).orElse(new Cliente());
	}
	
	public Cliente update(int id, Cliente cliente) {
		Optional<Cliente> optional = clienteRepository.findById(id);
		if (optional.isPresent() == true){ 
			Cliente clienteBD = optional.get();
			clienteBD.setNome(cliente.getNome());
			clienteBD.setEmail(cliente.getEmail());
			 
			return clienteRepository.save(clienteBD); 
		}
		else {
			return new Cliente();
		}
	}
	
	public void delete(int id) {
		clienteRepository.deleteById(id);
	}
	
}
