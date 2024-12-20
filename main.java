// This program demonstrates exception handling in Java by simulating and managing various exceptions
// through practical scenarios. Each exception is triggered deliberately, caught using try-catch blocks,
// and explained with detailed comments.

// Import required classes
import java.io.*;
import java.sql.*;

public class ExceptionsDemo {
    
    // Checked Exceptions

    // 1. IOException
    public static void simulateIOException() {
        try {
            // Trying to read a file that does not exist
            FileReader reader = new FileReader("nonexistentfile.txt");
        } catch (IOException e) {
            // Handling IOException
            System.out.println("IOException caught: " + e.getMessage());
        }
    }

// 2. FileNotFoundException
    public static void simulateFileNotFoundException() {
        try {
            // Trying to open a missing file
            FileInputStream file = new FileInputStream("missingfile.txt");
        } catch (FileNotFoundException e) {
            // Handling FileNotFoundException
            System.out.println("FileNotFoundException caught: " + e.getMessage());
        }
    }

    // 3. EOFException
    public static void simulateEOFException() {
        try (DataInputStream input = new DataInputStream(new FileInputStream("emptyfile.txt"))) {
            // Trying to read beyond the end of the file
            input.readUTF();
        } catch (EOFException e) {
            // Handling EOFException
            System.out.println("EOFException caught: " + e.getMessage());
        } catch (IOException e) {
            // Handling IOException
            System.out.println("IOException caught: " + e.getMessage());
        }
    }
 // 4. SQLException
    public static void simulateSQLException() {
        try {
            // Trying to connect to a non-existent database
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/nonexistentDB", "user", "pass");
        } catch (SQLException e) {
            // Handling SQLException
            System.out.println("SQLException caught: " + e.getMessage());
        }
    }

    // 5. ClassNotFoundException
    public static void simulateClassNotFoundException() {
        try {
            // Trying to load a class that does not exist
            Class.forName("com.nonexistent.Driver");
        } catch (ClassNotFoundException e) {
            // Handling ClassNotFoundException
            System.out.println("ClassNotFoundException caught: " + e.getMessage());
        }
    }

    // Unchecked Exceptions

 // 6. ArithmeticException
    public static void simulateArithmeticException() {
        try {
            // Division by zero
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            // Handling ArithmeticException
            System.out.println("ArithmeticException caught: " + e.getMessage());
        }
    }

    // 7. NullPointerException
    public static void simulateNullPointerException() {
        try {
            // Accessing a method on a null object
            String str = null;
            System.out.println(str.length());
        } catch (NullPointerException e) {
            // Handling NullPointerException
            System.out.println("NullPointerException caught: " + e.getMessage());
        }
    }
  // 8. ArrayIndexOutOfBoundsException
    public static void simulateArrayIndexOutOfBoundsException() {
        try {
            // Accessing an invalid index in an array
            int[] array = new int[5];
            System.out.println(array[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            // Handling ArrayIndexOutOfBoundsException
            System.out.println("ArrayIndexOutOfBoundsException caught: " + e.getMessage());
        }
    }

    // 9. ClassCastException
    public static void simulateClassCastException() {
        try {
            // Invalid casting between unrelated types
            Object obj = new Integer(100);
            String str = (String) obj;
        } catch (ClassCastException e) {
            // Handling ClassCastException
            System.out.println("ClassCastException caught: " + e.getMessage());
        }
    }

 // 10. IllegalArgumentException
    public static void simulateIllegalArgumentException() {
        try {
            // Passing an invalid argument to a method
            Thread.sleep(-1000);
        } catch (IllegalArgumentException e) {
            // Handling IllegalArgumentException
            System.out.println("IllegalArgumentException caught: " + e.getMessage());
        } catch (InterruptedException e) {
            // Handling InterruptedException
            System.out.println("InterruptedException caught: " + e.getMessage());
        }
    }

    // 11. NumberFormatException
    public static void simulateNumberFormatException() {
        try {
            // Attempting to parse an invalid number format
            int number = Integer.parseInt("InvalidNumber");
        } catch (NumberFormatException e) {
            // Handling NumberFormatException
            System.out.println("NumberFormatException caught: " + e.getMessage());
        }
    }
  // Main method
    public static void main(String[] args) {
        System.out.println("Simulating Checked Exceptions:");
        simulateIOException();
        simulateFileNotFoundException();
        simulateEOFException();
        simulateSQLException();
        simulateClassNotFoundException();

        System.out.println("\nSimulating Unchecked Exceptions:");
        simulateArithmeticException();
        simulateNullPointerException();
        simulateArrayIndexOutOfBoundsException();
        simulateClassCastException();
        simulateIllegalArgumentException();
        simulateNumberFormatException();
    }
}