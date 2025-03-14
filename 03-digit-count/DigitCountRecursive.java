
/* 3. Escribe un proceso recursivo que permita calcular la cantidad de dıgitos que tiene un numero positivo n.
*  Write a recursive process that alows calculate the amount of digits a positive number n has.
*/
import java.util.Scanner;

public class DigitCountRecursive {
  public static int recursiveDigitCount(int num) {
    int digits = 1;
    if (num < 10) {
      return digits;
    } else {
      digits += recursiveDigitCount(num / 10);
    }
    return digits;
  }

  // main method
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int numero = -1;

    while (numero < 0) {
      System.out.println("Ingrese un número entero positivo (puede ser cero): // Enter a positive number, it can be zero 0: ");
      try {
        // Intenta convertir la entrada en un número entero // tries to change the input into a whole number.
        numero = Integer.parseInt(scanner.nextLine()); 
        if (numero < 0) {
          System.out.println("Error: El número no puede ser negativo. Intente de nuevo. // The number can't be negative.");
        }
      } catch (NumberFormatException e) {
        System.out.println("Error: Entrada no válida. Ingrese un número entero. // Invalid input. Type a number ");
      }
    }
    scanner.close(); // Cerramos el Scanner
    System.out.println("El numero " + numero + " tiene: " + recursiveDigitCount(numero) + " digito(s)");
    System.out.println("The number " + numero + " has: " + recursiveDigitCount(numero) + " digit(s)");

  }
}
