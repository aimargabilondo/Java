import java.io.*;
import java.net.*;
import java.util.*;

class ServidorChat {
    private static Set<PrintWriter> clientes = new HashSet<>();

    public static void main(String[] args) {
        System.out.println("Servidor de chat iniciado...");

        try (ServerSocket servidor = new ServerSocket(12345)) {
            while (true) {
                Socket cliente = servidor.accept();
                System.out.println("Cliente conectado: " + cliente.getInetAddress());
                new Thread(new ManejadorCliente(cliente)).start();
            }
        } catch (IOException e) {
            System.err.println("Error en el servidor: " + e.getMessage());
        }
    }

    private static class ManejadorCliente implements Runnable {
        private Socket socket;
        private PrintWriter salida;

        public ManejadorCliente(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                salida = new PrintWriter(socket.getOutputStream(), true);
                synchronized (clientes) {
                    clientes.add(salida);
                }

                String mensaje;
                while ((mensaje = entrada.readLine()) != null) {
                    System.out.println("Mensaje recibido: " + mensaje);
                    synchronized (clientes) {
                        for (PrintWriter cliente : clientes) {
                            cliente.println(mensaje);
                        }
                    }
                }
            } catch (IOException e) {
                System.err.println("Error con el cliente: " + e.getMessage());
            } finally {
                synchronized (clientes) {
                    clientes.remove(salida);
                }
                try {
                    socket.close();
                } catch (IOException e) {
                    System.err.println("No se pudo cerrar el socket: " + e.getMessage());
                }
            }
        }
    }
}

// Cliente de Chat en Tiempo Real
class ClienteChat {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345);
             BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Conectado al servidor de chat. Escribe tus mensajes:");

            Thread lectorMensajes = new Thread(() -> {
                String mensajeServidor;
                try {
                    while ((mensajeServidor = entrada.readLine()) != null) {
                        System.out.println(mensajeServidor);
                    }
                } catch (IOException e) {
                    System.err.println("Conexión cerrada.");
                }
            });

            lectorMensajes.start();

            while (true) {
                String mensaje = scanner.nextLine();
                salida.println(mensaje);
            }
        } catch (IOException e) {
            System.err.println("Error en el cliente: " + e.getMessage());
        }
    }
}
