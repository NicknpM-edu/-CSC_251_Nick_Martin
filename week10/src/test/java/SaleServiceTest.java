/*
@author: Nick Martin
@date: 10/21/2026
*/


import java.io.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;


public class SaleServiceTest{
    public FileService file;
    public SaleService doSales;

    @BeforeEach
    public void setUp(){

        doSales = new SaleService();
        file = new FileService();
    }

    @Test
    void testTotalRevenue() {
        
        ArrayList<Sale> salesRay = file.loadSales();
    
        assertEquals(1955,doSales.calculateTotalRevenue(salesRay));
        
    }

    @Test
    void testAverageSale() {
        
        ArrayList<Sale> salesRay = file.loadSales();
    
        assertEquals(488.75,doSales.calculateAverageSale(salesRay));
    }

}