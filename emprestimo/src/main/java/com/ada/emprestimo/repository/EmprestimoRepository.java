package com.ada.emprestimo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ada.emprestimo.model.Emprestimo;
import com.ada.emprestimo.util.Status;

@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Integer> {
	Optional<Emprestimo> findByIdClienteAndStatus(int idCliente, String status);
	@Query("SELECT c FROM Emprestimo c WHERE c.dataDevolucao <= CURRENT_DATE")
	List<Emprestimo> findByDataDevolucao();
	List<Emprestimo> findByIdCliente(int idCliente);
}
