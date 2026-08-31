/*
@author: Nick Martin
@date: 8/31/2026
@purpose: manage a list of any type
*/

package com.labs.week3;

import java.util.*;//imports

public class ArrayPrinter<T>{

    public static <T> void printArray(T[] array){

        for(T item:array){
            System.out.println(item);
        }
    }
}
