package com.ada.livro.services;

import com.ada.livro.dto.response.EstoqueResponse;
import com.ada.livro.exception.NotFoundException;
import com.ada.livro.model.Livro;
import com.ada.livro.util.Status;

import java.util.List;
import java.util.Optional;

public interface LivroService {

    Livro save(Livro livro);
    List<Livro> getAll();
    Optional<Livro> getById(int id) throws NotFoundException;
    Livro update(int id, Livro livro);
    EstoqueResponse updateEstoque(int id, String tipoTransacao);
    void delete(int id);
}
