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
        Student student2 = new Student();
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

        //part 4
        DataManager<String> newListString = new DataManager<>();
        newListString.add("hello");
        newListString.add("world");
        newListString.add("good to meet you");

        newListString.remove("hello");
        newListString.get(1);
        System.out.println(newListString.getSize());
        newListString.printAll();

        DataManager<Integer> newListInt = new DataManager<>();
        newListInt.add(5);
        newListInt.add(2);
        newListInt.add(20000000);

        newListInt.remove(5);
        newListInt.get(1);
        System.out.println(newListInt.getSize());
        newListInt.printAll();

        DataManager<Student> newListStudent = new DataManager<>();
        newListStudent.add(student);
        newListStudent.add(student2);

        newListStudent.remove(student);
        newListStudent.get(0);
        System.out.println(newListStudent.getSize());
        newListStudent.printAll();

    }
}