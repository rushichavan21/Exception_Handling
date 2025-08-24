/*
 * =====================================================
 *   Custom Exceptions in Java
 * =====================================================
 *
 * 1. Why Custom Exceptions?
 *    - Java already provides many built-in exceptions (ArithmeticException, NullPointerException, etc.)
 *    - But in real-world applications, we often need to define our OWN exceptions
 *      to represent specific error conditions.
 *
 *    Example:
 *       In a banking system:
 *         - Withdrawing more than balance → InsufficientAmountException
 *         - Negative deposit → InvalidDepositException
 *
 *    Custom exceptions make the program more meaningful and easier to debug.
 *
 * 2. How to Create Custom Exception?
 *    - Define a new class that extends Exception (for checked exceptions)
 *      or RuntimeException (for unchecked exceptions).
 *
 *    Example:
 *      class InsufficientAmountException extends Exception {
 *          public InsufficientAmountException(String message) {
 *              super(message);
 *          }
 *      }
 *
 * 3. Throwing Custom Exception
 *    - Use `throw new CustomException("message")` when your business logic fails.
 *
 * 4. Handling
 *    - Use try-catch around the code where exception might occur.
 *
 * =====================================================
 */

package Custom_Exception;

// Bank class simulates a simple bank account
public class Bank {
    private int amount;

    // Constructor to set initial balance
    public Bank(int amount) {
        this.amount = amount;
    }

    // Getter method for amount
    public int getAmount() {
        return amount;
    }

    // Withdraw method
    // Declares "throws Exception" because it may throw a custom exception
    public void withdraw(int amount) throws Exception {
        // If requested amount is greater than available balance → throw custom exception
        if (this.amount < amount) {
            // Throwing our custom exception
            throw new InsufficientAmountException();
        }
        // Deduct balance if enough amount is present
        this.amount = this.amount - amount;
    }

    // Setter (not used here)
    public void setAmount(int amount) {}

    // Main method: Test the Bank class
    public static void main(String[] args) {
        Bank bank = new Bank(10);  // Create bank account with balance = 10

        try {
            bank.withdraw(12);  // Try to withdraw more than available → Exception
        } catch (Exception e) {
            // Print exception message
            System.out.println("Exception occurred: " + e);
        } finally {
            // finally block always executes
            System.out.println("Program reached to the end");
        }
    }
}

/*

 * =====================================================
 *   Program Flow (for this example)
 * =====================================================
 * 1. Bank account created with 10 balance.
 * 2. withdraw(12) called → balance < requested → throw InsufficientAmountException.
 * 3. Exception caught in catch block → prints message.
 * 4. finally block executes → prints "Program reached to the end".
 *
 * =====================================================
 *   Key Learning:
 * =====================================================
 * - Custom exceptions help represent business-specific errors.
 * - They improve readability and debugging of real-world applications.
 * - `throw` is used to actually throw the exception object.
 * - `throws` is used in method signature to declare possible exceptions.
 */
