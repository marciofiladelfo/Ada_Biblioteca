package com.ada.emprestimo.service;

import com.ada.emprestimo.dtos.EmprestimoDtoCadastro;
import com.ada.emprestimo.model.Emprestimo;

public interface EmprestimoService {
	
	public EmprestimoDtoCadastro save(Emprestimo emprestimo);
}
