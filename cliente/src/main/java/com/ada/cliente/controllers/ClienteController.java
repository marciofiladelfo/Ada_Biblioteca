package com.ada.cliente.controllers;

import com.ada.cliente.model.Cliente;
import com.ada.cliente.services.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> save(@RequestBody Cliente cliente) {
        Cliente clienteEntity = clienteService.save(cliente);
        return ResponseEntity.ok(clienteEntity);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> getAll() {
        List<Cliente> clienteList = clienteService.getAll();
        return ResponseEntity.ok(clienteList);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getOne(@PathVariable Integer id) {
        Optional<Cliente> clienteEntity = clienteService.getById(id);
        return ResponseEntity.ok(clienteEntity);
    }

    @PutMapping("{id}")
    public ResponseEntity<Cliente> update(@PathVariable Integer id, @RequestBody Cliente cliente) {
        Cliente clienteEntity = clienteService.update(id, cliente);
        return ResponseEntity.ok(clienteEntity);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        clienteService.delete(id);
    }

}
