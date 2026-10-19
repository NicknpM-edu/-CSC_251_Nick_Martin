/*
@author: Nick Martin
@date: 10/5/2026
*/



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class CalculatorTest{
    public Calculator calculator;

    @BeforeEach
    public void setUp(){
        calculator = new Calculator();
    }

    @Test
    public void testAdd(){
        assertEquals(5, calculator.add(2,3));
        assertEquals(-1,calculator.add(-2,1));
        assertEquals(0,calculator.add(0,0));
    }

    @Test
    public void testSubtract(){
        assertEquals(1, calculator.subtract(3,2));
        assertEquals(-3,calculator.subtract(-2,1));
        assertEquals(0,calculator.subtract(0,0));
    }
}