package com.ada.emprestimo.service;

import com.ada.emprestimo.dto.request.DevolucaoEmprestimoDTO;
import com.ada.emprestimo.dto.request.EmprestimoCadastroDTO;
import com.ada.emprestimo.dto.response.ClienteEmprestimoResponseDTO;
import com.ada.emprestimo.model.Emprestimo;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface EmprestimoService {
	Emprestimo save(EmprestimoCadastroDTO emprestimoCadastroDTO);
	List<Emprestimo> getAll();
	public Emprestimo devolucao(DevolucaoEmprestimoDTO devolucaoEmprestimoDTO);
    ResponseEntity<ClienteEmprestimoResponseDTO> getEmprestimosByIdCliente(int idCliente);
}
