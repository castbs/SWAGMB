public class CreditCardAccount {
    private String accountHolder;
    private double balance;
    private double creditLimit;

    public CreditCardAccount(String accountHolder, double creditLimit) {
        this.accountHolder = accountHolder;
        this.creditLimit = creditLimit;
        this.balance = 0.0;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void charge(double amount) {
        if (balance + amount <= creditLimit) {
            balance += amount;
        }
    }

    public void pay(double amount) {
        if (amount > 0) {
            balance -= amount;
        }
    }
}

