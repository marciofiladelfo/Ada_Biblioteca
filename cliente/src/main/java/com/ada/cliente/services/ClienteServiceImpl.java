package com.ada.cliente.services;

import com.ada.cliente.exception.NotFoundException;
import com.ada.cliente.model.Cliente;
import com.ada.cliente.repositories.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Override
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public List<Cliente> getAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> getById(Integer id) {
        verifyClienteExist(id);
        return clienteRepository.findById(id);
    }

    @Override
    public Cliente update(Integer id, Cliente cliente) {
        Optional<Cliente> optional = clienteRepository.findById(id);
        if (optional.isPresent()) {
            Cliente clienteBD = optional.get();
            clienteBD.setNome(cliente.getNome());
            clienteBD.setEmail(cliente.getEmail());

            return clienteRepository.save(clienteBD);
        }
        return new Cliente();
    }

    @Override
    public void delete(int id) {
        verifyClienteExist(id);
        clienteRepository.deleteById(id);
    }

    private void verifyClienteExist(Integer id) {
        if (clienteRepository.findById(id).isEmpty()) {
            throw new NotFoundException("Cliente não encontrado ID: " + id);
        }
    }

}
