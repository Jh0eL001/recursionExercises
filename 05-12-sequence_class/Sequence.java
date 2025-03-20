
/*
* Exercise 05: Diseña una clase Secuencia que represente una secuencia de numeros enteros positivos.
*/
import java.util.ArrayList;
import java.util.Random;

public class Sequence {
  ArrayList<Integer> numbers;

  // Constructor sin parametros (inicia lista vacia)
  public Sequence() {
    this.numbers = new ArrayList<>();
  }

  // Constructor
  public Sequence(ArrayList<Integer> numbers) {
    this.numbers = numbers;
  }
  // 06. Agrega a la clase Secuencia, un metodo que permita sumar los elementos de la
  // secuencia.
  // Recursive method to add numbers
  public int recursiveSum(ArrayList<Integer> numbers) {
    // caso base: una lista vacia devuelve 0
    if (numbers.isEmpty()) {
      return 0;
    } else {
      // debug print.
      System.out.println("Lista Actual" + numbers);
      // obtenemos el primer elemento y llamos recursivamente al resto de la lista.
      // sum = number[0] + recursiveSum(numbers.remove(0)) quitamos el primer item en
      // cada llamada recursiva.
      int sum = numbers.get(0) + recursiveSum(new ArrayList<>(numbers.subList(1, numbers.size())));
      // debug print.
      System.out.println("The actual Sum is: " + sum);
      return sum;
    }
  }

  // 07. Agrega a la clase Secuencia, un metodo que permita encontrar el minimo
  // elemento de la secuencia.
  public int recursiveMin(ArrayList<Integer> numbers) {
    // Mostrar el estado actual de la lista
    System.out.println("Llamada recursiva con lista: " + numbers);

    // Caso base: si la lista tiene un solo elemento, ese es el mínimo
    if (numbers.size() == 1) {
      System.out.println("Caso base alcanzado con el número: " + numbers.get(0));
      return numbers.get(0);
    } else {
      // Llamada recursiva: obtener el mínimo del resto de la lista
      int minRest = recursiveMin(new ArrayList<>(numbers.subList(1, numbers.size())));

      // Mostrar el resultado de la recursión antes de la comparación
      System.out.println("Resultado de la recursión para el resto de la lista: " + minRest);

      // Comparar el primer elemento con el mínimo del resto de la lista
      int minNum = Math.min(numbers.get(0), minRest);

      // Mostrar la comparación final
      System.out.println("Comparando " + numbers.get(0) + " con " + minRest + ", mínimo es: " + minNum);

      return minNum;
    }
  }

  // main class
  public static void main(String[] args) {
    Random random = new Random();
    ArrayList<Integer> initialNumbers = new ArrayList<>();
    int size = 3; // numbers of random numbers to generate
    int min = 1, max = 100;
    for (int i = 0; i < size; i++) {
      initialNumbers.add(random.nextInt(max - min + 1) + min);
    }
    // Creamos un objeto de clase sequence
    Sequence seq1 = new Sequence(initialNumbers);
    // System.out.println("The Sum of the list is: " +
    // seq1.recursiveSum(initialNumbers));
    System.out.println("El numero minimo de la lista es: " + seq1.recursiveMin(initialNumbers));
  }
}
