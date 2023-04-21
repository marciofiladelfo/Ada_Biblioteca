package com.ada.emprestimo.service.Impl;

import com.ada.emprestimo.model.dto.ClienteDto;
import com.ada.emprestimo.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private ClienteDto clienteDto;

    @Override
    public ClienteDto retornaDadosCliente(int idCliente) {
        String url = "http://localhost:8080";
        String uri = "clientes/{id}";

        clienteDto = WebClient
                .create(url)
                .get()
                .uri(uri, idCliente)
                .retrieve()
                .bodyToMono(ClienteDto.class).block();

        return clienteDto;
    }
}
