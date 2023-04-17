package com.ada.emprestimo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ada.emprestimo.model.Emprestimo;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Integer>{

}
