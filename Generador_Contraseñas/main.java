import java.security.SecureRandom;

public class GeneradorContraseñas {

    public static String generarContraseña(int longitud, boolean incluirEspeciales) {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        String especiales = "!@#$%^&*()-_=+[]{}|;:,.<>?";
        if (incluirEspeciales) {
            caracteres += especiales;
        }

        SecureRandom random = new SecureRandom();
        StringBuilder contraseña = new StringBuilder();

        for (int i = 0; i < longitud; i++) {
            int index = random.nextInt(caracteres.length());
            contraseña.append(caracteres.charAt(index));
        }

        return contraseña.toString();
    }

    public static void main(String[] args) {
        int longitud = 12;
        boolean incluirEspeciales = true;
        System.out.println("Contraseña generada: " + generarContraseña(longitud, incluirEspeciales));
    }
}
