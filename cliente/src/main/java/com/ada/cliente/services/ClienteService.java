package com.ada.cliente.services;

import com.ada.cliente.model.Cliente;

import java.util.List;

public interface ClienteService {

    Cliente save(Cliente cliente);
    List<Cliente> getAll();
    Cliente getOne(int id);
    Cliente update(int id, Cliente cliente);
    void delete(int id);

}
