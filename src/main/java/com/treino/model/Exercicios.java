package com.treino.model;


public class Exercicios {

    private String nome;

    private int series;

    private String repeticoes;

    private String descanso;

    private String observacoes;



    // Constructor matching the required signature

    public Exercicios(String nome, int series, String repeticoes, String descanso, String observacoes) {

        this.nome = nome;

        this.series = series;

        this.repeticoes = repeticoes;

        this.descanso = descanso;

        this.observacoes = observacoes;

    }



    // Getters and setters (optional, if needed)

    public String getNome() {

        return nome;

    }



    public void setNome(String nome) {

        this.nome = nome;

    }



    public int getSeries() {

        return series;

    }



    public void setSeries(int series) {

        this.series = series;

    }



    public String getRepeticoes() {

        return repeticoes;

    }



    public void setRepeticoes(String repeticoes) {

        this.repeticoes = repeticoes;

    }



    public String getDescanso() {

        return descanso;

    }



    public void setDescanso(String descanso) {

        this.descanso = descanso;

    }



    public String getObservacoes() {


        return (observacoes == null || observacoes.isEmpty()) ? "Nenhuma" : observacoes;

    }



    public void setObservacoes(String observacoes) {

        this.observacoes = observacoes;

    }



}
