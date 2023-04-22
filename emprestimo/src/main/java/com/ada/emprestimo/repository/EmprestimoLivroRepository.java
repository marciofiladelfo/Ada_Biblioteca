package com.ada.emprestimo.repository;

import com.ada.emprestimo.model.EmprestimoLivro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmprestimoLivroRepository extends JpaRepository<EmprestimoLivro, Integer> {

}
