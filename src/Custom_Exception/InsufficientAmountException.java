package Custom_Exception;

public class InsufficientAmountException extends Exception {
    public InsufficientAmountException() {
        super("Insufficient Amount");
        System.out.println("Insufficient amount exception");
    }
}
