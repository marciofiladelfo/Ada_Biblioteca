package com.ada.emprestimo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ada.emprestimo.model.Emprestimo;
import com.ada.emprestimo.request.DevolucaoEmprestimoDTO;
import com.ada.emprestimo.request.EmprestimoCadastroDTO;
import com.ada.emprestimo.service.EmprestimoService;

@RestController
@RequestMapping("emprestimos")
public class EmprestimoController {
	@Autowired
	private EmprestimoService emprestimoService;

	@PostMapping()
	public ResponseEntity<Integer> save(@RequestBody EmprestimoCadastroDTO emprestimoCadastroDTO) {
		Emprestimo emprestimo = emprestimoService.save(emprestimoCadastroDTO);
		return ResponseEntity.status(HttpStatus.OK).body(emprestimo.getProtocolo());
	}
	
	@GetMapping("")
	public List<Emprestimo> getAll() {							
		return emprestimoService.getAll();
	}
	
	@PatchMapping("devolucao")
	public ResponseEntity<Integer> updateEstoque(@RequestBody DevolucaoEmprestimoDTO devolucaoEmprestimoDTO) {
		emprestimoService.devolucao(devolucaoEmprestimoDTO);
		return  ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
}
