package com.ada.emprestimo.service.Impl;

import com.ada.emprestimo.dto.ClienteDto;
import com.ada.emprestimo.service.ClienteService;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Override
    public ClienteDto retornaDadosCliente(int idCliente) {
        String url = "http://localhost:8080";
        String uri = "clientes/{id}";

        return WebClient
                .create(url)
                .get()
                .uri(uri, idCliente)
                .retrieve()
                .bodyToMono(ClienteDto.class).block();
    }
}
