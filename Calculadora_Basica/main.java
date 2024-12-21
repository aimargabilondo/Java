import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\u00a1Bienvenido a la Calculadora Básica!");
        System.out.println("Operaciones disponibles:");
        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.println("3. Multiplicación");
        System.out.println("4. División");
        System.out.println("5. Salir");

        while (true) {
            System.out.print("\nElige una opción (1-5): ");
            int opcion = scanner.nextInt();

            if (opcion == 5) {
                System.out.println("Saliendo de la calculadora. \u00a1Adios!");
                break;
            }

            if (opcion < 1 || opcion > 5) {
                System.out.println("Opción no válida. Por favor, elige entre 1 y 5.");
                continue;
            }

            System.out.print("Ingresa el primer número: ");
            double num1 = scanner.nextDouble();
            System.out.print("Ingresa el segundo número: ");
            double num2 = scanner.nextDouble();

            switch (opcion) {
                case 1:
                    System.out.println("Resultado: " + (num1 + num2));
                    break;
                case 2:
                    System.out.println("Resultado: " + (num1 - num2));
                    break;
                case 3:
                    System.out.println("Resultado: " + (num1 * num2));
                    break;
                case 4:
                    if (num2 == 0) {
                        System.out.println("Error: No se puede dividir entre cero.");
                    } else {
                        System.out.println("Resultado: " + (num1 / num2));
                    }
                    break;
                default:
                    System.out.println("Algo salió mal. Por favor, intenta de nuevo.");
            }
        }

        scanner.close();
    }
}
