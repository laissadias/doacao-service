package com.bancoalimentos.doacao_service;

public class Doacao {

    private Long id;
    private String alimento;
    private String nomeDoador;
    private double quantidadeKg;
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