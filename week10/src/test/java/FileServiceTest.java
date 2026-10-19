/*
@author: Nick Martin
@date: 10/19/2026
*/



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;


public class FileServiceTest{
    public FileService file;

    @BeforeEach
    public void setUp(){
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
        file.saveSale( newSale);
        ArrayList<Sale> salesRay = file.loadSales();
        assertEquals(5,salesRay.size());
        assertEquals("S005",salesRay.get(5).SaleId);
    }

}