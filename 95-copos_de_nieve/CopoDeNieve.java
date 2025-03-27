public class CopoDeNieve {
    
    public static int generarCopos(int nivel) {
        // Condición base: si el nivel es 1, retorna 1 triángulo
        if (nivel == 1) {
            return 1;
        }
        // Relación recursiva: T(n) = 4 * T(n-1) + 1
        return 4 * generarCopos(nivel - 1) + 1;
    }

    public static void main(String[] args) {
        int nivel = 3; // Cambia el nivel para probar
        int cantidadTriangulos = generarCopos(nivel);
        System.out.println("Para un copo de nieve nivel " + nivel + " hay: " + cantidadTriangulos + " triángulos.");
    }
}
