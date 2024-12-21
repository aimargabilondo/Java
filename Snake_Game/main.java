import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class SnakeGame extends JPanel implements ActionListener {

    private final int ANCHO = 800, ALTO = 600;
    private final int TAMANO_CELDA = 25;
    private final int TOTAL_CELDAS = 900;

    private final int x[] = new int[TOTAL_CELDAS];
    private final int y[] = new int[TOTAL_CELDAS];
    private int longitud;

    private int comidaX, comidaY;
    private boolean direccionArriba = false, direccionAbajo = false, direccionIzquierda = false, direccionDerecha = true;

    private boolean enJuego = true;

    private Timer timer;
    private int delay = 100;

    public SnakeGame() {
        this.setPreferredSize(new Dimension(ANCHO, ALTO));
        this.setBackground(Color.black);
        this.setFocusable(true);

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_UP && !direccionAbajo) {
                    direccionArriba = true;
                    direccionIzquierda = false;
                    direccionDerecha = false;
                }
                if (key == KeyEvent.VK_DOWN && !direccionArriba) {
                    direccionAbajo = true;
                    direccionIzquierda = false;
                    direccionDerecha = false;
                }
                if (key == KeyEvent.VK_LEFT && !direccionDerecha) {
                    direccionIzquierda = true;
                    direccionArriba = false;
                    direccionAbajo = false;
                }
                if (key == KeyEvent.VK_RIGHT && !direccionIzquierda) {
                    direccionDerecha = true;
                    direccionArriba = false;
                    direccionAbajo = false;
                }
            }
        });

        iniciarJuego();
    }

    private void iniciarJuego() {
        longitud = 3;
        x[0] = 100;
        y[0] = 100;
        for (int i = 1; i < longitud; i++) {
            x[i] = x[i - 1] - TAMANO_CELDA;
            y[i] = y[i - 1];
        }
        generarComida();

        timer = new Timer(delay, this);
        timer.start();
    }

    private void generarComida() {
        comidaX = (int) (Math.random() * 32) * TAMANO_CELDA;
        comidaY = (int) (Math.random() * 24) * TAMANO_CELDA;
    }

    private void mover() {
        for (int i = longitud - 1; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }

        if (direccionArriba) {
            y[0] -= TAMANO_CELDA;
        }

        if (direccionAbajo) {
            y[0] += TAMANO_CELDA;
        }

        if (direccionIzquierda) {
            x[0] -= TAMANO_CELDA;
        }

        if (direccionDerecha) {
            x[0] += TAMANO_CELDA;
        }
    }

    private void verificarComida() {
        if (x[0] == comidaX && y[0] == comidaY) {
            longitud++;
            generarComida();
        }
    }

    private void verificarColisiones() {
        for (int i = longitud; i > 0; i--) {
            if (i > 3 && x[0] == x[i] && y[0] == y[i]) {
                enJuego = false;
            }
        }
        if (x[0] < 0 || x[0] >= ANCHO || y[0] < 0 || y[0] >= ALTO) {
            enJuego = false;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (enJuego) {
            mover();
            verificarComida();
            verificarColisiones();
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        dibujar(g);
    }

    private void dibujar(Graphics g) {
        if (enJuego) {
            g.setColor(Color.red);
            g.fillRect(comidaX, comidaY, TAMANO_CELDA, TAMANO_CELDA);

            for (int i = 0; i < longitud; i++) {
                if (i == 0) {
                    g.setColor(Color.green);
                } else {
                    g.setColor(Color.blue);
                }
                g.fillRect(x[i], y[i], TAMANO_CELDA, TAMANO_CELDA);
            }

            Toolkit.getDefaultToolkit().sync();
        } else {
            gameOver(g);
        }
    }

    private void gameOver(Graphics g) {
        String mensaje = "Juego Terminado";
        Font font = new Font("Arial", Font.BOLD, 30);
        FontMetrics metr = getFontMetrics(font);
        g.setColor(Color.white);
        g.setFont(font);
        g.drawString(mensaje, (ANCHO - metr.stringWidth(mensaje)) / 2, ALTO / 2);
    }

    public static void main(String[] args) {
        javax.swing.JFrame ventana = new javax.swing.JFrame("Snake");
        SnakeGame juego = new SnakeGame();
        ventana.add(juego);
        ventana.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        ventana.pack();
        ventana.setVisible(true);
    }
}
