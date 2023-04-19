package com.ada.cliente.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ada.cliente.model.Cliente;
import com.ada.cliente.repositories.ClienteRepository;


@Service
public class ClienteServiceImpl implements ClienteService {
	@Autowired
	ClienteRepository clienteRepository;

	@Override
	public Cliente save(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@Override
	public List<Cliente> getAll(){
		return clienteRepository.findAll();
	}

	@Override
	public Cliente getOne(int id) {
		return clienteRepository.findById(id).orElse(new Cliente());
	}

	@Override
	public Cliente update(int id, Cliente cliente) {
		Optional<Cliente> optional = clienteRepository.findById(id);
		if (optional.isPresent()){
			Cliente clienteBD = optional.get();
			clienteBD.setNome(cliente.getNome());
			clienteBD.setEmail(cliente.getEmail());
			 
			return clienteRepository.save(clienteBD); 
		}
		return new Cliente();
	}

	@Override
	public void delete(int id) {
		clienteRepository.deleteById(id);
	}
	
}
