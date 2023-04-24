package com.ada.emprestimo.service;

import com.ada.emprestimo.dto.response.PendentesDevolucaoResponse;
import com.ada.emprestimo.exception.NotFoundException;

import java.util.List;

public interface LivroPendenteDevolucaoService {
    List<PendentesDevolucaoResponse> getPendentesDevolucao() throws NotFoundException;
}
