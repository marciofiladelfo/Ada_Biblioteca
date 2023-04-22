package com.ada.livro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ada.livro.model.Livro;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer>{

}
