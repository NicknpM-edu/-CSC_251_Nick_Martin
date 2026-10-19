/*
@author: Nick Martin
@date: 10/5/2026
*/



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class BankAccountTest{
    public BankAccount account;

    @BeforeEach
    public void setUp(){
        account = new BankAccount();
    }

    @Test
    void testDepositPositiveAmount() {
        account.deposit(100);
        assertEquals(100, account.getBalance());
    }

    @Test
    public void testDepositZeroAmount(){
        account.deposit(0);
        assertEquals(0, account.getBalance());
    }

    @Test
    void testWithdrawValidAmount() {
        account.deposit(200);
        account.withdraw(150);
        assertEquals(50, account.getBalance());
    }

    @Test
    void testWithdrawOverdraft() {
        account.deposit(100);
        account.withdraw(150);
        assertEquals(100, account.getBalance());
    }

    @Test
    void testWithdrawNegativeAmount() {
        account.deposit(100);
        account.withdraw(-50);
        assertEquals(100, account.getBalance());
    }

    @Test
    void testMultipleDepositsAndWithdrawls() {
        account.deposit(100);
        account.withdraw(50);
        account.deposit(500);
        account.withdraw(50);
        account.withdraw(50);
        account.withdraw(50);
        account.deposit(100);
        assertEquals(500, account.getBalance());
    }

    @Test
    void testLargeDeposit(){
        account.deposit(10000);
        assertEquals(10000, account.getBalance());
    }

    @Test
    void testExactWithdraw(){
        account.deposit(100);
        account.withdraw(100);
        assertEquals(0, account.getBalance());
    }
}
//multiple or all tests fail if logic is incorrect depending on test or logic error
//TDD makes fixing bugs easier because it gives exact problems and test for specific outcomes

/*
Part 7 - reflection

writing test first helps me clarify requirements by knowing exactly what goals I am coding for and what errors I should avoid
syntax or spelling errors were caught by several test which can be difficult to pick out traditionally
TDD improves software reliability by first giving several ideas of how users may interact with the code incorrectly
TDD may be used when there is no user interaction and little to no chance of incorrect input




*/