public class InvalidDepositException extends Exception {
    public InvalidDepositException() {
        super("Deposit amount must be greater than zero.");
    }

    public InvalidDepositException(String message) {
        super(message);
    }
}
