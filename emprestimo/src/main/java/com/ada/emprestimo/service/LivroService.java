package com.ada.emprestimo.service;

import com.ada.emprestimo.dto.LivroDto;
import reactor.core.publisher.Flux;

public interface LivroService {
	LivroDto retornaDadosLivro(int idLivro);
	Flux<LivroDto> livrosDisponiveis();
	void gerenciamentoEstoque(int idLivro, String tipoTransacao);
}
