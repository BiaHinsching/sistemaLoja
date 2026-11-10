package com.example.sistemaLoja.service;

import org.springframework.stereotype.Service;

@Service
public class sistemaLojaService {
    public String calcularTotal(String produto, double quantidade) {
        double preco = 0;

        produto = produto.toUpperCase();

        if (produto.equals("FRANGO")) {
            preco = 10.0;
        } else if (produto.equals("PERU")) {
            preco = 18.0;
        } else if (produto.equals("CHESTER")) {
            preco = 22.0;
        } else {
            return "Produto inválido";
        }

        double total = quantidade * preco;

        if (quantidade > 10) {
            total = total * 0.95; // aplica 5% de desconto
        }

        return "Produto: " + produto +
                " | Quantidade: " + quantidade + "kg" +
                " | Total: R$ " + String.format("%.2f", total);
    }
}