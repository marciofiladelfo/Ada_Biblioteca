package com.ada.emprestimo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ada.emprestimo.dtos.EmprestimoDtoCadastro;
import com.ada.emprestimo.services.EmprestimoService;

@RestController
@RequestMapping("clientes")
public class EmprestimoController {
	@Autowired
	private EmprestimoService emprestimoService;

	@PostMapping()
	public ResponseEntity<EmprestimoDtoCadastro> save(@RequestBody EmprestimoDtoCadastro emprestimoDtoCadastro) {
		return ResponseEntity.status(HttpStatus.OK).body(emprestimoService.save(emprestimoDtoCadastro.toModelEmprestimo()));
	}
}
