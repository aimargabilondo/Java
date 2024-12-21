import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    static class Task {
        String description;
        boolean completed;

        Task(String description) {
            this.description = description;
            this.completed = false;
        }

        @Override
        public String toString() {
            return (completed ? "[x] " : "[ ] ") + description;
        }
    }

    private static ArrayList<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nGestor de Tareas:");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Marcar tarea como completada");
            System.out.println("3. Eliminar tarea");
            System.out.println("4. Mostrar tareas");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (choice) {
                case 1:
                    System.out.print("Descripción de la tarea: ");
                    String description = scanner.nextLine();
                    tasks.add(new Task(description));
                    System.out.println("Tarea agregada.");
                    break;
                case 2:
                    System.out.print("Número de tarea a completar: ");
                    int completeIndex = scanner.nextInt() - 1;
                    if (completeIndex >= 0 && completeIndex < tasks.size()) {
                        tasks.get(completeIndex).completed = true;
                        System.out.println("Tarea marcada como completada.");
                    } else {
                        System.out.println("Índice inválido.");
                    }
                    break;
                case 3:
                    System.out.print("Número de tarea a eliminar: ");
                    int removeIndex = scanner.nextInt() - 1;
                    if (removeIndex >= 0 && removeIndex < tasks.size()) {
                        tasks.remove(removeIndex);
                        System.out.println("Tarea eliminada.");
                    } else {
                        System.out.println("Índice inválido.");
                    }
                    break;
                case 4:
                    System.out.println("\nTareas:");
                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.println((i + 1) + ". " + tasks.get(i));
                    }
                    break;
                case 5:
                    System.out.println("Saliendo del Gestor de Tareas.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
