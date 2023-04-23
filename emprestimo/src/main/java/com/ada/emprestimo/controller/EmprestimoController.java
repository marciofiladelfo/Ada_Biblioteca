package com.ada.emprestimo.controller;

import java.util.List;

import com.ada.emprestimo.dtos.response.ClienteEmprestimoResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ada.emprestimo.model.Emprestimo;
import com.ada.emprestimo.request.DevolucaoEmprestimoDTO;
import com.ada.emprestimo.request.EmprestimoCadastroDTO;
import com.ada.emprestimo.service.EmprestimoService;

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

    @GetMapping("")
    public List<Emprestimo> getAll() {
        return emprestimoService.getAll();
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
}
