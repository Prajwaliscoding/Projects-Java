public class InsufficientFundsException extends Exception {
    public InsufficientFundsException() {
        super("Insufficient funds available.");
    }

    public InsufficientFundsException(String message) {
        super(message);
    }
}
