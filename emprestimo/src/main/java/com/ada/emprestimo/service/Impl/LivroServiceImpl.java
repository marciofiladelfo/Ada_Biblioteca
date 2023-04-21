package com.ada.emprestimo.service.Impl;

import com.ada.emprestimo.model.dto.LivroDto;
import com.ada.emprestimo.service.LivroService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class LivroServiceImpl implements LivroService {

    private LivroDto livro;

    @Override
    public LivroDto retornaDadosLivro(int idLivro) {
        String url = "http://localhost:8090";
        String uri = "livros/{id}";

        livro = WebClient
                .create(url)
                .get()
                .uri(uri, idLivro)
                .retrieve()
                .bodyToMono(LivroDto.class).block();
        return livro;
    }
}
