/*
@author: Nick Martin
@date: 8/22/2026
@purpose: Main Java Class and entry point into program
*/

package com.labs.week1;

//imports
import java.util.ArrayList;

public class Student{
    //properties
    int id;
    String name;
    String major;
    ArrayList<String> courses = new ArrayList<>();

    public void addCourse(String course){ //add course to courses arraylist
        courses.add(course);
    
    }

    public String getInfo(){ //return complete student info in string
        String studentInfo = "";
        studentInfo = "student ID: "+id+"\nstudent name: " +name+ "\nstudent Major: "+major +"\nstudent courses: ";
        
        for(String course:courses){
            studentInfo += course+"|";
        }

        return studentInfo;
    
    }
    




}