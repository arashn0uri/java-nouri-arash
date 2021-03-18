package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Tavolo tavolo1 = new Tavolo(1);
        Tavolo tavolo2 = new Tavolo(2);
        Tavolo tavolo3 = new Tavolo(3);
        Coda coda = new Coda();
        Cameriere cam1 = new Cameriere("pippo", coda);
        Cameriere cam2 = new Cameriere("pippa", coda);
        cam1.inserisciOrdine(tavolo1, new Piatto("Carbonara"));
        cam2.inserisciOrdine(tavolo2, new Piatto("zuppa"));
        System.out.println(coda.toString());





    }
}
