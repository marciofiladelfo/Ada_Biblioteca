package com.ada.emprestimo.service;

import java.util.List;

import com.ada.emprestimo.dtos.response.ClienteEmprestimoResponseDTO;
import com.ada.emprestimo.model.Emprestimo;
import com.ada.emprestimo.request.DevolucaoEmprestimoDTO;
import com.ada.emprestimo.request.EmprestimoCadastroDTO;
import org.springframework.http.ResponseEntity;

public interface EmprestimoService {
	Emprestimo save(EmprestimoCadastroDTO emprestimoCadastroDTO);
	List<Emprestimo> getAll();
	public Emprestimo devolucao(DevolucaoEmprestimoDTO devolucaoEmprestimoDTO);
    ResponseEntity<ClienteEmprestimoResponseDTO> getEmprestimosByIdCliente(int idCliente);
}
