package com.engim;

public class Nil extends List{

    @Override
    public String toString() {
        return "";
    }

    @Override
    public List addLast(int x) {
        return new Node(x, this);
    }

    @Override
    public List add(int x, int i) {
        return new Node(x, this);
    }

    @Override
    public List remove(int x) {
        return this;
    }

    @Override
    public List removeAtIndex(int i) {
        return this;
    }

    @Override
    public List doppio() {
        return this;
    }

    @Override
    public boolean pari() {
        return true;
    }

    @Override
    public boolean ordinata(int next) {
        return true;
    }

    @Override
    public boolean ordinataCrescenteDecrescente(int next, int counter, int step) {
        if(Math.abs(counter) == step)
            return true;
        else
            return false;
    }
}
