package com.bancoalimentos.doacao_service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
class DoacaoControllerTest {

    @Mock
    private DoacaoRepository repository;

    @InjectMocks
    private DoacaoController controller;

    @Test
    void buscarPorIdExistenteDevolve200() {
        Doacao doacao = new Doacao("Arroz", "Maria", 10.5, 3);
        when(repository.findById(1L)).thenReturn(Optional.of(doacao));

        ResponseEntity<Doacao> resposta = controller.buscarPorId(1L);

        assertEquals(200, resposta.getStatusCode().value());
        assertEquals("Arroz", resposta.getBody().getAlimento());
    }

    @Test
    void buscarPorIdInexistenteDevolve404() {
        when(repository.findById(99L)).thenReturn(Optional.empty());

        ResponseEntity<Doacao> resposta = controller.buscarPorId(99L);

        assertEquals(404, resposta.getStatusCode().value());
    }

    @Test
    void removerExistenteDevolve204() {
        when(repository.existsById(1L)).thenReturn(true);

        ResponseEntity<Void> resposta = controller.remover(1L);

        assertEquals(204, resposta.getStatusCode().value());
        verify(repository).deleteById(1L);
    }

    @Test
    void removerInexistenteDevolve404ENaoApagaNada() {
        when(repository.existsById(99L)).thenReturn(false);

        ResponseEntity<Void> resposta = controller.remover(99L);

        assertEquals(404, resposta.getStatusCode().value());
        verify(repository, never()).deleteById(99L);
    }
}