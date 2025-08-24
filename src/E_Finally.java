/*
 * =====================================================
 *   finally keyword in Java
 * =====================================================
 *
 * 1. What is finally?
 *    - A block of code that ALWAYS executes after try-catch.
 *    - Used for cleanup activities (closing files, DB connections, etc.).
 *    - Executes whether exception occurs or not.
 *
 * 2. Syntax:
 *    try {
 *        // risky code
 *    } catch(Exception e) {
 *        // handle exception
 *    } finally {
 *        // cleanup code (always runs)
 *    }
 *
 * 3. Key Rules:
 *    - finally block is optional, but if present:
 *        → It always runs (with or without exception).
 *    - Used to release resources like:
 *        → File handles
 *        → Database connections
 *        → Network sockets
 *
 * 4. Special Cases:
 *    a) If System.exit(0) is called in try/catch → finally will NOT run.
 *    b) If JVM crashes (power failure, hardware error) → finally may not run.
 *    c) Otherwise, finally is guaranteed to run.
 *
 * =====================================================
 *   Example Scenarios
 * =====================================================
 */

public class E_Finally {
    public static void main(String[] args) {

        // Example 1: No exception occurs
        try {
            System.out.println("Example 1: Inside try block (no exception)");
        } catch (Exception e) {
            System.out.println("Example 1: Inside catch block");
        } finally {
            System.out.println("Example 1: Finally block ALWAYS runs");
        }

        System.out.println("-------------------------------------------------");

        // Example 2: Exception occurs and is caught
        try {
            int a = 10 / 0; // ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Example 2: Exception caught -> " + e);
        } finally {
            System.out.println("Example 2: Finally block ALWAYS runs");
        }

        System.out.println("-------------------------------------------------");

        // Example 3: Exception occurs but is NOT caught
        try {
            int[] arr = new int[2];
            arr[5] = 100; // ArrayIndexOutOfBoundsException
        } catch (ArithmeticException e) {
            System.out.println("Example 3: This won't run (different exception)");
        } finally {
            System.out.println("Example 3: Finally block STILL runs");
        }

        System.out.println("-------------------------------------------------");

        // Example 4: System.exit()
        try {
            System.out.println("Example 4: About to exit program");
            System.exit(0); // Terminates JVM immediately
        } catch (Exception e) {
            System.out.println("Example 4: Catch block");
        } finally {
            // ⚠️ This will NOT run because JVM is terminated before
            System.out.println("Example 4: Finally block (won't execute)");
        }

        // This line will never be reached due to System.exit()
        System.out.println("End of Program");
    }
}

/*
 * =====================================================
 *   Key Learning:
 * =====================================================
 * - finally is used for cleanup → releasing resources.
 * - It runs:
 *      → If no exception occurs.
 *      → If exception occurs and is caught.
 *      → If exception occurs but not caught.
 * - It does NOT run only if:
 *      → JVM crashes
 *      → System.exit() is called
 *
 * Best Practice:
 * - Always use finally (or try-with-resources) to ensure
 *   resources like files, sockets, DB connections are closed properly.
 */
