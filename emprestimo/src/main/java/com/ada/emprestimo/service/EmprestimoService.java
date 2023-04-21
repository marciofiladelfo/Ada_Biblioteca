package com.ada.emprestimo.service;

import java.util.List;

import com.ada.emprestimo.request.EmprestimoCadastroDTO;
import com.ada.emprestimo.model.Emprestimo;

public interface EmprestimoService {
	
	public Emprestimo save(EmprestimoCadastroDTO emprestimoCadastroDTO);
	public List<Emprestimo> getAll();
}
