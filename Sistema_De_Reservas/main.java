import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SistemaReservas {
    private JFrame frame;
    private JTextField nombreField, fechaField;
    private JButton reservarButton;

    public SistemaReservas() {
        frame = new JFrame("Sistema de Reservas");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JLabel nombreLabel = new JLabel("Nombre:");
        nombreField = new JTextField(20);
        JLabel fechaLabel = new JLabel("Fecha de reserva:");
        fechaField = new JTextField(20);
        reservarButton = new JButton("Reservar");

        reservarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Reserva realizada para " + nombreField.getText() +
                        " en la fecha " + fechaField.getText());
            }
        });

        frame.add(nombreLabel);
        frame.add(nombreField);
        frame.add(fechaLabel);
        frame.add(fechaField);
        frame.add(reservarButton);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new SistemaReservas();
    }
}
