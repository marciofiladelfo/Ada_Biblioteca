package com.ada.emprestimo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ada.emprestimo.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Integer>{

}
