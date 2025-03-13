import java.util.Scanner;

public class RecursivePrime {
  public static boolean isPrime(int number, int div) {
    if (number == 1) {
      return false;
    }
    // Base case: if div reaches 1, the number is prime
    else if (div == 1) {
      return true;
    }
    // If number is divisible by div, it's not prime
    else if (number % div == 0) {
      return false;
    }
    // Recursive case: reduce the divisor and check
    return isPrime(number, div - 1);
  }

  // main method
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int number = -1;
    while (number <= 0) {
      System.out.print("Please enter a positive integer to check if it's prime: ");
      try {
        number = Integer.parseInt(scanner.nextLine()); // Try to parse the user input as an integer
        if (number <= 0) {
          System.out.println("The number must be greater than 0. Try again.");
        }
      } catch (NumberFormatException e) {
        System.out.println("Invalid input! Please enter a valid positive integer.");
      }
    }

    // We start the recursion with div as number - 1
    if (isPrime(number, number - 1)) {
      System.out.println(number + " is a prime number.");
    } else {
      System.out.println(number + " is NOT a prime number.");
    }

    scanner.close(); // Don't forget to close the scanner!
  }
}
