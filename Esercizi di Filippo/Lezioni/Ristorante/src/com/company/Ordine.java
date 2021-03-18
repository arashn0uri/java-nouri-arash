package com.company;

public class Ordine {
    public enum Stato {
        RICEVUTO, IN_ELABORAZIONE, EVASO
    }
    private Piatto piatto;
    private Tavolo tavolo;
    private Cameriere cameriere;
    private Stato stato;

    public Ordine(Piatto piatto, Tavolo tavolo, Cameriere cameriere) {
        this.piatto = piatto;
        this.tavolo = tavolo;
        this.cameriere = cameriere;
        this.stato = Stato.RICEVUTO;
    }

    public Piatto getPiatto() {
        return piatto;
    }

    public Tavolo getTavolo() {
        return tavolo;
    }

    public Cameriere getCameriere() {
        return cameriere;
    }

    public Stato getStato() {
        return stato;
    }

    @Override
    public String toString() {
        return piatto +
                ", " + tavolo +
                ", " + stato +
                '}';
    }
}
