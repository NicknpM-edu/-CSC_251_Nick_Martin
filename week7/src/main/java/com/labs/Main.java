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
        String path = "C:\\Users\\lh178-16\\Downloads\\-CSC_251_Nick_Martin\\week7\\src\\main\\java\\com\\labs\\sales.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {//read sales.csv
            String line;
            while ((line = br.readLine()) != null) {// go line by line
            
                
                String[] bookRay = line.split(",");//comma seperated
                if(bookRay.length != 4){// if seperated incorrectly save in errorlog
                    putlog(line);
                    break;
                }
                for(String i:bookRay){//if section empty, dump to errorlog
                    if(i == " " || i == ""|| i == null){
                        putlog(line);
                        break;
                    }

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
                    return;
                }
                
            }
        }
        catch(IOException e){
            System.out.println(e);
            return;
        }
        System.out.println("\n\nBook Sales Summary:");
        double allRevenue = 0;
        String highRevenueTit = "";
        double highRevenueNum = 0;
        String highSellerTit = "";
        int highSellerNum = 0;

        for(int i:salesMap.keySet()){
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
            System.out.println("ID: "+getten.bookID+" Title: "+getten.title+" Total Quantity Sold: "+getten.totalQuantitySold+" Total Revenue: $"+getten.totalRevenue);
        }
        System.out.println("Total Revenue: "+allRevenue+" Best Seller: "+highSellerTit+" of "+highSellerNum+" copies sold. Most Profitable is "+highRevenueTit+" of $"+ highRevenueNum+" made.");

    }
        
        
    
    public static void putlog(String line){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("exceptionLog.csv",true))) {
            bw.newLine();
            bw.write(line);
            System.out.println("inccorect entry saved.");
        } 
        catch (IOException e) {
            System.out.println("Error writing log file.");
        }
        
    }
}

