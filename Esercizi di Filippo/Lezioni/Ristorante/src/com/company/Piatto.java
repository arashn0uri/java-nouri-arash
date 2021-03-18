package com.company;

public class Piatto {
    private String nome;

    public Piatto(String nome) {
        this.nome = nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Piatto{ " + nome;
    }
}
