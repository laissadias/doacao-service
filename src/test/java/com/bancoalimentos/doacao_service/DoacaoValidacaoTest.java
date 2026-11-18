package com.bancoalimentos.doacao_service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

class DoacaoValidacaoTest {

    private static Validator validator;

    @BeforeAll
    static void criarValidador() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    void doacaoValidaNaoTemErros() {
        Doacao doacao = new Doacao("Arroz", "Maria", 10.5, 3);

        Set<ConstraintViolation<Doacao>> erros = validator.validate(doacao);

        assertTrue(erros.isEmpty());
    }

    @Test
    void alimentoVazioGeraErro() {
        Doacao doacao = new Doacao("", "Maria", 10.5, 3);

        Set<ConstraintViolation<Doacao>> erros = validator.validate(doacao);

        assertEquals(1, erros.size());
    }

    @Test
    void quantidadeNegativaGeraErro() {
        Doacao doacao = new Doacao("Arroz", "Maria", -5, 3);

        Set<ConstraintViolation<Doacao>> erros = validator.validate(doacao);

        assertEquals(1, erros.size());
    }

    @Test
    void validadeZeroEhAceita() {
        Doacao doacao = new Doacao("Arroz", "Maria", 10.5, 0);

        Set<ConstraintViolation<Doacao>> erros = validator.validate(doacao);

        assertTrue(erros.isEmpty());
    }
}