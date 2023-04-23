package com.ada.emprestimo.service.Impl;

import com.ada.emprestimo.dto.request.DevolucaoEmprestimoDTO;
import com.ada.emprestimo.dto.request.EmprestimoCadastroDTO;
import com.ada.emprestimo.dto.request.LivroCadastroDto;
import com.ada.emprestimo.dto.response.PendentesDevolucaoResponse;
import com.ada.emprestimo.model.Emprestimo;
import com.ada.emprestimo.model.EmprestimoLivro;
import com.ada.emprestimo.repository.EmprestimoLivroRepository;
import com.ada.emprestimo.repository.EmprestimoRepository;
import com.ada.emprestimo.service.LivroPendenteDevolucaoService;
import com.ada.emprestimo.util.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LivroPendenteDevolucaoServiceImpl implements LivroPendenteDevolucaoService {

    private final EmprestimoRepository emprestimoRepository;

    public List<PendentesDevolucaoResponse> getPendentesDevolucao() {
        List<PendentesDevolucaoResponse> listaPendentes = new ArrayList<>();
        List<Emprestimo> todayEmprestimo = emprestimoRepository.findByDataDevolucao();
        todayEmprestimo.forEach(element -> {
            PendentesDevolucaoResponse pendente = new PendentesDevolucaoResponse();
            pendente.setIdLivro(element.toRequestPendenteDevolucao().getLivro().toModelLivro().getId());
            pendente.setNome(element.toRequestPendenteDevolucao().getLivro().toModelLivro().getNome());
            listaPendentes.add(pendente);
        });

//        for (LivroCadastroDto livroEmprestimo: devolucaoEmprestimoDTO.getLivros()) {
//            Emprestimo emprestimoBD = optionalEmprestimo.get();
//            int idLivro = livroEmprestimo.getIdLivros();
//            Optional<EmprestimoLivro> optionalEmprestimoLivro = emprestimoLivroRepository.findByIdLivrosAndProtocolo(idLivro, emprestimoBD.getProtocolo());
//            if (optionalEmprestimoLivro.isPresent()){
//                EmprestimoLivro emprestimoLivro = optionalEmprestimoLivro.get();
//                int idLivroEmprestimo = emprestimoLivro.getId();
//                emprestimoLivroRepository.deleteById(idLivroEmprestimo);
//
//            }
//            System.out.println(idLivro);
//        }
        return listaPendentes;

    }
}
