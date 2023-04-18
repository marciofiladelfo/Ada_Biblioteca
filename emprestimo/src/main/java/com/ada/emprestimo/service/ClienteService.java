package com.ada.emprestimo.service;

import com.ada.emprestimo.model.Cliente;

public interface ClienteService {
	public Cliente retornaDadosCliente(int idCliente);
	public Cliente getOne(int id);
	public Cliente save(Cliente dadosCliente);
}
