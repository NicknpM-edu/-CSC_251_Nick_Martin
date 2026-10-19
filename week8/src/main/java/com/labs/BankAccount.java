/*
@author: Nick Martin
@date: 10/5/2026
*/


public class BankAccount{

    private double balance = 0;

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
}

}