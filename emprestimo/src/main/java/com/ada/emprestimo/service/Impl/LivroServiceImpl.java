package com.ada.emprestimo.service.Impl;

import com.ada.emprestimo.dto.LivroDto;
import com.ada.emprestimo.service.LivroService;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
public class LivroServiceImpl implements LivroService {

    private final String URL = "http://localhost:8090";
    private final String URI = "livros";
    @Override
    public LivroDto retornaDadosLivro(int idLivro) {
        return WebClient
                .create(URL)
                .get()
                .uri(URI + "/{id}", idLivro)
                .retrieve()
                .bodyToMono(LivroDto.class).block();
    }
    @Override
    public Flux<LivroDto> livrosDisponiveis() {
        return WebClient
                .create(URL)
                .get()
                .uri(URI)
                .retrieve()
                .bodyToFlux(LivroDto.class);
    }
}
