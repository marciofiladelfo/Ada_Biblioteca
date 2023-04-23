package com.ada.emprestimo.service;

import com.ada.emprestimo.dto.response.PendentesDevolucaoResponse;

import java.util.List;

public interface LivroPendenteDevolucaoService {
    List<PendentesDevolucaoResponse> getPendentesDevolucao();
}
