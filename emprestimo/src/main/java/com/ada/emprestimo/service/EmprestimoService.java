package com.ada.emprestimo.service;

import java.util.List;

import com.ada.emprestimo.model.Emprestimo;
import com.ada.emprestimo.request.DevolucaoEmprestimoDTO;
import com.ada.emprestimo.request.EmprestimoCadastroDTO;

public interface EmprestimoService {
	Emprestimo save(EmprestimoCadastroDTO emprestimoCadastroDTO);
	List<Emprestimo> getAll();
	public Emprestimo devolucao(DevolucaoEmprestimoDTO devolucaoEmprestimoDTO);
}
