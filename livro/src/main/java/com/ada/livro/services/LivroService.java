package com.ada.livro.services;

import com.ada.livro.dtos.EstoqueDto;
import com.ada.livro.model.Livro;

import java.util.List;

public interface LivroService {

    Livro save(Livro livro);
    List<Livro> getAll();
    Livro getOne(int id);
    Livro update(int id, Livro livro);
    EstoqueDto updateEstoque(int id, int tipoTransacao, Livro livro);
    void delete(int id);

}
