import java.util.Scanner;

public class Factorial {

  public static long fact(int num) {
    /*
     * For positive numbers only, including zero.
     */
    long result;
    if (num == 0) {
      result = 1;
    } else {
      result = fact(num - 1) * num;
    }
    return result;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int numero = -1;

    while (numero < 0) {
      System.out.println("Ingrese un número entero positivo (incluyendo 0): ");
      try {
        numero = Integer.parseInt(scanner.nextLine()); // Intenta convertir la entrada en un número entero
        if (numero < 0) {
          System.out.println("Error: El número no puede ser negativo. Intente de nuevo.");
        }
      } catch (NumberFormatException e) {
        System.out.println("Error: Entrada no válida. Ingrese un número entero.");
      }
    }
    scanner.close(); // Cerramos el Scanner
    System.out.println("El factorial de " + numero + " es: " + fact(numero));

  }
}
