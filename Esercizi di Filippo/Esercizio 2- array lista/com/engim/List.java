package com.engim;

public abstract class List {

    public abstract List addLast(int x);

    public abstract List add(int x, int i);

    public abstract List remove(int x);

    public abstract List removeAtIndex(int i);

    public abstract List doppio();

    public abstract boolean pari();

    public abstract boolean ordinata(int next);

     public abstract boolean ordinataCrescenteDecrescente(int next, int counter, int step);
}
