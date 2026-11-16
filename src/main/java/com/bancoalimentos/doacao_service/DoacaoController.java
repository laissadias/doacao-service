package com.bancoalimentos.doacao_service;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doacoes")
@Tag(name = "Doações", description = "Gerenciamento de doações de alimentos")
public class DoacaoController {

    private final DoacaoRepository repository;

    public DoacaoController(DoacaoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    @Operation(summary = "Lista todas as doações cadastradas")
    public List<Doacao> listar() {
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Cadastra uma nova doação")
    public Doacao cadastrar(@RequestBody Doacao doacao) {
        return repository.save(doacao);
    }
}