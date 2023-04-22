package com.ada.emprestimo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ada.emprestimo.model.EmprestimoLivro;

@Repository
public interface EmprestimoLivroRepository extends JpaRepository<EmprestimoLivro, Integer> {

	Optional<EmprestimoLivro> findByIdLivrosAndProtocolo(int idLivros, int protocolo);

}
