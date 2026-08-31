/*
@author: Nick Martin
@date: 8/31/2026
@purpose: manage a list of any type
*/

package com.labs.week3;

import java.util.*;//imports

public class Storage<T>{

    private T[] items;
    private int count = 0;
    ArrayList<T> givenList =  new ArrayList<>();

    //constructor
    public Storage() {
    // initialize array without generic????
    //ArrayList<T> givenList =  new ArrayList<>();
    //T[] items = new T[length]; 
    
    }
    public void add(T item) {
    // TODO: add item to array
    givenList.add(item);
    }
    public T get(int index) {
    // TODO: return item
        return givenList.get(index);
    }
    public int size() {
        count = givenList.size();
        return count;
    }

}
