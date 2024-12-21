import java.util.*;

public class AplicacionNotas {
    private static Map<Integer, String> notas = new HashMap<>();
    private static int contador = 1;

    public static void agregarNota(String nota) {
        notas.put(contador++, nota);
    }

    public static void eliminarNota(int id) {
        if (notas.containsKey(id)) {
            notas.remove(id);
        } else {
            System.out.println("Nota no encontrada.");
        }
    }

    public static void mostrarNotas() {
        for (Map.Entry<Integer, String> entry : notas.entrySet()) {
            System.out.println("ID: " + entry.getKey() + " - " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        agregarNota("Comprar leche");
        agregarNota("Estudiar para el examen");
        mostrarNotas();
        eliminarNota(1);
        mostrarNotas();
    }
}
