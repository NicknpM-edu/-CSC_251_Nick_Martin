/*
@author: Nick Martin
@date: 10/19/2026
*/


public class Sale{

    String SaleId;
    String CustomerName;
    String ProductName;
    Double Price;
    Double DiscountRate;

    Sale(String saleId,String customerName,String productName, Double price, Double discountRate){

        SaleId = saleId;
        CustomerName = customerName;
        ProductName = productName;
        Price = price;
        DiscountRate = discountRate;
    }

    public double calculateFinalPrice(){

        return(Price-(Price*DiscountRate));
    }

    


}