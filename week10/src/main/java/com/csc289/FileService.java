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
                if(saleRay.length == 5){
                
                String id = saleRay[0];
                String customerName = saleRay[1];
                String productName = saleRay[2];
                Double price = Double.parseDouble(saleRay[3]);
                Double discountRate = Double.parseDouble(saleRay[4]);


                Sale sale = new Sale(id,customerName,productName,price,discountRate);
                sales.add(sale);
                }
            }
                
            
        }
        
        catch(IOException e){//if it can't find the file
            System.out.println(e);
        }
        return sales;
    }

    public void saveSale(Sale sale){//save new sale to file

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path,true))){
            
            bw.newLine();
            bw.write(sale.SaleId+","+sale.CustomerName+","+sale.ProductName+","+sale.Price+","+sale.DiscountRate);
        }

        catch (IOException e) {
            System.out.println("Error writing file.");
        }


    }

    public void deleteSale(String Id){//delete sale by id
        
        ArrayList<Sale> salesRay = loadSales();
        
        for(Sale sale:salesRay){
            
            if(sale.SaleId.equals(Id)){//remove sale by id
                
                salesRay.remove(sale);
            }
        }
        
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path))){//rewrite file with only kept sales
            for(Sale sale:salesRay){
            bw.write(sale.SaleId+","+sale.CustomerName+","+sale.ProductName+","+sale.Price+","+sale.DiscountRate);
            bw.newLine();
            }

        }

        catch (IOException e) {
            System.out.println("Error writing file.");
        }
        

    }

}

