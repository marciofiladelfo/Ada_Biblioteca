package com.ada.emprestimo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ada.cliente.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<com.ada.emprestimo.model.Cliente, Integer> {

}
