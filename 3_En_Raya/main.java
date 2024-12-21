import java.util.Scanner;

public class TresEnRaya {

    private static char[][] tablero = new char[3][3];
    private static char jugadorActual = 'X';

    public static void inicializarTablero() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = ' ';
            }
        }
    }

    public static void imprimirTablero() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(tablero[i][j]);
                if (j < 2) System.out.print(" | ");
            }
            System.out.println();
            if (i < 2) System.out.println("---------");
        }
    }

    public static boolean hacerMovimiento(int fila, int col) {
        if (tablero[fila][col] == ' ') {
            tablero[fila][col] = jugadorActual;
            return true;
        }
        return false;
    }

    public static boolean verificarGanador() {
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] == jugadorActual && tablero[i][1] == jugadorActual && tablero[i][2] == jugadorActual)
                return true;
            if (tablero[0][i] == jugadorActual && tablero[1][i] == jugadorActual && tablero[2][i] == jugadorActual)
                return true;
        }
        if (tablero[0][0] == jugadorActual && tablero[1][1] == jugadorActual && tablero[2][2] == jugadorActual)
            return true;
        if (tablero[0][2] == jugadorActual && tablero[1][1] == jugadorActual && tablero[2][0] == jugadorActual)
            return true;

        return false;
    }

    public static void cambiarJugador() {
        jugadorActual = (jugadorActual == 'X') ? 'O' : 'X';
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        inicializarTablero();

        while (true) {
            imprimirTablero();
            System.out.println("Jugador " + jugadorActual + ", ingresa tu movimiento (fila y columna): ");
            int fila = scanner.nextInt();
            int col = scanner.nextInt();

            if (hacerMovimiento(fila, col)) {
                if (verificarGanador()) {
                    imprimirTablero();
                    System.out.println("¡El jugador " + jugadorActual + " ha ganado!");
                    break;
                }
                cambiarJugador();
            } else {
                System.out.println("Movimiento no válido, intenta de nuevo.");
            }
        }
        scanner.close();
    }
}
