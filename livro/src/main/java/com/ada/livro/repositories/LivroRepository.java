package com.ada.livro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ada.livro.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Integer>{

}
