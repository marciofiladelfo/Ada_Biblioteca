package com.ada.cliente.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ada.cliente.model.Cliente;
import com.ada.cliente.services.ClienteService;


@RestController
@RequestMapping("clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@PostMapping ("")
	public Cliente save(@RequestBody Cliente cliente) {				
		return clienteService.save(cliente);
	}
	
	@GetMapping("")
	public List<Cliente> getAll() {
		return clienteService.getAll();
	}
	
	@GetMapping("{id}")
	public Cliente getOne(@PathVariable Integer id) {							
		return clienteService.getOne(id);
	}
	
	@PutMapping("{id}")
	public Cliente update(@PathVariable int id, @RequestBody Cliente cliente) {
		return clienteService.update(id, cliente);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable Integer id) {
		clienteService.delete(id);
	}
}
