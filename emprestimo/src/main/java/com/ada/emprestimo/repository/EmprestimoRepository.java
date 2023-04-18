package com.ada.emprestimo.repository;

import com.ada.emprestimo.model.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Integer> {


}
