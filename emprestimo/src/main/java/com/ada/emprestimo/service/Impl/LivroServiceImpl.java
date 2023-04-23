package com.ada.emprestimo.service.Impl;

import com.ada.emprestimo.dto.LivroDto;
import com.ada.emprestimo.service.LivroService;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class LivroServiceImpl implements LivroService {

    @Override
    public LivroDto retornaDadosLivro(int idLivro) {
        String url = "http://localhost:8090";
        String uri = "livros/{id}";

        return WebClient
                .create(url)
                .get()
                .uri(uri, idLivro)
                .retrieve()
                .bodyToMono(LivroDto.class).block();
    }
}
