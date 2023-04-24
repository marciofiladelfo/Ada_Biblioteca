package com.ada.emprestimo.controller;

import com.ada.emprestimo.dto.LivroDto;
import com.ada.emprestimo.dto.request.DevolucaoEmprestimoDTO;
import com.ada.emprestimo.dto.request.EmprestimoCadastroDTO;
import com.ada.emprestimo.dto.response.ClienteEmprestimoResponseDTO;
import com.ada.emprestimo.model.Emprestimo;
import com.ada.emprestimo.service.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("emprestimos")
public class EmprestimoController {
    @Autowired
    private EmprestimoService emprestimoService;

    @PostMapping()
    public ResponseEntity<Integer> save(@RequestBody EmprestimoCadastroDTO emprestimoCadastroDTO) {
        Emprestimo emprestimo = emprestimoService.save(emprestimoCadastroDTO);
        return ResponseEntity.status(HttpStatus.OK).body(emprestimo.getProtocolo());
    }

    @GetMapping()
    public ResponseEntity<List<Emprestimo>> getAll() {
        var allEmprestimos = emprestimoService.getAll();
        return ResponseEntity.ok(allEmprestimos);
    }

    @PatchMapping("devolucao")
    public ResponseEntity<Integer> devolucao(@RequestBody DevolucaoEmprestimoDTO devolucaoEmprestimoDTO) {
        emprestimoService.devolucao(devolucaoEmprestimoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{idCliente}")
    public ResponseEntity<ClienteEmprestimoResponseDTO> getEmprestimosByIdCliente(@PathVariable final int idCliente) {
		return emprestimoService.getEmprestimosByIdCliente(idCliente);
    }

    @GetMapping("/disponiveis")
    public ResponseEntity<Flux<LivroDto>> getAvailable() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(emprestimoService.available());
    }

}
