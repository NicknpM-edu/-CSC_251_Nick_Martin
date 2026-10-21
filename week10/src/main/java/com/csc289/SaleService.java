/*
@author: Nick Martin
@date: 10/21/2026
*/




import java.io.*;
import java.util.*;

public class SaleService{

    public double calculateTotalRevenue(List<Sale> list){
        double revenue = 0;
        for(Sale sale:list){
            revenue += sale.calculateFinalPrice();
        }

        return revenue;
    }

    public double calculateAverageSale(List<Sale> list){
        
        return calculateTotalRevenue(list)/list.size();
    }



}