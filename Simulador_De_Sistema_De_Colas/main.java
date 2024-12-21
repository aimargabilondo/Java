import java.util.*;
import java.util.concurrent.*;

public class SimuladorColas {
    public static void main(String[] args) {
        Queue<String> cola = new LinkedList<>();
        cola.add("Cliente 1");
        cola.add("Cliente 2");
        cola.add("Cliente 3");

        ExecutorService servicio = Executors.newFixedThreadPool(1);

        while (!cola.isEmpty()) {
            servicio.submit(() -> {
                try {
                    String cliente = cola.poll();
                    System.out.println(cliente + " está siendo atendido.");
                    Thread.sleep(2000); 
                    System.out.println(cliente + " ha sido atendido.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        servicio.shutdown();
    }
}
