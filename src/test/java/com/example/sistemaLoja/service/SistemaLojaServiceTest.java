package com.example.sistemaLoja.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SistemaLojaServiceTest {

    private final sistemaLojaService service = new sistemaLojaService();

    @Test
    void calculaTotalDeFrangoSemDesconto() {
        String resultado = service.calcularTotal("FRANGO", 2);

        assertTrue(resultado.contains("Produto: FRANGO"));
        assertTrue(resultado.contains("Quantidade: 2.0kg"));
        assertTrue(resultado.matches(".*Total: R\\$ 20[,.]00$"));
    }

    @Test
    void calculaTotalDePeru() {
        String resultado = service.calcularTotal("PERU", 2);

        assertTrue(resultado.matches(".*Total: R\\$ 36[,.]00$"));
    }

    @Test
    void calculaTotalDeChester() {
        String resultado = service.calcularTotal("CHESTER", 2);

        assertTrue(resultado.matches(".*Total: R\\$ 44[,.]00$"));
    }

    @Test
    void naoAplicaDescontoEmDezQuilos() {
        String resultado = service.calcularTotal("FRANGO", 10);

        assertTrue(resultado.matches(".*Total: R\\$ 100[,.]00$"));
    }

    @Test
    void aplicaCincoPorCentoDeDescontoAcimaDeDezQuilos() {
        String resultado = service.calcularTotal("FRANGO", 11);

        assertTrue(resultado.matches(".*Total: R\\$ 104[,.]50$"));
    }

    @Test
    void aceitaNomeDeProdutoEmMinusculas() {
        String resultado = service.calcularTotal("peru", 1);

        assertTrue(resultado.contains("Produto: PERU"));
        assertTrue(resultado.matches(".*Total: R\\$ 18[,.]00$"));
    }

    @Test
    void informaQuandoProdutoNaoExiste() {
        assertTrue(service.calcularTotal("PEIXE", 1).contains("Produto inválido"));
    }
}
