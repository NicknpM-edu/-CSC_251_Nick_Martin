/*
@author: Nick Martin
@date: 8/30/2026
@purpose: manage a list of any type
*/

package com.labs.week2;

import java.util.*;//imports

public class DataManager<T>{

    private List<T> givenList =  new ArrayList<>();

    public void add(T item){ //add to list
        
        givenList.add(item);
    }

    public void remove(T item){ //remove from list
        
        givenList.remove(item);
    }

    public void get(int index){ //print specific index to console
        
        System.out.println(givenList.get(index));
    }

    public int getSize(){ //returns length of list
        
        return(givenList.size());
    }

    public void printAll(){ //print all items to console
        
        for(T item : givenList){
            System.out.println(item);
        }
    }



}