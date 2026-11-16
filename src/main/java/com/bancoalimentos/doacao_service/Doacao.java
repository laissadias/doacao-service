package com.bancoalimentos.doacao_service;

public class Doacao {

    private String alimento;
    private String nomeDoador;
    private double quantidadeKg;
    private int validadeEmDias;

    public Doacao(String alimento, String nomeDoador, double quantidadeKg, int validadeEmDias) {
        this.alimento = alimento;
        this.nomeDoador = nomeDoador;
        this.quantidadeKg = quantidadeKg;
        this.validadeEmDias = validadeEmDias;
    }

    public String getAlimento() {
        return alimento;
    }

    public String getNomeDoador() {
        return nomeDoador;
    }

    public double getQuantidadeKg() {
        return quantidadeKg;
    }

    public int getValidadeEmDias() {
        return validadeEmDias;
    }
}