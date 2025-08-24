/*
 * =============================================
 *   Exception Hierarchy in Java
 * =============================================
 * - All exceptions/errors in Java are subclasses of `Throwable`.
 * - Throwable has 2 main branches:
 *     1. Error   (serious problems, not recoverable)
 *     2. Exception (can be handled by the program)
 *
 * Exception has 2 categories:
 *   (a) Checked Exceptions  → must be handled (IOException, SQLException, etc.)
 *   (b) Unchecked Exceptions (RuntimeException and subclasses like
 *       ArithmeticException, NullPointerException, IndexOutOfBoundsException)
 *
 * =============================================
 *   Why catch child exception before parent?
 * =============================================
 * - Java checks catch blocks in order (top to bottom).
 * - If parent is written first, it will catch the exception before the child block is ever reached.
 *   --> Compiler error: "exception X has already been caught"
 *
 * Example:
 *   try {
 *       int a = 10/0;   // ArithmeticException
 *   } catch(Exception e) {
 *       // This will catch EVERYTHING (too generic).
 *   } catch(ArithmeticException e) {
 *       // Unreachable code → compiler error
 *   }
 *
 * ✅ Correct order:
 *   catch(ArithmeticException e) { ... }
 *   catch(RuntimeException e) { ... }
 *   catch(Exception e) { ... }
 *
 * - Specific (child) exceptions → handled first.
 * - Generic (parent) exceptions → handled later.
 */

public class B_Hierarchy {
    public static void main(String[] args) {
        try {
            int a = 10 / 0; // This will throw ArithmeticException
        }
        catch (ArithmeticException e) {
            // Child exception (more specific)
            System.out.println("Caught ArithmeticException: " + e);
        }
        catch (RuntimeException e) {
            // Parent of ArithmeticException
            System.out.println("Caught RuntimeException: " + e);
        }
        catch (Exception e) {
            // Parent of all exceptions
            System.out.println("Caught Exception: " + e);
        }

        System.out.println("Program continues after handling exception...");
    }
}
