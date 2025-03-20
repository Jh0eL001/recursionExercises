# 06 Method to do a recursive sum with print statements for debug

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

## 07. un metodo que permita encontrar el minimo elemento de la secuencia con prints para debuggear.

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