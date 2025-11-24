public class TestBank {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("1234", 100.0);

        // Deposit -50
        try {
            account.deposit(-50);
        } catch (InvalidDepositException e) {
            System.out.println("Caught: " + e.getMessage());
        }

        // Withdraw 150
        try {
            account.withdraw(150);
        } catch (InsufficientFundsException e) {
            System.out.println("Caught: " + e.getMessage());
        }

        // Deposit 300
        try {
            account.deposit(300);
        } catch (InvalidDepositException e) {
            System.out.println("Caught: " + e.getMessage());
        }

        // Withdraw 100
        try {
            account.withdraw(100);
        } catch (InsufficientFundsException e) {
            System.out.println("Caught: " + e.getMessage());
        }

        // Print final account
        System.out.println(account);
    }
}
