/*
@author: Nick Martin
@date: 9/9/2026
@purpose: make a student enrollment tracker with arraylists
*/

package com.labs.week4;

import java.util.*;

public class EnrollmentTracker{

    public void addStudent(ArrayList<String> students,String name){ //check if given name exists, if not then add to list; if so then print message
        boolean add = true;
        for(int count = 0;count<(students.size());count++){//loop through each item in list
            if(students.get(count) == name){
                System.out.println(name +" already exists");
                add = false;
            }
        }
        if (add){//outside of loop
                students.add(name);
                System.out.println(name +" has been added");
            }
    }

    public void removeStudent(ArrayList<String> students,String name){ //check if given name exists, if so then remove from list; if not then print message
        boolean studentRemoved = false;
        for(int count = 0;count<(students.size());count++){//loop through each item in list
            
            if(students.get(count) == name){
                students.remove(count);
                System.out.println(name +" has been removed");
                studentRemoved = true;
            }
        }
        if(!studentRemoved){//outside of loop
                System.out.println(name +" does not exist in list");
            }
        
    }

    public boolean studentExists(ArrayList<String> students,String name){ //boolean for whether name exists in student list
        boolean found = false;
        for(String student : students){//loop through each item in list
            if(student == name){
                return true;
            }
        }
        return false;
    }

    
    public void printAll(ArrayList<String> students){ //print all items in list to console
        
        
    }

    public int countOccurrences(ArrayList<String> students, String name){
        int occurances = 0;
        for(String student : students){//loop through each item in list
            if(student == name){
                occurances +=1;
            }
            
        }
        return occurances;
    }
}
