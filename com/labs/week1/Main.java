/*
@author: Nick Martin
@date: 8/22/2026
@purpose: Main Java Class and entry point into program
*/

package com.labs.week1;

//import
import java.util.Scanner;

public class Main{

    public static void main(String[] args){
        CourseManager manager = new CourseManager();
        
        Scanner userTalk = new Scanner(System.in); //lock in the scanner source

        String userGive = "";

        do{

            System.out.println("Welcome to the Student manager system.\nOptions:\n[add] - add a student\n[all] - view the name and information of every student\n[search] - search for a specific student by ID number\n[exit] - leave program");//prompt user

            userGive = userTalk.nextLine();//grab user input

            if(userGive.contentEquals("add")){//add student
                Student student = new Student();
            
                System.out.println("Name of student:");
                String uName = userTalk.nextLine();//grab student name
                student.name = uName;

                System.out.println("Major of student:");
                String uMajor = userTalk.nextLine();//grab student major
                student.major = uMajor;

                System.out.println("How many courses to add?");
                String courseNum = userTalk.nextLine();//grab amount of courses for loop
                int loopNum = Integer.parseInt(courseNum);

                for (int i = 0; i < loopNum; i++) {
                    System.out.println(" Insert Course:");
                    String uCourse = userTalk.nextLine();//grab student course
                    student.addCourse(uCourse);
                }
                manager.addStudent(student);
            }

            if(userGive.contentEquals("search")){
                System.out.println("Student ID: ");
                String IDGive = userTalk.nextLine();//grab id for search
                int IdSearch = Integer.parseInt(IDGive);
                manager.findStudentById(IdSearch);
            }

            if(userGive.contentEquals("all")){
                manager.displayAllStudents();
            }
        }
        while (!(userGive.contentEquals("exit")));
    }
}