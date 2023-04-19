package com.ada.emprestimo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ada.emprestimo.dtos.EmprestimoCadastroDTO;
import com.ada.emprestimo.service.EmprestimoService;

@RestController
@RequestMapping("emprestimos")
public class EmprestimoController {
	@Autowired
	private EmprestimoService emprestimoService;

	@PostMapping()
	public ResponseEntity<EmprestimoCadastroDTO> save(@RequestBody EmprestimoCadastroDTO emprestimoCadastroDTO) {

		return ResponseEntity.status(HttpStatus.OK).body(emprestimoService.save(emprestimoCadastroDTO.toCadastroDTO()));
	}
}
