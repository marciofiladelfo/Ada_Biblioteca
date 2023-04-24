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
    public ResponseEntity<Livro> save(@RequestBody Livro livro) {
        Livro livroEntity = livroService.save(livro);
        return ResponseEntity.ok(livroEntity);
    }

    @GetMapping
    public ResponseEntity<List<Livro>> getAll() {
        List<Livro> livroList = livroService.getAll();
        return ResponseEntity.ok(livroList);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Livro>> getById(@PathVariable("id") final Integer id) {
        Optional<Livro> livroEntity = livroService.getById(id);
        return ResponseEntity.ok(livroEntity);
    }

    @PutMapping("{id}")
    public ResponseEntity<Livro> updateLivro(@PathVariable int id, @RequestBody Livro livro) {
        Livro livroEntity = livroService.update(id, livro);
        return ResponseEntity.ok(livroEntity);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        livroService.delete(id);
    }

    @PatchMapping("/{id}/estoque")
    public ResponseEntity<EstoqueResponse> updateEstoque(@PathVariable int id, @RequestHeader String tipoTransacao) {
        return ResponseEntity.status(HttpStatus.OK).body(livroService.updateEstoque(id, tipoTransacao));
    }
}
