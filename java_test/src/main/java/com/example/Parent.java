package com.example;

/**
 * Created by Pooholah on 2017/6/28.
 */

public class Parent {
    private String a = "";

    public Parent() {
        System.out.print("Parent()");
    }

    public Parent(String a) {
        this.a = a;
        System.out.print("Parent(String a)");
    }
}
