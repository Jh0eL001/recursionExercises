import java.util.Arrays;
import java.util.Random;

public class Main {
  public static void main(String[] args) {
    Random random = new Random();

    // Generar un array de números aleatorios de tamaño 7
    int[] randomNumbers1 = new int[30];
    for (int i = 0; i < randomNumbers1.length; i++) {
      randomNumbers1[i] = random.nextInt(100); // Números entre 0 y 99
    }

    // Generar otro array de números aleatorios de tamaño 7
    int[] randomNumbers2 = new int[10];
    for (int i = 0; i < randomNumbers2.length; i++) {
      randomNumbers2[i] = random.nextInt(100);
    }
    int[] fixedList = new int[] { 3, 2, 5, 0, 1, 8, 7, 6, 9, 4 };
    // Crear objetos Sequence con los arrays aleatorios
    Sequence sequence = new Sequence(randomNumbers1);
    Sequence sequence2 = new Sequence(fixedList);

    // Imprimir los arrays generados aleatoriamente
    // System.out.println("\n-> Secuencia 1 (antes de ordenar):");
    // sequence.printArray(sequence.numbers);

    // System.out.println("\n-> Secuencia 2 (antes de ordenar):");
    // sequence2.printArray(sequence2.numbers);
    // ---------- Prueba Ejercicio 06
    // ------------------------------------------------ //
    // System.out.println("Suma Recursiva: " +
    // sequence.recursiveSum(sequence.numbers, 0));

    // ---------- Prueba Ejercicio 07
    // ------------------------------------------------ //
    // System.out.println("Mínimo Recursivo: " +
    // sequence.recursiveMin(sequence.numbers, 0));

    // ---------- Prueba Ejercicio 08
    // ------------------------------------------------ //
    // System.out.println("\nMerge Sort:");
    // int[] sortedNumbers = sequence.sort(sequence.numbers);
    // sequence.printArray(sortedNumbers);

    // ---------- Prueba Ejercicio 8.1
    // ------------------------------------------------ //
    // System.out.println("\nQuickSort:");
    // hacemos una copia del objeto sequence 2 para no modificar los valores
    // directamente.
    // int[] quickSortNumbers = Arrays.copyOf(sequence2.numbers,
    // sequence2.numbers.length);
    // sequence2.quickSort(quickSortNumbers);
    // sequence2.printArray(quickSortNumbers);
    // ---------- FIN Prueba Ejercicio 8.1
    // ------------------------------------------------ //
    // ---------- Prueba Ejercicio 09
    // ----------------------------------------------- //
    System.out.println("09. Busqueda Recursiva:");
    // hacemos una copia del objeto sequence 2 para no modificar los valores
    // directamente.
    int[] arrayForSearch = Arrays.copyOf(sequence.numbers, sequence.numbers.length);
    int elementToSearch = random.nextInt(100);
    System.out.println("\n-> Buscaremos el numero " + elementToSearch + " en la siguiente lista: ");
    sequence.printArray(sequence.numbers);
    // para probar el metodo creamos una variable que guarde el resultado -1 o 0
    int index = sequence2.linearSearch(arrayForSearch, 0, elementToSearch);
    if (index != -1) {
      System.out.println("Result: The number " + elementToSearch + " is in the list at position: " + index);
    } else {
      System.out.println("Result: The number " + elementToSearch + " is NOT in the list.");
    }
    // ---------- FIN Prueba Ejercicio 09
    // ------------------------------------------------ //
  }
}