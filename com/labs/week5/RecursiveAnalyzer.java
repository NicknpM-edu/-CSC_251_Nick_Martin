/*
@author: Nick Martin
@date: 9/14/2026
@purpose: a recursive class to print out an arraylist
*/

package com.labs.week5;


import java.util.*;

public class RecursiveAnalyzer<T>{

    

    public void printArrayList( ArrayList<T> list){//print list of type fancy style(recursively)
            int count = list.size();
        if(count > 1){
            System.out.println(list.get(count-1));
            list.remove(count-1);
            printArrayList(list);

        }
        else if(count == 1){
            System.out.println(list.get(0));
        }



    }


}