package com.example.sistemaLoja.controller;

import com.example.sistemaLoja.service.sistemaLojaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compra")
public class sistemaLojaController {

    private final sistemaLojaService service;

    public sistemaLojaController(sistemaLojaService service) {
        this.service = service;
    }

    @GetMapping
    public String calcularCompra(
            @RequestParam String produto,
            @RequestParam double quantidade
    ) {
        return service.calcularTotal(produto, quantidade);
    }
}
