/*
@author: Nick Martin
@date: 9/23/2026
@purpose: 
*/

package com.labs.week6;

import java.util.*;

public class Main{

    public static void main(String[] args){
        //part 1: create hashmap and assign values then print entire contents
        HashMap<Integer, String> studentDirectory = new HashMap<>();
        studentDirectory.put(5,"John Doe");
        studentDirectory.put(4,"Jane Doe");
        studentDirectory.put(2,"Carl Weck");
        studentDirectory.put(3,"Sam Smith");
        studentDirectory.put(1,"Dana Don");

        for(Integer id : studentDirectory.keySet()){
            System.out.println(id + ":"+ studentDirectory.get(id));
        }

        //part 2: use findstudent method to search for student that does exist and student that doesn't
        findStudent(studentDirectory, 1);
        findStudent(studentDirectory, 0);

        //part 3: use addstudent to test for adding a key that already exists
        addStudent(studentDirectory,0,"Adam Cononver");
        addStudent(studentDirectory,1,"Carl Jenkins");

        //part 4: use removestudent to test if student exists and remove if so or print warning if not
        
        removeStudent(studentDirectory, 1);
        removeStudent(studentDirectory, 22);

        //part 5: change to use student class instead of just name and loop through to print to console
        HashMap<Integer, Student> newStudentDirectory = new HashMap<>();
        Student john = new Student();
        john.id = 5;
        john.name = "John Doe";
        john.major = "Science";
        john.gpa = 3.2;
         
        newStudentDirectory.put(john.id,john);

        Student jane = new Student();
        jane.id = 4;
        jane.name = "Jane Doe";
        jane.major = "Art";
        jane.gpa = 3;
         
        newStudentDirectory.put(jane.id,jane);

        Student carl = new Student();
        carl.id = 3;
        carl.name = "Carl Weck";
        carl.major = "Math";
        carl.gpa = 4.0;
         
        newStudentDirectory.put(carl.id,carl);

        Student sam = new Student();
        sam.id = 2;
        sam.name = "Sam Smith";
        sam.major = "Culinary";
        sam.gpa = 2.8;
         
        newStudentDirectory.put(sam.id,sam);

        for(Integer id : newStudentDirectory.keySet()){
            System.out.println(id + ":"+ newStudentDirectory.get(id));
        }

    }

    public static void findStudent(HashMap<Integer, String> map, int id){
        if(map.containsKey(id)){
            System.out.println(map.get(id));
        }
        else{
            System.out.println("Student not found");
        }
    }

    public static void addStudent(HashMap<Integer, String> map, int id, String name){

        if(map.containsKey(id)){
            System.out.println("Id already exists");
        }
        else{
            map.put(id,name);
        }

    }

    public static void removeStudent(HashMap<Integer, String> map,int id){

        if(map.containsKey(id)){
            map.remove(id);
            System.out.println("Student removed");
        }
        else{
            System.out.println("Student does not exist");
        }
    }


/*
Part 6:
1. What is the average time complexity of:
-put() - O(1) constant
-get() - O(1) constant
-containsKey() - O(1) constant

2. Why is HashMap generally faster than ArrayList for searching;
Because it has designated key that the programmer should have directly assigned and therefore easier to retrieve without iteration

3. When would ArrayList still be preferable?
when it is a small list of items or when the complexity of a hashmap is unneeded

4. Why must keys be unique?
because that is the assigned point of retrieval, same reason you can't assign more than one value to the same index on a list


*/
}
     