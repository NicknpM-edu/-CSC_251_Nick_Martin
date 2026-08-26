/*
@author: Nick Martin
@date: 8/26/2026
@purpose: create a generic class
*/

package com.labs.week2;

import java.util.*;//imports

public class Box<T>{

    private T item;

    public void add(T input){ //change item to input
        item = input;
    }

    public void delete(){//turn item null
        item = null;
    }

    public T get(){//return item
        return item;
    }
}