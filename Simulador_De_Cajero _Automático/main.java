import java.util.Scanner;

public class CajeroAutomatico {
    private double saldo;

    public CajeroAutomatico(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public void consultarSaldo() {
        System.out.println("Saldo disponible: " + saldo);
    }

    public void retirar(double monto) {
        if (monto <= saldo) {
            saldo -= monto;
            System.out.println("Retiraste: " + monto);
        } else {
            System.out.println("Saldo insuficiente");
        }
    }

    public void depositar(double monto) {
        saldo += monto;
        System.out.println("Depositaste: " + monto);
    }

    public static void main(String[] args) {
        CajeroAutomatico cajero = new CajeroAutomatico(1000);
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n1. Consultar saldo");
            System.out.println("2. Retirar dinero");
            System.out.println("3. Depositar dinero");
            System.out.println("4. Salir");
            System.out.print("Elija una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    cajero.consultarSaldo();
                    break;
                case 2:
                    System.out.print("Monto a retirar: ");
                    double retiro = scanner.nextDouble();
                    cajero.retirar(retiro);
                    break;
                case 3:
                    System.out.print("Monto a depositar: ");
                    double deposito = scanner.nextDouble();
                    cajero.depositar(deposito);
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } while (opcion != 4);

        scanner.close();
    }
}
