import java.util.Scanner;
import java.util.Random;

public class JuegoAdivinanza {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("\u00a1Bienvenido al Juego de Adivinanza!");

        System.out.println("Selecciona la dificultad:");
        System.out.println("1. Fácil (Intentos ilimitados)");
        System.out.println("2. Medio (10 intentos)");
        System.out.println("3. Difícil (5 intentos)");
        System.out.print("Elige una opción: ");

        int dificultad = scanner.nextInt();
        int limiteIntentos = switch (dificultad) {
            case 2 -> 10;
            case 3 -> 5;
            default -> Integer.MAX_VALUE; 
        };

        int numero = random.nextInt(100) + 1;
        int intentos = 0;

        System.out.println("Adivina un número entre 1 y 100.");

        while (intentos < limiteIntentos) {
            System.out.print("Ingresa tu suposición: ");
            int suposicion = scanner.nextInt();
            intentos++;

            if (suposicion < numero) {
                System.out.println("Demasiado bajo. Intenta nuevamente.");
            } else if (suposicion > numero) {
                System.out.println("Demasiado alto. Intenta nuevamente.");
            } else {
                System.out.println("\u00a1Correcto! Adivinaste el número en " + intentos + " intentos.");
                break;
            }

            if (intentos == limiteIntentos && limiteIntentos != Integer.MAX_VALUE) {
                System.out.println("\u00a1Se te acabaron los intentos! El número era: " + numero);
            }
        }

        scanner.close();
    }
}
