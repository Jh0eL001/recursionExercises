import javax.swing.*;
import java.awt.*;

public class CopoDeNieveAnimado extends JPanel {
    private int nivelActual = 0; // Nivel inicial de recursión
    private final int nivelMax; // Nivel máximo de recursión
    private final Timer timer; // Temporizador para la animación

    // Constructor: inicializa el nivel máximo y la animación
    public CopoDeNieveAnimado(int nivelMax) {
        this.nivelMax = nivelMax;

        // Configurar un temporizador que aumenta el nivel y repinta
        timer = new Timer(1000, e -> {
            if (nivelActual < nivelMax) {
                nivelActual++;
                repaint();
            } else {
                ((Timer) e.getSource()).stop(); // Detiene la animación al llegar al nivel deseado
            }
        });

        timer.start(); // Inicia la animación
    }

    // Método recursivo para dibujar la curva de Koch
    private void dibujarKoch(Graphics2D g, int nivel, double x1, double y1, double x2, double y2) {
        if (nivel == 0) {
            g.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
        } else {
            double deltaX = x2 - x1;
            double deltaY = y2 - y1;
            double xA = x1 + deltaX / 3;
            double yA = y1 + deltaY / 3;
            double xB = x1 + 2 * deltaX / 3;
            double yB = y1 + 2 * deltaY / 3;

            // Punto medio para formar el triángulo
            double cos60 = Math.cos(Math.PI / 3);
            double sin60 = Math.sin(Math.PI / 3);
            double xC = (xA + xB) / 2 + (yA - yB) * sin60;
            double yC = (yA + yB) / 2 + (xB - xA) * sin60;

            // Dibujar recursivamente las 4 partes
            dibujarKoch(g, nivel - 1, x1, y1, xA, yA);
            dibujarKoch(g, nivel - 1, xA, yA, xC, yC);
            dibujarKoch(g, nivel - 1, xC, yC, xB, yB);
            dibujarKoch(g, nivel - 1, xB, yB, x2, y2);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setStroke(new BasicStroke(2));
        g2.setColor(Color.BLUE);

        int width = getWidth();
        int height = getHeight();

        // Coordenadas para el triángulo inicial
        double x1 = width / 4;
        double y1 = height * 3 / 4;
        double x2 = width * 3 / 4;
        double y2 = height * 3 / 4;
        double x3 = (x1 + x2) / 2;
        double y3 = height / 4;

        // Dibujar los 3 lados del triángulo de Koch con el nivel actual de animación
        dibujarKoch(g2, nivelActual, x1, y1, x2, y2);
        dibujarKoch(g2, nivelActual, x2, y2, x3, y3);
        dibujarKoch(g2, nivelActual, x3, y3, x1, y1);
    }

    // Método principal para ejecutar la animación
    public static void main(String[] args) {
        int nivel = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nivel máximo de recursión:"));
        JFrame frame = new JFrame("Copo de Nieve Animado");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.add(new CopoDeNieveAnimado(nivel));
        frame.setVisible(true);
    }
}
