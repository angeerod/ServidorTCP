package Clases;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class JFrameServidor extends JFrame implements ActionListener {
    private JLabel LabelIma;
    private JPanel PanelAzul;
    JTextField huespedField, numeroHabitacionField, habitacionEliminarField;
    private ArrayList<Habitacion> reservas; // Lista para almacenar las reservas

    public static void main(String[] args) {
        // Instancia la clase JFrameServidor
        JFrameServidor frame = new JFrameServidor();
    }

    public JFrameServidor() {
        reservas = new ArrayList<>(); // Inicializa la lista de reservas

        setBounds(0, 0, 800, 500);
        setBackground(new Color(77, 151, 75));
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Fin del JFrame

        // Area para solicitudes
        LabelIma = new JLabel(); // En este Label se inserta la imagen de fondo
        LabelIma.setBounds(75, 45, 30, 30);

        // Creacion del panel principal
        JPanel Panel = new JPanel();
        setContentPane(Panel);
        getContentPane();
        Panel.setLayout(null);
        Panel.setBackground(Color.white);

        // Panel para poner color arriba
        PanelAzul = new JPanel();
        PanelAzul.setBounds(0, 0, 800, 800);
        PanelAzul.setBackground(new Color(46, 54, 144));
        PanelAzul.setLayout(null);
        Panel.add(PanelAzul);

        TextArea text = new TextArea("Solicitudes Del Cliente", 10, 50, TextArea.SCROLLBARS_VERTICAL_ONLY);
        text.setBounds(410, 50, 350, 300);
        text.setEditable(false);
        PanelAzul.add(text);

        // Botones
        JButton reservar = new JButton("Reservar");
        reservar.setForeground(Color.black);
        reservar.setBounds(50, 150, 100, 30);
        reservar.addActionListener(this);
        PanelAzul.add(reservar);

        JButton eliminar = new JButton("Eliminar");
        eliminar.setForeground(Color.BLACK);
        eliminar.setBounds(50, 250, 100, 30);
        eliminar.addActionListener(this);
        PanelAzul.add(eliminar);

        JButton HorarioComida = new JButton("Enviar Horario de Comida");
        HorarioComida.setForeground(Color.BLACK);
        HorarioComida.setBounds(50, 300, 185, 30);
        PanelAzul.add(HorarioComida);

        JButton HorarioLimpieza = new JButton("Enviar Horario de Limpieza");
        HorarioLimpieza.setForeground(Color.BLACK);
        HorarioLimpieza.setBounds(50, 350, 185, 30);
        PanelAzul.add(HorarioLimpieza);

        // TextFields
        huespedField = new JTextField();
        huespedField.setBounds(240, 50, 160, 30);
        PanelAzul.add(huespedField);

        numeroHabitacionField = new JTextField();
        numeroHabitacionField.setBounds(240, 100, 75, 30);
        PanelAzul.add(numeroHabitacionField);

        habitacionEliminarField = new JTextField();
        habitacionEliminarField.setBounds(230, 200, 160, 30);
        PanelAzul.add(habitacionEliminarField);

        // Labels
        JLabel huespedEiminarJLabel = new JLabel("Nombre de huésped a eliminar:");
        huespedEiminarJLabel.setBounds(50, 200, 200, 30);
        huespedEiminarJLabel.setForeground(Color.white);
        PanelAzul.add(huespedEiminarJLabel);

        JLabel huespedAgregarJLabel = new JLabel("Nombre de huésped que reserva:");
        huespedAgregarJLabel.setBounds(50, 50, 200, 30);
        huespedAgregarJLabel.setForeground(Color.white);
        PanelAzul.add(huespedAgregarJLabel);

        JLabel habitacionAgregarJLabel = new JLabel("Número de habitación a reservar:");
        habitacionAgregarJLabel.setBounds(50, 100, 200, 30);
        habitacionAgregarJLabel.setForeground(Color.white);
        PanelAzul.add(habitacionAgregarJLabel);

        PanelAzul.add(LabelIma);
        setVisible(true);
    } // Fin del constructor

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Reservar")) {
            String huesped = huespedField.getText();
            String numeroHabitacion = numeroHabitacionField.getText();
            if (!huesped.isEmpty() && !numeroHabitacion.isEmpty()) {
                reservas.add(new Habitacion(numeroHabitacion, huesped));
                JOptionPane.showMessageDialog(this,
                        "Reservación hecha de " + huesped + " en habitación número " + numeroHabitacion + "\n");
                huespedField.setText("");
                numeroHabitacionField.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos para reservar.");
            }
        } else if (e.getActionCommand().equals("Eliminar")) {
            String huespedEliminar = habitacionEliminarField.getText();
            if (!huespedEliminar.isEmpty()) {
                boolean found = false;
                for (Habitacion habitacion : reservas) {
                    if (habitacion.getHuesped().equals(huespedEliminar)) {
                        reservas.remove(habitacion);
                        JOptionPane.showMessageDialog(this, "Reservación eliminada de " + huespedEliminar);
                        habitacionEliminarField.setText("");
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    JOptionPane.showMessageDialog(this, "No se encontró ninguna reservación para " + huespedEliminar);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, complete el campo para eliminar.");
            }
        }
    } // Fin de actionPerformed
}