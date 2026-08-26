/*
@author: Nick Martin
@date: 8/24/2026
@purpose: perform a "warm-up"
*/

package com.labs.week2;

import java.util.*;//imports

public class Student{

    //make lists
    public List<String> names = new ArrayList<String>();
    public List<Double> gpas = new ArrayList<>();

    public void makeLists(){
    
    
    //add five students
    names.add("Sam");
    names.add("Jim");
    names.add("Alex");
    names.add("Nancy");
    names.add("Billy"); 
    //print out in loop
    for (String name : names){
        System.out.println(name);
    }

    
    gpas.add(4.2);
    gpas.add(2.4);
    gpas.add(1.3);
    gpas.add(3.9);
    gpas.add(3.2);

    for(Double gpa : gpas){
        System.out.println(gpa);
    }
 }
}
