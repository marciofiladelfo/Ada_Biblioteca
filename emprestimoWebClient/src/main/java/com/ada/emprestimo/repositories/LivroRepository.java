package com.ada.emprestimo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ada.emprestimo.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Integer>{

}
