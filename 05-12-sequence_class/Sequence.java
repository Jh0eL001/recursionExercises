import java.util.Arrays;

/*
 * 05. Design a Sequence class, that represents a sequence of numbers.
 */
public class Sequence {
  int[] numbers;

  // Constructor sin parámetros (inicia arreglo vacío)
  public Sequence() {
    this.numbers = new int[0];
  }

  // Constructor con un array de números
  public Sequence(int[] numbers) {
    this.numbers = numbers;
  }

  // 06. Recursive method to sum numbers
  public int recursiveSum(int[] numbers, int index) {
    // Caso base: cuando el índice es mayor o igual al tamaño del array
    if (index >= numbers.length) {
      return 0;
    }
    System.out.println("Sumando " + numbers[index] + " con el resultado de recursiveSum(" + (index + 1) + ")");
    int sum = numbers[index] + recursiveSum(numbers, index + 1);
    System.out.println("→ Resultado parcial en índice " + index + ": " + sum);
    return sum;
  }

  // 07. Método recursivo para encontrar el valor mínimo
  public int recursiveMin(int[] numbers, int index) {
    // Caso base: si solo queda un elemento, es el mínimo
    if (index == numbers.length - 1) {
      System.out.println("Caso base alcanzado: mínimo es " + numbers[index]);
      return numbers[index];
    }

    // Encontrar mínimo en el resto del arreglo
    int minRest = recursiveMin(numbers, index + 1);
    int minNum = Math.min(numbers[index], minRest);

    // Mensaje de depuración
    System.out.println("Comparando " + numbers[index] + " con " + minRest + ", mínimo es: " + minNum);
    return minNum;
  }

  // 08. Un método para ordenar una lista (Merge Sort)
  public int[] sort(int[] numbers) {
    // Caso Base cuando el array tiene uno o cero elementos.
    if (numbers.length <= 1) {
      return numbers;
    }

    int mid = numbers.length / 2;

    // Dividir en dos sub-arrays
    int[] left = Arrays.copyOfRange(numbers, 0, mid);
    int[] right = Arrays.copyOfRange(numbers, mid, numbers.length);

    // Mensajes de depuración
    System.out.println("Dividiendo: " + Arrays.toString(numbers));
    System.out.println("Izquierda: " + Arrays.toString(left));
    System.out.println("Derecha: " + Arrays.toString(right));

    // Llamadas recursivas para ordenar las mitades
    left = sort(left);
    right = sort(right);

    // Fusionar listas ordenadas
    int[] merged = merge(left, right);

    System.out.println("Fusionado: " + Arrays.toString(merged));
    return merged;
  }

  // 8.1 Método auxiliar para fusionar dos arreglos ordenados
  private int[] merge(int[] left, int[] right) {
    int[] result = new int[left.length + right.length];
    int i = 0, j = 0, k = 0;

    System.out.println("\n=== FUSIONANDO ===");
    System.out.println("Izquierda: " + Arrays.toString(left));
    System.out.println("Derecha: " + Arrays.toString(right));

    // Comparar y fusionar los elementos
    while (i < left.length && j < right.length) {
      if (left[i] < right[j]) {
        result[k++] = left[i++];
      } else {
        result[k++] = right[j++];
      }
    }

    // Agregar los elementos restantes
    while (i < left.length) {
      result[k++] = left[i++];
    }
    while (j < right.length) {
      result[k++] = right[j++];
    }

    System.out.println("Lista fusionada: " + Arrays.toString(result));
    return result;
  }

  // overload the quickSort method to pass-in only the array and not all the
  // parameters
  public void quickSort(int[] numbers) {
    quickSort(numbers, 0, numbers.length - 1);
  }

  // 8.2 Otro método para ordenar una lista (QuickSort)
  public void quickSort(int[] numbers, int lowIndex, int highIndex) {
    if (lowIndex >= highIndex) {
      return;
    }
    // choose a random pivot
    // int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
    int pivot = numbers[highIndex];
    // swap(numbers, pivotIndex, highIndex);

    int leftPointer = partition(numbers, lowIndex, highIndex, pivot);

    // Llamadas recursivas
    quickSort(numbers, lowIndex, leftPointer - 1);
    quickSort(numbers, leftPointer + 1, highIndex);
  }

  private int partition(int[] numbers, int lowIndex, int highIndex, int pivot) {
    int leftPointer = lowIndex;
    int rightPointer = highIndex;

    System.out.println("\n=== QUICK SORT ===");
    System.out.println("Antes de particionar: " + Arrays.toString(numbers));
    System.out.println("Pivote: " + pivot);

    while (leftPointer < rightPointer) {
      while (numbers[leftPointer] <= pivot && leftPointer < rightPointer) {
        leftPointer++;
      }
      while (numbers[rightPointer] >= pivot && leftPointer < rightPointer) {
        rightPointer--;
      }
      swap(numbers, leftPointer, rightPointer);
    }

    // Colocar el pivote en su posición correcta
    swap(numbers, leftPointer, highIndex);
    System.out.println("Después de particionar: " + Arrays.toString(numbers));
    return leftPointer;
  }

  // 8.2.1 Método auxiliar para intercambiar valores en un array
  private void swap(int[] numbers, int index1, int index2) {
    if (index1 != index2) {
      System.out.println("Intercambiando " + numbers[index1] + " con " + numbers[index2]);
      int temp = numbers[index1];
      numbers[index1] = numbers[index2];
      numbers[index2] = temp;
    }
  }

  // 09. Metodo para buscar un elemento en una lista. (Linear Search)
  public int linearSearch(int[] numbers, int pointer, int element) {
    if (pointer >= numbers.length) {
      return -1; // elemento No encontrado
    }
    if (numbers[pointer] == element) {
      return pointer; // Se encontró el elemento
    }
    return linearSearch(numbers, pointer + 1, element); // Llamada recursiva
  }

  // Método para imprimir un array
  public void printArray(int[] arr) {
    System.out.println("-> " + Arrays.toString(arr) + "\n");
  }
}
