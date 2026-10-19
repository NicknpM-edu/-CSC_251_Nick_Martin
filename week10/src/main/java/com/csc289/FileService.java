/*
@author: Nick Martin
@date: 10/19/2026
*/




import java.io.*;
import java.util.*;

public class FileService{
    public String path = "C:\\Users\\lh178-16\\Downloads\\-CSC_251_Nick_Martin\\week10\\src\\main\\java\\com\\csc289\\sales.txt";//(note to teacher) change to individuals file path

    public ArrayList<Sale> loadSales(){//read all sales from file and return in arraylist

        ArrayList<Sale> sales = new ArrayList<>();//list of sales
        
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {//read sales.txt
            String line;
            while ((line = br.readLine()) != null) {// go line by line

                String[] saleRay = line.split(",");//comma seperated
                String id = saleRay[0];
                String customerName = saleRay[1];
                String productName = saleRay[2];
                Double price = Double.parseDouble(saleRay[3]);
                Double discountRate = Double.parseDouble(saleRay[4]);


                Sale sale = new Sale(id,customerName,productName,price,discountRate);
                sales.add(sale);
            }
                
            
        }
        
        catch(IOException e){//if it can't find the file
            System.out.println(e);
        }
        return sales;
    }

    public void saveSale(Sale sale){//save new sale to file
        try (PrintWriter pw = new PrintWriter(path)) {//append to sales.txt  NEED FIX WRITING NOT APPENDING
            
        pw.append(sale.SaleId+","+sale.CustomerName+","+sale.ProductName+","+sale.Price+","+sale.DiscountRate+",");
      
        pw.close();
        }
        
        catch(IOException e){//if it can't find the file
            System.out.println(e);
        }

    }

}

