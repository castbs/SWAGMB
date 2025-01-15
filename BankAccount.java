public interface BankAccount {
    String getAccountHolder();
    double getBalance();
    void deposit(double amount);
    void withdraw(double amount);
}

