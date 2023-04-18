package com.ada.emprestimo.service;

import com.ada.emprestimo.model.Livro;

public interface LivroService {
	public Livro retornaDadosLivro(int idLivro);
	public Livro getOne(int id);
	public Livro save(Livro dadosLivro);
}
