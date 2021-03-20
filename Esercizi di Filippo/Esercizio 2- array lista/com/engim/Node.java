package com.engim;

import com.sun.security.auth.module.UnixLoginModule;

import javax.swing.*;

public class Node extends List{
    private int value;
    private List next;

    public Node(int value, List next) {
        this.value = value;
        this.next = next;
    }

    @Override
    public String toString() {
        return value + " " + next.toString();
    }

    @Override
    public List addLast(int x) {
        this.next = next.addLast(x);
        return this;
    }


    @Override
    public List add(int x , int i) {
        if(i == 0) {
            this.next = next.add(this.value  , i);
            this.value = x;
        } else {
            this.next = next.add(x , --i);
        }
        return this;
    }


    @Override
    public List remove(int x ) {
        if(this.value == x)
            return this.next.remove(x);
        else
            this.next = next.remove(x);
        return this;
    }

    @Override
    public List removeAtIndex(int i) {
        if (i == 0)
            return this.next;
        else
            this.next = next.removeAtIndex(--i);
        return this;
    }

    @Override
    public List doppio() {
        this.next = next.doppio();
        this.next = next.add(this.value, 0);
        return this;
    }

    @Override
    public boolean pari() {
        if (this.value % 2 == 0)
            return this.next.pari();
        else
            return false;
    }


    @Override
    public boolean ordinata(int next) {
        if(next == 0) next = this.value;
        if(this.value >= next)
            return this.next.ordinata(this.value);
        else
            return false;
    }

    @Override
    public boolean ordinataCrescenteDecrescente(int next, int counter , int step) {
        if (next == 0 && counter == 0 && step == 0) next = this.value;
        if (this.value < next) {
            ++counter;
        }
        else if (this.value > next) {
            --counter;
        }
        else
            --step;
        ++step;
        return this.next.ordinataCrescenteDecrescente(this.value, counter, step);
    }
}
