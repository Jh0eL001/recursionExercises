
/*
* Exercise 05: Diseña una clase Secuencia que represente una secuencia de numeros enteros positivos.
*/
import java.util.ArrayList;

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

  // Recursive method to add numbers
  public int recursiveSum(ArrayList<Integer> numbers) {
    // caso base: una lista vacia devuelve 0
    if (numbers.isEmpty()) {
      return 0;
    } else {
      // obtenemos el primer elemento y llamos recursivamente al resto de la lista.
      int sum = numbers.get(0) + recursiveSum(new ArrayList<>(numbers.subList(1, numbers.size())));
      return sum;
    }
  }

  // 07. un metodo que permita encontrar el minimo elemento de la secuencia.
  public int recursiveMin(ArrayList<Integer> numbers) {
    // Caso base: si la lista tiene un solo elemento, ese es el mínimo
    if (numbers.size() == 1) {
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
}
