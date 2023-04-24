package com.ada.cliente.services;

import com.ada.cliente.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    Cliente save(Cliente cliente);

    List<Cliente> getAll();

    Optional<Cliente> getById(Integer id);

    Cliente update(Integer id, Cliente cliente);

    void delete(int id);

}
