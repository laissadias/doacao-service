package com.bancoalimentos.doacao_service;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

@Entity
public class Doacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O alimento é obrigatório")
    @Size(max = 100, message = "O alimento deve ter no máximo 100 caracteres")
    private String alimento;

    @NotBlank(message = "O nome do doador é obrigatório")
    @Size(max = 100, message = "O nome do doador deve ter no máximo 100 caracteres")
    private String nomeDoador;

    @Positive(message = "A quantidade deve ser maior que zero")
    private double quantidadeKg;

    @PositiveOrZero(message = "A validade não pode ser negativa")
    private int validadeEmDias;

    public Doacao() {
    }

    public Doacao(String alimento, String nomeDoador, double quantidadeKg, int validadeEmDias) {
        this.alimento = alimento;
        this.nomeDoador = nomeDoador;
        this.quantidadeKg = quantidadeKg;
        this.validadeEmDias = validadeEmDias;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAlimento() {
        return alimento;
    }

    public void setAlimento(String alimento) {
        this.alimento = alimento;
    }

    public String getNomeDoador() {
        return nomeDoador;
    }

    public void setNomeDoador(String nomeDoador) {
        this.nomeDoador = nomeDoador;
    }

    public double getQuantidadeKg() {
        return quantidadeKg;
    }

    public void setQuantidadeKg(double quantidadeKg) {
        this.quantidadeKg = quantidadeKg;
    }

    public int getValidadeEmDias() {
        return validadeEmDias;
    }

    public void setValidadeEmDias(int validadeEmDias) {
        this.validadeEmDias = validadeEmDias;
    }
}