/*
@author: Nick Martin
@date: 8/31/2026
@purpose: run various classes
*/

package com.labs.week3;

import java.util.*;

public class Main{

    public static void main(String[] args){
        Storage<String> stringStorage = new Storage<>();

        stringStorage.add("hello");
        stringStorage.add("World");
        stringStorage.add("Miami");
    
        for(int i = 0;i<stringStorage.size();i++){
            System.out.println(stringStorage.get(i));
        }

        Storage<Integer> intStorage = new Storage<>();

        intStorage.add(1);
        intStorage.add(22);
        intStorage.add(333);
        intStorage.add(4444);
        intStorage.add(55555);
    
        for(int i = 0;i<intStorage.size();i++){
            System.out.println(intStorage.get(i));
        }

        ArrayPrinter<String> stringPrint = new ArrayPrinter<>();
        String[] items = {"Hello","world","wide"}; 
        stringPrint.printArray(items);

        ArrayPrinter<Integer> intPrint = new ArrayPrinter<>();
        Integer[] itemsInt = {4,3,8,2}; 
        intPrint.printArray(itemsInt);

        ArrayPrinter<Double> DobPrint = new ArrayPrinter<>();
        Double[] itemsDob = {4.2,3.5,8.9,2.1}; 
        DobPrint.printArray(itemsDob);
        


    }

}