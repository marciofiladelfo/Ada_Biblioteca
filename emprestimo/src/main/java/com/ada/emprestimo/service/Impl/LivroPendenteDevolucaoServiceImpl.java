package com.ada.emprestimo.service.Impl;

import com.ada.emprestimo.dto.LivroDto;
import com.ada.emprestimo.dto.response.PendenteDevolucaoClienteResponse;
import com.ada.emprestimo.dto.response.PendentesDevolucaoResponse;
import com.ada.emprestimo.exception.NotFoundException;
import com.ada.emprestimo.model.Emprestimo;
import com.ada.emprestimo.model.EmprestimoLivro;
import com.ada.emprestimo.repository.EmprestimoLivroRepository;
import com.ada.emprestimo.repository.EmprestimoRepository;
import com.ada.emprestimo.service.LivroPendenteDevolucaoService;
import com.ada.emprestimo.service.LivroService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LivroPendenteDevolucaoServiceImpl implements LivroPendenteDevolucaoService {

    private final EmprestimoRepository emprestimoRepository;
    private final EmprestimoLivroRepository emprestimoLivroRepository;
    private final LivroService livroService;

    public List<PendentesDevolucaoResponse> getPendentesDevolucao() throws NotFoundException {

        final List<Emprestimo> todayEmprestimo = emprestimoRepository.findByDataDevolucao();
        final List<EmprestimoLivro> emprestimoLivro = emprestimoLivroRepository.findAll();
        final PendentesDevolucaoResponse pendente = new PendentesDevolucaoResponse();

        final List<PendentesDevolucaoResponse> listaPendentes = emprestimoLivro.stream().map(element -> {


            final List<PendenteDevolucaoClienteResponse> listaClientesPendente = new ArrayList<>();
            LivroDto livroDto = livroService.retornaDadosLivro(element.getIdLivro());

            todayEmprestimo.forEach(p -> {
                if (element.getProtocolo().equals(p.getProtocolo())) {
                    final PendenteDevolucaoClienteResponse clientesPendente = new PendenteDevolucaoClienteResponse();
                    pendente.setIdLivro(livroDto.getId());
                    pendente.setNome(livroDto.getNome());

                    clientesPendente.setIdCliente(p.getIdCliente());
                    clientesPendente.setDataEmprestimo(p.getDataEmprestimo());
                    clientesPendente.setDataDevolucao(p.getDataDevolucao());
                    listaClientesPendente.add(clientesPendente);

                }
            });
            pendente.setClientesPendenteDevolucao(listaClientesPendente);
            return pendente;
        }).collect(Collectors.toList());

        if (ObjectUtils.isEmpty(pendente.getClientesPendenteDevolucao())){
            throw new NotFoundException();
        }else{
            return listaPendentes;
        }

    }
}
