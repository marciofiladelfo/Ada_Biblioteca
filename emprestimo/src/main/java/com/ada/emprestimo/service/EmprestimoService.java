package com.ada.emprestimo.service;

import com.ada.emprestimo.dtos.EmprestimoCadastroDTO;
import com.ada.emprestimo.model.Emprestimo;

public interface EmprestimoService {
	
	public EmprestimoCadastroDTO save(EmprestimoCadastroDTO emprestimoCadastroDTO);
}
