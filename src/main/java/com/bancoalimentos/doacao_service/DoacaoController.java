package com.bancoalimentos.doacao_service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doacoes")
public class DoacaoController {

    @GetMapping
    public List<Doacao> listar() {
        List<Doacao> doacoes = new ArrayList<>();
        doacoes.add(new Doacao("Arroz", "Maria", 10.5, 3));
        doacoes.add(new Doacao("Feijão", "João", 5.0, 0));
        return doacoes;
    }
}