/*
@author: Nick Martin
@date: 9/28/2026
*/


package com.labs;

import java.io.*;
import java.util.*;

//static
public class Main {
    public void main(String[] args) {
        
        HashMap<Integer, Book> salesMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader("sales.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] bookRay = line.split(",");
                if(bookRay.length != 4){
                    putlog(line);
                    break;
                }
                try{
                    
                    Book newBook = new Book();
                    newBook.bookID = Integer.parseInt(bookRay[0]);
                    newBook.title = bookRay[1];
                    newBook.totalQuantitySold += Double.parseDouble(bookRay[2]);
                    newBook.price += Double.parseDouble(bookRay[3]);

                    if(salesMap.containsKey(newBook.bookID)){

                    }
                    else{
                        salesMap.put(newBook.bookID,newBook);
                    }
                }
                catch(Exception e){
                    putlog(line);
                }
                
            }
        }
        catch(IOException e){}
    }
        
        
    
    public void putlog(String line){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("exceptionLog.csv"))) {
            bw.newLine();
            bw.write(line);
            System.out.println("inccorect entry saved.");
        } 
        catch (IOException e) {
            System.out.println("Error writing log file.");
        }
        
    }
}

