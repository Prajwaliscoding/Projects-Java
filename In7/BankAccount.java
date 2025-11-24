public class BankAccount {
    private String accountNumber;
    private double balance;

    // Default constructor
    public BankAccount() {
        this.accountNumber = "0000";
        this.balance = 0.0;
    }

    // Parameterized constructor
    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Getters and Setters
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // deposit method
    public void deposit(double amount) throws InvalidDepositException {
        if (amount <= 0) {
            throw new InvalidDepositException();
        }
        balance += amount;
    }

    // withdraw method
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException();
        }
        balance -= amount;
    }

    @Override
    public String toString() {
        return String.format("Account #%s | Balance: $%.2f", accountNumber, balance);
    }
}
