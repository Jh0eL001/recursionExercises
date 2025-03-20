
/* 3. Escribe un proceso recursivo que permita calcular la cantidad de dıgitos que tiene un numero positivo n.
*  Write a recursive process that alows calculate the amount of digits a positive number n has.
*/
import java.util.Scanner;

public class DigitCountRecursive {
  public static int recursiveDigitCount(int num) {
    // Definimos la cantidad de dígitos, empezando en 1
    int digits = 1;

    // Caso base: Si el número es menor que 10, devolvemos 1
    if (num < 10) {
      System.out.println("Caso base: num = " + num + ", digits = " + digits);
      return digits;
    } else {
      // Llamada recursiva: Dividimos el número por 10 y seguimos contando
      System.out.println("Llamada recursiva: num = " + num + ", digits = " + digits);
      digits += recursiveDigitCount(num / 10);  // Llamada recursiva
    }
    
    // Retornamos el número total de dígitos después de la llamada recursiva
    System.out.println("Regresando de la llamada: num = " + num + ", digits = " + digits);
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
    System.out.println("The number " + numero + " has: " + recursiveDigitCount(numero) + " digit(s)");

  }
}
