package com.ada.emprestimo.controller;


import com.ada.emprestimo.service.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("emprestimos")
public class EmprestimoController {

    @Autowired
    private EmprestimoService service;

}
