/*
@author: Nick Martin
@date: 9/9/2026
@purpose: run various classes
*/

package com.labs.week4;

import java.util.*;

public class Main{

    public static void main(String[] args){
        //Part 1 Setup
    ArrayList<String> students = new ArrayList<>();

    students.add("Earl Tucker");
    students.add("Baxter Rhoads");
    students.add("Jane Doe");
    students.add("John Doe");
    students.add("Amy Lee");
    students.add("Sam Oswald");
    students.add("Davy Jones");
    students.add("Sam Tucker");

    //enhanced for loop
        for(String student : students){
            System.out.println(student);
        }

        //traditional for loop; gives access to index which may be useful for more complex interactions
        for(int count = 0;count<(students.size());count++){
            System.out.println(students.get(count));
        }

        //Part 2
    EnrollmentTracker tracker = new EnrollmentTracker();

    if(tracker.studentExists(students,"Earl Tucker")){
        System.out.println("Student Exists");
    }

    //part 3
    tracker.removeStudent(students,"Sam Oswald");
    tracker.removeStudent(students,"Earl Tucker");
    tracker.removeStudent(students,"Sam Tucker");
    tracker.removeStudent(students,"Joeseph");

    //part 4
    tracker.addStudent(students,"Sam Oswald");
    tracker.addStudent(students,"Sam Oswald");
    tracker.addStudent(students,"Joeseph Guy");

    //part 5
    students.add("Sam Oswald");
    students.add("Sam Oswald");
    students.add("Sam Oswald");

    int samCount = tracker.countOccurrences(students,"Sam Oswald");
    int baxCount =tracker.countOccurrences(students,"Baxter Rhoads");
    int goobyCount =tracker.countOccurrences(students,"Ooby Gooby");
    
    System.out.println("amount of \'Sam Oswald\' is "+ samCount);
    System.out.println("amount of \'Baxter Rhoads\' is "+ baxCount);
    System.out.println("amount of \'Ooby Gooby\' is "+ goobyCount);

    //Part 7
    students.sort(null);
    for(String student : students){
            System.out.println(student);
        }

    }

}