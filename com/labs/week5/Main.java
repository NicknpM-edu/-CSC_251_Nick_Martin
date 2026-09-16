/*
@author: Nick Martin
@date: 9/14/2026
@purpose: a recursive class to print out an arraylist
*/

package com.labs.week5;

import java.util.*;

public class Main{

    public static void main(String[] args){
        
        //lab 1: list of names<string>
        ArrayList<String> names = new ArrayList<>();// create an arraylist with ten names
        names.add("James McAllister");
        names.add("Sean Camoy");
        names.add("Dawn Owens");
        names.add("Alice Seacaster");
        names.add("Brieanna Shwaff");
        names.add("Avery Tinsel");
        names.add("Cameron Qwont");
        names.add("Greta Stunpike");
        names.add("Jane Doe");
        names.add("John Doe");



        System.out.println("Names: " + names);//print list of names

        RecursiveAnalyzer<String> printString = new RecursiveAnalyzer<>();// new instance for strings

        printString.printArrayList(names);//print list of names fancy style(recursively)

        //lab 1: list of numbers<Int>
        ArrayList<Integer> numbers = new ArrayList<>();// create an arraylist with ten numbers
        numbers.add(4);
        numbers.add(22);
        numbers.add(365);
        numbers.add(4444444);
        numbers.add(12346);
        numbers.add(97);
        numbers.add(908);
        numbers.add(9);
        numbers.add(45);
        numbers.add(1);



        System.out.println("Names: " + numbers);//print list of numbers

        RecursiveAnalyzer<Integer> printInt = new RecursiveAnalyzer<>();// new instance for integers 

        printInt.printArrayList(numbers);//print list of numbers fancy style(recursively)



        //part 3
        String currentPath = System.getProperty("user.dir");

        FileSearch lookup = new FileSearch();
        lookup.printPath(currentPath);



    }
}