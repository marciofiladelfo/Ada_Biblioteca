package com.ada.livro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ada.livro.dtos.EstoqueDto;
import com.ada.livro.model.Livro;
import com.ada.livro.services.LivroService;

@RestController
@RequestMapping("livros")
public class livroController {
	@Autowired
	private LivroService livroService;
	
	@PostMapping ("")
	public Livro save(@RequestBody Livro livro) {				
		return livroService.save(livro);
	}
	
	@GetMapping("")
	public List<Livro> getAll() {
		return livroService.getAll();
	}
	
	@GetMapping("{id}")
	public Livro getOne(@PathVariable Integer id) {							
		return livroService.getOne(id);
	}
	
	@PutMapping("{id}")
	public Livro update(@PathVariable int id, @RequestBody Livro livro) {
		return livroService.update(id, livro);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable Integer id) {	
		livroService.delete(id);
	}
	
	@PatchMapping("{id}")
	public ResponseEntity<EstoqueDto> update(@PathVariable int id, @RequestHeader int tipoTransacao, @RequestBody EstoqueDto estoqueDto) {
		return ResponseEntity.status(HttpStatus.OK).body(livroService.updateEstoque(id, tipoTransacao, estoqueDto.toModelEstoque()));
	}
}
