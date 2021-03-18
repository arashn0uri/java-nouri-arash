package com.company;

public class Personale {
    private String nome;
    private Coda coda;

    public Personale(String nome, Coda coda) {
        this.nome = nome;
        this.coda = coda;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Coda getCoda() {
        return coda;
    }

    public void setCoda(Coda coda) {
        this.coda = coda;
    }
}
