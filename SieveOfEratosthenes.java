// Author: Manansinh Vansia
// Date: 14-06-2024
//File name: SieveOfEratosthenes
// Description: This program will uses the prime numbers to provide all prime numbers as an output up to a limit which is given by the user.

import java.util.Scanner;

public class SieveOfEratosthenes {

    public static void main(String[] args) {
        int upperBound = getUpperBound();
        boolean[] isPrime = sieveOfEratosthenes(upperBound);
        printPrimes(isPrime);
    }


    // Asking the user for an integer between 2 and 1000
    private static int getUpperBound() {
        Scanner scanner = new Scanner(System.in);
        int upperBound = 0;

        while (true) {
            System.out.print("Please enter an integer between 2 and 1000: ");
            if (scanner.hasNextInt()) {
                upperBound = scanner.nextInt();
                if (upperBound >= 2 && upperBound <= 1000) {
                    break;
                } else {
                    System.out.println("Error. Please enter an integer between 2 and 1000.");
                }
            } else {
                System.out.println("The input is Invalid. Please enter an integer between 2 and 1000.");
                scanner.next(); // Clear the invalid input
            }
        }

        return upperBound;
    }


    // Using the Sieve of Eratosthenes algorithm to find all prime numbers up to the provided limit.
    private static boolean[] sieveOfEratosthenes(int limit) {
        boolean[] isPrime = new boolean[limit + 1];

        // starting the array to true
        for (int i = 2; i <= limit; i++) {
            isPrime[i] = true;
        }

        // using the Sieve of Eratosthenes
        for (int num = 2; num * num <= limit; num++) {
            if (isPrime[num]) {
                for (int multiple = num * num; multiple <= limit; multiple += num) {
                    isPrime[multiple] = false;
                }
            }
        }

        return isPrime;
    }

    //printing the prime numbers as per the boolean array from the Sieve of Eratosthenes.
    private static void printPrimes(boolean[] isPrime) {
        System.out.println("Prime numbers which are up to the provided limit are:");
        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}