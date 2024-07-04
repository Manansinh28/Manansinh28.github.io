/*
Name: Manansinh Vansia
Date: 20-06-2024
File name: Numeric_Functions
Descrpition: Using this program we can check whether a given number is even, positive, fibonacci,poweroftwo, prime, square.
 */


import java.util.Scanner;

public class Numeric_Functions {

    // Using this we will check if a number is even
    public static boolean isEven(int value) {
      // A number or value is considered even if it is divisible by 2 without a reminder
        return value % 2 == 0;
    }

    // Using this we will check if a number is positive
    public static boolean isPositive(int value) {
        // A number or value is considered is positive if it is greater than 0
        return value > 0;
    }

    // Using this we will check if a number is in the Fibonacci sequence
    public static boolean isFibonacci(int value) {
        // We can say that Fibonacci sequence starts with 1, 1 and each subsequent number is the sum of the previous two
        // As we know that Negative numbers and zero are not in the fibonacci sequence
        if (value <= 0) return false;
        // Here 1 is a Fibonacci number
        if (value == 1) return true;

        int a = 1, b = 1;
        while (b < value) {
            int temp = b;
            b += a;
            a = temp;
        }
        // We can say that if b is equal to the input value, then it is a Fibonacci number
        return b == value;
    }

    // Using this we will check if a number is a power of two
    public static boolean isPowerOfTwo(int value) {
        //  We can say that if a number is a power of two if it is greater then 0 and (value & (value - 1)) equals 0
        if (value <= 0) return false;
        return (value & (value - 1)) == 0;
    }

    // Using this we will check if a number is prime
    public static boolean isPrime(int value) {
        // We can say that if a prime number is greater than 1 and is not divisible by any number other than 1 and itself
        if (value <= 1) return false;
        for (int i = 2; i <= Math.sqrt(value); i++) {
            if (value % i == 0) return false;
        }
        return true;
    }

    // Using this we will check if a number is a square number
    public static boolean isSquare(int value) {
       // We can say that if a number is a square if its square root, when squared, equals the number
        if (value < 0) return false;
        // Here we know that negative numbers cannot be square numbers
        int sqrt = (int) Math.sqrt(value);
        return sqrt * sqrt == value;
    }

    // Main method to test the functionalities
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Here I have used Flag to control the loop
        boolean continueLoop = true;

        while (continueLoop) {
            System.out.print(" Please enter an integer value to test: ");
            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();

       // Testing that the entered value against all the methods and print the results
            System.out.println("Is " + value + " an even number? " + (isEven(value) ? "Yes." : "No."));
            System.out.println("Is " + value + " a positive number? " + (isPositive(value) ? "Yes." : "No."));
            System.out.println("Is " + value + " a Fibonacci number? " + (isFibonacci(value) ? "Yes." : "No."));
            System.out.println("Is " + value + " a power of two? " + (isPowerOfTwo(value) ? "Yes." : "No."));
            System.out.println("Is " + value + " a prime number? " + (isPrime(value) ? "Yes." : "No."));
            System.out.println("Is " + value + " a square number? " + (isSquare(value) ? "Yes." : "No."));
        } else {
                System.out.println("Non-integer entered, exiting.");
                // Setting the flag to false to exit the loop
                continueLoop = false;
            }
            scanner.nextLine();
        }

        scanner.close();
    }
}
