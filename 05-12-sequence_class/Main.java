import java.util.ArrayList;
import java.util.Random;

public class Main {
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
