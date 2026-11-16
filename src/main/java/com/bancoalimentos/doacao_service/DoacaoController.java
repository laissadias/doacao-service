package com.bancoalimentos.doacao_service;

import java.util.List;
import java.util.Optional;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping("/{id}")
    @Operation(summary = "Busca uma doação pelo id")
    public ResponseEntity<Doacao> buscarPorId(@PathVariable Long id) {
        Optional<Doacao> doacao = repository.findById(id);

        if (doacao.isPresent()) {
            return ResponseEntity.ok(doacao.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Cadastra uma nova doação")
    public Doacao cadastrar(@RequestBody Doacao doacao) {
        return repository.save(doacao);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza os dados de uma doação")
    public ResponseEntity<Doacao> atualizar(@PathVariable Long id, @RequestBody Doacao dados) {
        Optional<Doacao> existente = repository.findById(id);

        if (existente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Doacao doacao = existente.get();
        doacao.setAlimento(dados.getAlimento());
        doacao.setNomeDoador(dados.getNomeDoador());
        doacao.setQuantidadeKg(dados.getQuantidadeKg());
        doacao.setValidadeEmDias(dados.getValidadeEmDias());

        return ResponseEntity.ok(repository.save(doacao));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove uma doação")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}