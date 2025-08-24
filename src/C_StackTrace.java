/*
 * ===========================================
 *   Stack Trace in Java
 * ===========================================
 * - A stack trace is a report of the active stack frames
 *   (the chain of method calls) at the point where an exception occurred.
 *
 * - When an exception is thrown, Java records:
 *     1. Which method caused the exception.
 *     2. Which methods were called before it.
 *     3. The exact line number where the exception happened.
 *
 * - This helps in debugging and locating the cause of errors.
 */

public class C_StackTrace {
    public static void main(String[] args) {
        try {
            // Call level1(), which will trigger a chain of method calls
            level1();
        } catch (Exception e) {
            // Get the stack trace of the exception
            StackTraceElement[] stackTraceElements = e.getStackTrace();

            // Print each element of the stack trace
            // Each element shows: ClassName.MethodName(FileName:LineNumber)
            for (StackTraceElement stackTraceElement : stackTraceElements) {
                System.out.println(stackTraceElement);
            }

            // Alternative shortcut:
            // e.printStackTrace();  <-- directly prints stack trace
        }

        // Code continues even after handling exception
        System.out.println("Code Reached to the end");
    }

    // level1() calls level2()
    public static void level1() {
        level2();
    }

    // level2() calls level3()
    public static void level2() {
        level3();
    }

    // level3() creates an error
    public static void level3() {
        int[] arr = new int[5];  // array of size 5 (valid indices: 0–4)
        arr[5] = 10;             // ❌ Invalid index → ArrayIndexOutOfBoundsException
    }
}

/*
 * ===========================================
 *   Program Flow:
 * ===========================================
 * main() → level1() → level2() → level3()
 *
 * Error occurs in level3():
 *    arr[5] = 10;  // Index out of range
 *
 * Exception thrown → propagated back to caller methods
 * Stack trace shows this chain of calls.
 *
 * Example Output:
 * C_StackTrace.level3(C_StackTrace.java:42)
 * C_StackTrace.level2(C_StackTrace.java:36)
 * C_StackTrace.level1(C_StackTrace.java:31)
 * C_StackTrace.main(C_StackTrace.java:11)
 *
 * ===========================================
 *   Key Learning:
 * ===========================================
 * - Stack trace is extremely useful for debugging.
 * - It tells where the error occurred and how the program reached there.
 */
