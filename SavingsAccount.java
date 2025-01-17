//import date
//get month and day of month
public class SavingsAccount {
    private String accountHolder;
    private double balance;

    public SavingsAccount(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        //probably add something like this.
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountHolder() {
        return accountHolder;
    }
}

