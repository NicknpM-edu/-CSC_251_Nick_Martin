/*
@author: Nick Martin
@date: 9/28/2026
*/


package com.labs;

import java.io.*;
import java.util.*;

//static
public class Main {
    public static void main(String[] args) {
        
        HashMap<Integer, Book> salesMap = new HashMap<>();//hashmap of books
        String path = "C:\\coding classes\\-CSC_251_Nick_Martin\\week7\\src\\main\\java\\com\\labs\\sales.csv";//(note to teacher) change to individuals file path
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {//read sales.csv
            String line;
            while ((line = br.readLine()) != null) {// go line by line
            
                
                String[] bookRay = line.split(",");//comma seperated
                if(bookRay.length != 4){// if seperated incorrectly save in errorlog
                    putlog(line);
                    System.out.println(line+" length error");//state what's wrong with it
                    continue;//skip the rest of loop
                }
                
                try{
                    //turn line into book class
                    Book newBook = new Book();
                    newBook.bookID = Integer.parseInt(bookRay[0]);
                    newBook.title = bookRay[1];
                    newBook.totalQuantitySold += Double.parseDouble(bookRay[2]);
                    newBook.price += Double.parseDouble(bookRay[3]);

                    

                    //if book already exists in hashmap just add to amount sold
                    if(salesMap.containsKey(newBook.bookID)){
                        Book getten = salesMap.get(newBook.bookID);
                        getten.aggregateQty(newBook.totalQuantitySold);
                        salesMap.put(getten.bookID,getten);

                    }
                    else{// if new book add to hashmap
                        salesMap.put(newBook.bookID,newBook);
                    }
                }
                catch(Exception e){//if it errors put in errorlog
                    putlog(line);
                    System.out.println(line+" Parse error");//state error
                    continue;//skip the rest of loop
                }
                
            }
        }
        catch(IOException e){//if it can't find the file
            System.out.println(e);
        }

        System.out.println("\n\nBook Sales Summary:");// introduce output
        // the variables for the summary math
        double allRevenue = 0;
        String highRevenueTit = "";
        double highRevenueNum = 0;
        String highSellerTit = "";
        int highSellerNum = 0;

        for(int i:salesMap.keySet()){// go through each item and find the maximum revenue and seller
            Book getten = salesMap.get(i); 
            getten.totalRevenue = getten.price * getten.totalQuantitySold;
            allRevenue += getten.totalRevenue;
            if (getten.totalRevenue > highRevenueNum){
                highRevenueTit = getten.title;
                highRevenueNum = getten.totalRevenue;
            }
            if (getten.totalQuantitySold > highSellerNum){
                highSellerTit = getten.title;
                highSellerNum = getten.totalQuantitySold;
            }
            System.out.println("ID: "+getten.bookID+" Title: "+getten.title+" Total Quantity Sold: "+getten.totalQuantitySold+" Total Revenue: $"+getten.totalRevenue);//output book information
        }
        System.out.println("Total Revenue: "+allRevenue+" Best Seller: "+highSellerTit+" of "+highSellerNum+" copies sold. Most Profitable is "+highRevenueTit+" of $"+ highRevenueNum+" made.");//overall summary info

    }
        
        
    
    public static void putlog(String line){//call method when finding an error line
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("exceptionLog.csv",true))) {//write to log file
            bw.newLine();
            bw.write(line);
            System.out.println("Inccorect entry saved.");
        } 
        catch (IOException e) {
            System.out.println("Error writing log file.");//output for error writing file
        }
        
    }
}

