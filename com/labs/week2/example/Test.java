/*
@author: Nick Martin
@date: 8/24/2026
@purpose: test code without generics
*/

package com.labs.week2.example;

import java.util.*;

public class Test<T>{

    public static void main(String[] args){

        List<String> list = new ArrayList<>();

        list.add("hello");
        list.add("42");
        String s = list.get(0);

        Box<String> b = new Box<>();
        b.set("Hello");
        System.out.println(b.get());
        Box<Integer> n = new Box<>();
        n.set(100);

    }
}