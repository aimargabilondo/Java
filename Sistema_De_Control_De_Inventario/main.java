import java.util.*;

public class ControlInventario {
    private static Map<String, Integer> inventario = new HashMap<>();

    public static void agregarProducto(String producto, int cantidad) {
        inventario.put(producto, inventario.getOrDefault(producto, 0) + cantidad);
    }

    public static void eliminarProducto(String producto, int cantidad) {
        if (inventario.containsKey(producto)) {
            int cantidadActual = inventario.get(producto);
            if (cantidadActual >= cantidad) {
                inventario.put(producto, cantidadActual - cantidad);
            } else {
                System.out.println("No hay suficiente stock.");
            }
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    public static void mostrarInventario() {
        for (Map.Entry<String, Integer> entry : inventario.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        agregarProducto("Laptop", 10);
        agregarProducto("Teléfono", 5);
        mostrarInventario();
        eliminarProducto("Laptop", 3);
        mostrarInventario();
    }
}
