package com.company;

public class Main {

    public static void main(String[] args) {

        List l = new Node(0,new Node(1, new Node(2, new Node(3, new Nil()))));
        System.out.println(l);

        l = l.addLast(4);
        System.out.println(l);

        l.addMiddle(4,0);
        System.out.println(l);

        l = l.remove(0);
        System.out.println(l);

        int length = l.length();
        System.out.println(length);

        int get = l.get(10);
        System.out.println(get);
    }
}
