/*
 * =====================================================
 *   try-with-resources in Java
 * =====================================================
 *
 * 1. What is try-with-resources?
 *    - Introduced in Java 7.
 *    - Special form of try statement that AUTOMATICALLY closes resources.
 *    - A resource is any object that implements AutoCloseable interface
 *      (e.g., FileReader, FileWriter, BufferedReader, Scanner, Connection).
 *
 * 2. Why use try-with-resources?
 *    - Before Java 7:
 *        → We had to use try-catch-finally and manually close resources in finally block.
 *        → Risk of resource leaks if we forgot to close.
 *    - With try-with-resources:
 *        → JVM automatically closes resources after try block (success or failure).
 *
 * 3. Syntax:
 *    try(ResourceType resource = new ResourceType()) {
 *        // use the resource
 *    } catch(Exception e) {
 *        // handle exception
 *    }
 *    // resource is automatically closed here
 *
 * 4. Behind the scenes:
 *    - Compiler adds an implicit finally block to call resource.close().
 *    - So we don’t need to write it manually.
 *
 * =====================================================
 *   Example
 * =====================================================
 */

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class F_Try_With_Resources {
    public static void main(String[] args) {

        // Example 1: Normal usage with file
        try (FileReader fr = new FileReader("a.txt");
             BufferedReader br = new BufferedReader(fr)) {

            // Reading first line from file
            String line = br.readLine();
            System.out.println("Read from file: " + line);

        } catch (IOException e) {
            // If file not found or error while reading
            System.out.println("Exception occurred: " + e);
        }
        // FileReader and BufferedReader automatically closed here
        System.out.println("-------------------------------------------------");

        // Example 2: Multiple resources in one try
        // Both resources will be closed automatically in reverse order of opening
        try (FileReader fr = new FileReader("a.txt");
             BufferedReader br = new BufferedReader(fr)) {

            System.out.println("Reading again: " + br.readLine());

        } catch ( IOException e) {
            System.out.println("Handled exception: " + e);
        }

        System.out.println("-------------------------------------------------");

        // Example 3: Custom resource
        try (MyResource res = new MyResource()) {
            res.doSomething();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        // MyResource.close() will be automatically called
    }
}

/*
 * =====================================================
 *   Custom Resource Example
 * =====================================================
 * Any class implementing AutoCloseable can be used in try-with-resources.
 */
class MyResource implements AutoCloseable {
    public void doSomething() {
        System.out.println("Using MyResource...");
    }

    @Override
    public void close() {
        System.out.println("MyResource closed automatically!");
    }
}

/*
 * =====================================================
 *   Key Learning:
 * =====================================================
 * - try-with-resources ensures that resources are closed automatically.
 * - It reduces boilerplate code compared to try-finally.
 * - Works only with classes that implement AutoCloseable (or Closeable).
 * - Multiple resources can be declared in the same try().
 *
 * Best Practice:
 * - Always prefer try-with-resources when working with files,
 *   database connections, sockets, etc. to prevent memory leaks.
 */
