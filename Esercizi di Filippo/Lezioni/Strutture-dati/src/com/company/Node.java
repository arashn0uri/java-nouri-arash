package com.company;

public class Node extends List {
    private  int value;
    private List next;

    public Node(int value, List next) {
        this.value = value;
        this.next = next;
    }

    @Override
    public List addLast(int last) {
        this.next = next.addLast(last);
        return this;
    }

    @Override
    public List addMiddle(int middle, int i) {
        if( i == 0) {
            this.next = new Node(this.value, this.next) ;
            this.value = middle;
        } else
            this.next = this.next.addMiddle(middle, --i);
        return this;
    }

    @Override
    public List remove(int number) {
        if (this.value == number)
            return this.next.remove(number);
        else {
            this.next = this.next.remove(number);
            return this;
        }
    }

    @Override
    public int length() {
        return this.next.length() + 1;
    }

    @Override
    public int get(int i) {
        if(i == 0)
            return this.value;
        else
            return this.next.get(--i);
    }

    @Override
    public String toString() {
        return value + " " + next.toString();
    }
}
