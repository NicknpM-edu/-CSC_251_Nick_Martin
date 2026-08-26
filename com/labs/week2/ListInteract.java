/*
@author: Nick Martin
@date: 8/26/2026
@purpose: create and modify a generic type class
*/

package com.labs.week2;

import java.util.*;//imports

public class ListInteract<T>{

    public void printList(List<T> list){ //print list to console
        for( T item : list){
            System.out.println(item);
        }
    }

    public T getLast(List<T> list){ //return last element of list
        int last = list.size();
        return list.get(last);
    }

    public void setList(List<T> list){ //store list in Array
        Integer length = list.size();
        /*
        part 3 says to make this method store the list in an array of the generic type
        
        Array array = new Array(); <- the week1 slides say this is the way to make a new array and this does not work
        T[] array = new T[length]; <- java prevents me from making a generic array

        my current solve is to make an arraylist instead
        */
        List<T> copyList = new ArrayList<T>();

        
        for(Integer count = 0; count < length;count++){
            copyList.add(list.get(count));
            
        }
    }
}