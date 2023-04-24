package com.ada.cliente.services;

import com.ada.cliente.exception.NotFoundException;
import com.ada.cliente.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    Cliente save(Cliente cliente);
    List<Cliente> getAll();
    Optional<Cliente> getById(int id) throws NotFoundException;
    Cliente update(int id, Cliente cliente);
    void delete(int id);

}
