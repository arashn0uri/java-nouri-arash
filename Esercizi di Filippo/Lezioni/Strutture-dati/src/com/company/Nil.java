package com.company;

public class Nil extends List{

    @Override
    public List addLast(int last) {
        return new Node(last, this);
    }

    @Override
    public List addMiddle(int middle, int i) {
        return new Node(middle, this);
    }

    @Override
    public List remove(int number) {
        return this;
    }

    @Override
    public int length() {
        return 0;
    }

    @Override
    public int get(int i) {
        return 0;
    }

    @Override
    public String toString() {
        return "";
    }
}
