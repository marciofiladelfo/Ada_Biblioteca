package com.ada.livro.controller;

import com.ada.livro.dto.request.EstoqueRequest;
import com.ada.livro.dto.response.EstoqueResponse;
import com.ada.livro.model.Livro;
import com.ada.livro.services.LivroService;
import com.ada.livro.util.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("livros")
@RequiredArgsConstructor
public class livroController {

	private final LivroService livroService;
	
	@PostMapping
	public Livro save(@RequestBody Livro livro) {				
		return livroService.save(livro);
	}
	
	@GetMapping
	public List<Livro> getAll() {
		return livroService.getAll();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Optional<Livro>> getById(@PathVariable("id") final Integer id) {
		Optional<Livro> livroEntity = livroService.getById(id);
		return ResponseEntity.ok(livroEntity);
	}
	
	@PutMapping("{id}")
	public Livro updateLivro(@PathVariable int id, @RequestBody Livro livro) {
		return livroService.update(id, livro);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable Integer id) {	
		livroService.delete(id);
	}
	
	@PatchMapping("/{id}/estoque")
	public ResponseEntity<EstoqueResponse> updateEstoque(@PathVariable int id, @RequestHeader Status tipoTransacao, @RequestBody EstoqueRequest estoqueDto) {
		return ResponseEntity.status(HttpStatus.OK).body(livroService.updateEstoque(id, tipoTransacao, estoqueDto.toModelEstoque()));
	}
}
