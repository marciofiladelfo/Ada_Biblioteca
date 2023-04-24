package com.ada.emprestimo.controller;

import com.ada.emprestimo.dto.response.PendentesDevolucaoResponse;
import com.ada.emprestimo.exception.NotFoundException;
import com.ada.emprestimo.model.Emprestimo;
import com.ada.emprestimo.service.EmprestimoService;
import com.ada.emprestimo.service.LivroPendenteDevolucaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("emprestimos")
@RequiredArgsConstructor
public class GetLivrosPendentesDevolucao {

	private final LivroPendenteDevolucaoService service;

	@GetMapping("/pendente")
	public ResponseEntity<List<PendentesDevolucaoResponse>> getPendenteDevolucao() throws NotFoundException {
		var allEmprestimosPendentes = service.getPendentesDevolucao();
		return ResponseEntity.ok(allEmprestimosPendentes);
	}

	
}
