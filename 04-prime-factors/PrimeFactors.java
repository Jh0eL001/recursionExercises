
/* 3. Escribe un proceso recursivo que permita calcular la cantidad de dıgitos que tiene un numero positivo n.
*  Write a recursive process that alows calculate the amount of digits a positive number n has.
*/
import java.util.Scanner;

public class PrimeFactors {
  public static void primeFact(int num, int factor) {
    if (num == 1) {
      return;
    } else if (num % factor == 0) {
      System.out.println(factor + " "); // Print the factor.
      primeFact(num / factor, factor); // Continue with the same factor. First Recursive CALL (num / factor)
    } else {
      primeFact(num, factor + 1); // Second Recursive CALL with (factor + 1)
    }
  }

  // main method
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int numero = -1;

    while (numero < 0) {
      System.out.println(
          "Ingrese un número entero positivo (puede ser cero): // Enter a positive number, it can be zero 0: ");
      try {
        // Intenta convertir la entrada en un número entero // tries to change the input
        // into a whole number.
        numero = Integer.parseInt(scanner.nextLine());
        if (numero < 0) {
          System.out
              .println("Error: El número no puede ser negativo. Intente de nuevo. // The number can't be negative.");
        }
      } catch (NumberFormatException e) {
        System.out.println("Error: Entrada no válida. Ingrese un número entero. // Invalid input. Type a number ");
      }
    }
    scanner.close(); // Cerramos el Scanner
    System.out.println("Los factores Primos de " + numero + " son: ");
    primeFact(numero, 2);
  }
}
