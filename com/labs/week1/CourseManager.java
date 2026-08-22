/*
@author: Nick Martin
@date: 8/22/2026
@purpose: Main Java Class and entry point into program
*/

package com.labs.week1;

//imports
import java.util.ArrayList;

public class CourseManager{
    //Properties
    static ArrayList<Student> students = new ArrayList<>();

    public static void addStudent(Student s){ //add student to students arraylist
        int idToBe = students.size();
        s.id = idToBe;
        students.add(s);
        System.out.println(s.getInfo());
    }

    public static void findStudentById(int id){ //return student information by specific student searched
        boolean found = false;
        for(Student student:students){
            if (student.id == id){
                System.out.println(student.getInfo());
                found = true;
            }
        }
        if (found == false){
            System.out.println("Id Does Not Exist.");
        }
    
    }

    public static void displayAllStudents(){ //print to console a list of all students in system
        for(Student student:students){
            System.out.println(student.getInfo());
            System.out.println("----------------------------");
                
            
    
    }
}
}