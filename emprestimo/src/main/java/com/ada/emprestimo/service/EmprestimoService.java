package com.ada.emprestimo.service;

import com.ada.emprestimo.dto.request.DevolucaoEmprestimoDTO;
import com.ada.emprestimo.dto.request.EmprestimoCadastroDTO;
import com.ada.emprestimo.model.Emprestimo;

import java.util.List;

public interface EmprestimoService {
    Emprestimo save(EmprestimoCadastroDTO emprestimoCadastroDTO);

    List<Emprestimo> getAll();

    Emprestimo devolucao(DevolucaoEmprestimoDTO devolucaoEmprestimoDTO);
}
