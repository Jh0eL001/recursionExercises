
// 1. Encuentra un metodo que permita definir la potencia de un numero. Los datos son a y b y lo que se desea es calcular a elevado a la b
import java.util.Scanner;

public class RecursivePower {
  // working with long for big numbers like 10^10
  public static long recursivePow(long a, int b) {
    long res;
    if (b == 0) { // Base case: anything raised to the power of 0 is 1
      return 1;
    } else if (b == 1) { // Second Base case: anything raised to the power of 1 is the number itself
      res = a;
      return res;
    } else {
      res = recursivePow(a, b - 1) * a;
    }
    return res;
  }

  // main method
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    // Input for the base (a)
    System.out.println("Enter the first number (the base): ");
    long base = scanner.nextLong();

    // Input for the exponent (check for negative values)
    int exponent = -1;
    while (exponent < 0) {
      System.out.println("Enter the second number (the exponent) MUST BE POSITIVE: ");

      if (scanner.hasNextInt()) {
        exponent = scanner.nextInt();
        if (exponent < 0) {
          System.out.println("Error: Exponent MUST BE POSITIVE (+)");
        }
      } else {
        System.out.println("Error: Invalid input. Please enter an Integer (1, 2, 3, 4..., etc.)");
        scanner.next(); // Consume invalid input to prevent infinite loop
      }
    }
    scanner.close();

    // Calling the recursive function and display the result
    long result = recursivePow(base, exponent);
    System.out.println(base + " raised to the power of " + exponent + " is: " + result);
  }
}
