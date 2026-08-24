/*
@author: Nick Martin
@date: 8/24/2026
@purpose: test code without generics
*/

package com.labs.week2.example;

import java.util.*;

public class Box<T> {
    private T item;

    public void set(T item) {
        this.item = item;
    }

    public T get() {
        return item;

    }
}