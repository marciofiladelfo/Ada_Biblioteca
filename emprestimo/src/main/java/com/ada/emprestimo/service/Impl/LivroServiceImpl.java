package com.ada.emprestimo.service.Impl;

import com.ada.emprestimo.dto.LivroDto;
import com.ada.emprestimo.service.LivroService;
import org.springframework.http.MediaType;
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
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(LivroDto.class);
    }
    
    @Override
    public void gerenciamentoEstoque(int idLivro, String tipoTransacao) {
		WebClient
        .create(URL)
        .patch()
        .uri(URI + "/" + idLivro + "/estoque")
        .header("tipoTransacao", tipoTransacao)
        .retrieve()
        .bodyToMono(String.class)
        .subscribe(System.out::println);

    }
}
