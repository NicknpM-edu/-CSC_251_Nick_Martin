/*
@author: Nick Martin
@date: 8/24/2026
@purpose: run various classes
*/

package com.labs.week2;

import java.util.*;

public class Main{

    public static void main(String[] args){

        Student student = new Student();
        student.makeLists();

        //instance of box with the string type, with all methods
        Box<String> boxString = new Box<>();
        boxString.add("hello");
        System.out.println(boxString.get());
        boxString.delete();
        System.out.println(boxString.get());

        //instance of box with the Int type, with all methods
        Box<Integer> boxInt = new Box<>();
        boxInt.add(5);
        System.out.println(boxInt.get());
        boxInt.delete();
        System.out.println(boxInt.get());

        //instance of box with the student type, with all methods
        Box<Student> boxStudent = new Box<>();
        boxStudent.add(student);
        boxInt.get();
        boxStudent.delete();

        //part 3 testing of code
        ListInteract<String> listString = new ListInteract<>();
        listString.setList(student.names);
        
        ListInteract<Double> listDob = new ListInteract<>();
        listDob.setList(student.gpas);

    }
}