/*
 * ===============================
 *   Types of Errors in Java
 * ===============================
 * 1. Syntax Error:
 *    - Occurs when code violates Java language rules.
 *    - Example: Missing semicolon, misspelled keywords.
 *    - Caught at compile-time.
 *
 * 2. Logical Error:
 *    - Code compiles and runs, but produces wrong output.
 *    - Example: Using + instead of * for multiplication.
 *    - Hardest to detect since program "runs fine".
 *
 * 3. Runtime Error:
 *    - Errors that occur while program is running.
 *    - Example: Division by zero, array index out of bounds.
 *    - These lead to **Exceptions** in Java.
 *
 * ===============================
 *   Exception in Java
 * ===============================
 * - Exception is an event that disrupts the normal flow of a program.
 * - It is an object created when an error occurs at runtime.
 * - Example: ArithmeticException, NullPointerException, etc.
 *
 * Exception Handling allows us to:
 *   1. Detect runtime errors.
 *   2. Handle them gracefully (without crashing).
 *   3. Continue program execution normally.
 */

public class A_Intro {

    // Arrays for numerator and denominator values
    static int[] numerator = {1, 2, 3, 4, 6};
    static int[] denominator = {1, 2, 0, 4, 6};  // Note: denominator[2] = 0 will cause divide by zero error

    // Method to perform division
    static void divide() {
        // Loop through each index of the arrays
        for (int i = 0; i < numerator.length; i++) {
            try {
                // Try block: code that may throw exception
                int val = numerator[i] / denominator[i];  // may throw ArithmeticException (when denominator = 0)
                System.out.println(val);
            } catch (ArithmeticException e) {
                // Catch block: handles ArithmeticException
                // Here, division by zero will be caught
                System.out.println("Exception caught: " + e);
            }
        }
        // Program continues execution after handling exception
        System.out.println("Job Done");
    }

    // Main method - entry point of program
    public static void main(String[] args) {
        // Calling divide() method
        A_Intro.divide();
    }
}
