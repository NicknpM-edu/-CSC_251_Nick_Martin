/*
@author: Nick Martin
@date: 10/19/2026
*/


import java.io.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;


public class FileServiceTest{
    public FileService file;

    @BeforeEach
    public void setUp(){

        //reset file every time a test runs
        String path = "C:\\Users\\lh178-16\\Downloads\\-CSC_251_Nick_Martin\\week10\\src\\main\\java\\com\\csc289\\sales.txt";//(note to teacher) change to individuals file path

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path))){

            bw.write("S001,John Smith,Laptop,1200.00,0.10\nS002,Maria Lopez,Monitor,300.00,0.05\nS003,David Chen,Keyboard,80.00,0.00\nS004,Sarah Johnson,Tablet,600.00,0.15");
        }

        catch (IOException e) {
            System.out.println("Error writing file.");
        }
        
        file = new FileService();
    }

    @Test
    void testSalesLoad() {
        
        ArrayList<Sale> salesRay = file.loadSales();
        assertEquals(4,salesRay.size());
        assertEquals("S001",salesRay.get(0).SaleId);
        assertEquals("John Smith",salesRay.get(0).CustomerName);
    }

    @Test
    void testSaleWrite() {
        
        Sale newSale = new Sale("S005","Kiera Knight","Mouse",20.00,0.00);
        file.saveSale(newSale);
        ArrayList<Sale> salesRay = file.loadSales();
        assertEquals(5,salesRay.size());
        assertEquals("S005",salesRay.get(4).SaleId);
    }

    @Test
    void testSaleDelete() {
        ArrayList<Sale> salesRay1 = file.loadSales();
        assertEquals(4,salesRay1.size());
        file.deleteSale("S003");
        ArrayList<Sale> salesRay = file.loadSales();
        assertEquals(3,salesRay.size());

    }

    @Test
    void testDiscountCalc() {
        //100 w 10% discount
        Sale sale = new Sale("S000","Joe Test","item",100.00,0.10);
        assertEquals(90,sale.calculateFinalPrice());
        //0% discount
        Sale sale2 = new Sale("S000","Joe Test","item",100.00,0.00);
        assertEquals(100,sale2.calculateFinalPrice());
        //100% discount
        Sale sale3 = new Sale("S000","Joe Test","item",100.00,1.00);
        assertEquals(0,sale3.calculateFinalPrice());
        //0 cost
        Sale sale4 = new Sale("S000","Joe Test","item",0.00,1.00);
        assertEquals(0,sale4.calculateFinalPrice());

    }

}