package com.ada.emprestimo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.ada.emprestimo.model.Livro;
import com.ada.emprestimo.repositories.LivroRepository;

@Service
public class LivroService {
	@Autowired
	LivroRepository livroRepository;
	
	public Livro retornaDadosLivro(int idLivro) {
		String url = "http://localhost:8090";
		String uri = "livros/{id}";
		
		Livro dadosLivro = WebClient
                .create(url)
                .get()
                .uri(uri, idLivro)
                .retrieve()
                .bodyToMono(Livro.class).block();
		save(dadosLivro);
		return dadosLivro;
	}
	
	public Livro getOne(int id) {
		return livroRepository.findById(id).orElse(new Livro());
	}
	
	public Livro save(Livro dadosLivro) {
		System.out.println(dadosLivro);
		return livroRepository.save(dadosLivro);
	}
	
}
