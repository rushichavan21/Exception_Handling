/*
 * =====================================================
 *   throw vs throws in Java
 * =====================================================
 *
 * 1. throw (keyword)
 *    - Used INSIDE a method to explicitly throw an exception.
 *    - We throw a SINGLE exception object.
 *    - Syntax: throw new ExceptionType("Message");
 *    - Example:
 *        if(file == null) {
 *            throw new FileNotFoundException("File not found!");
 *        }
 *
 * 2. throws (keyword)
 *    - Used in the method declaration to declare that a method
 *      may throw one or more exceptions.
 *    - It informs the CALLER of the method that they must handle it.
 *    - Syntax: returnType methodName() throws Exception1, Exception2 { ... }
 *
 * ✅ Key Difference:
 * - "throw" → actually throws the exception object at runtime.
 * - "throws" → declares that a method *might* throw an exception.
 *
 * =====================================================
 *   Checked vs Unchecked Exceptions
 * =====================================================
 *
 * 1. Checked Exceptions:
 *    - Checked at compile time.
 *    - Compiler forces you to handle them using try-catch
 *      OR declare them using "throws".
 *    - Examples: IOException, SQLException, FileNotFoundException.
 *    - In this code: FileNotFoundException is a CHECKED exception,
 *      so we must declare "throws FileNotFoundException".
 *
 * 2. Unchecked Exceptions:
 *    - Subclasses of RuntimeException.
 *    - Checked at runtime only (compiler does not force handling).
 *    - Examples: ArithmeticException, NullPointerException,
 *                ArrayIndexOutOfBoundsException.
 *    - Example: int x = 10 / 0; // ArithmeticException
 *      → No need to declare "throws ArithmeticException".
 *
 * ✅ Rule:
 * - Checked Exception → must handle or declare (compile-time check).
 * - Unchecked Exception → optional to handle (runtime check).
 *
 * =====================================================
 */

import java.io.FileNotFoundException;
import java.io.FileReader;

public class D_Throws  {

    // main method also declares "throws Exception"
    // Meaning: if any exception occurs here and is not handled,
    // it will be passed to JVM (Java Virtual Machine).
    public static void main(String[] args) throws Exception {
        method2();  // calling method2
    }

    // method1 declares "throws FileNotFoundException"
    // Because FileReader constructor throws FileNotFoundException (a checked exception).
    // Compiler forces us to either handle it (try-catch) OR declare it.
    public static void method1() throws FileNotFoundException {
        // Trying to open a.txt file
        // If the file is missing, FileNotFoundException will be thrown
        FileReader fl = new FileReader("a.txt");
    }

    // method2 calls method1
    // Instead of handling the exception here, we also declare
    // "throws FileNotFoundException" → passing the responsibility
    // to the caller (in this case, main()).
    public static void method2() throws FileNotFoundException {
        method1(); // calling method1 which may throw exception
    }
}

/*
 * =====================================================
 *   PROGRAM FLOW (when "a.txt" does NOT exist)
 * =====================================================
 * 1. main() calls method2()
 * 2. method2() calls method1()
 * 3. method1() tries to open "a.txt" → file not found
 * 4. Java creates a FileNotFoundException object
 * 5. Since method1() declared "throws FileNotFoundException",
 *    it does NOT handle it → passes it to method2()
 * 6. method2() also declared "throws FileNotFoundException",
 *    so it passes it to main()
 * 7. main() declared "throws Exception" → passes it to JVM
 * 8. JVM prints the stack trace (error message).
 *
 * =====================================================
 *   Example Output:
 * =====================================================
 * Exception in thread "main" java.io.FileNotFoundException: a.txt (No such file or directory)
 *     at java.io.FileInputStream.open0(Native Method)
 *     at java.io.FileInputStream.open(FileInputStream.java:195)
 *     at java.io.FileInputStream.<init>(FileInputStream.java:138)
 *     at java.io.FileReader.<init>(FileReader.java:72)
 *     at D_Throws.method1(D_Throws.java:60)
 *     at D_Throws.method2(D_Throws.java:67)
 *     at D_Throws.main(D_Throws.java:46)
 *
 * =====================================================
 *   Key Learning:
 * =====================================================
 * - "throw" → actually throws an exception (one object).
 * - "throws" → declares that a method *might* throw an exception.
 * - Checked Exception (FileNotFoundException) → must be declared or handled.
 * - Unchecked Exception (like ArithmeticException) → no need to declare.
 * - Best practice: handle exceptions close to where they occur,
 *   instead of always passing them up to main().
 */
