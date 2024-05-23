package Clases;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.*;
import java.util.ArrayList;

public class JFrameServidor extends JFrame implements ActionListener {
    private JLabel LabelIma;
    private JPanel PanelAzul;
    JTextField huespedField, numeroHabitacionField, habitacionEliminarField, nombreBuscarHuespedField;
    JComboBox<String> tipoHabitacionComboBox;
    private ArrayList<Habitacion> reservas; // Lista para almacenar las reservas

    public static void main(String[] args) {
        // Instancia la clase JFrameServidor
        JFrameServidor frame = new JFrameServidor();
    }

    public JFrameServidor() {
        reservas = new ArrayList<>(); // Inicializa la lista de reservas

        setBounds(0, 0, 800, 600);
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
        PanelAzul.setBounds(0, 0, 800, 600);
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
        reservar.setBounds(50, 200, 100, 30);
        reservar.addActionListener(this);
        PanelAzul.add(reservar);

        JButton eliminar = new JButton("Eliminar");
        eliminar.setForeground(Color.BLACK);
        eliminar.setBounds(50, 300, 100, 30);
        eliminar.addActionListener(this);
        PanelAzul.add(eliminar);

        JButton HabitacionBuscar = new JButton("Consultar habitacion por nombre de huésped");
        HabitacionBuscar.setForeground(Color.BLACK);
        HabitacionBuscar.setBounds(50, 400, 300, 30);
        HabitacionBuscar.addActionListener(this);
        PanelAzul.add(HabitacionBuscar);

        JButton HorarioLimpieza = new JButton("Enviar Horario de Limpieza");
        HorarioLimpieza.setForeground(Color.BLACK);
        HorarioLimpieza.setBounds(50, 450, 185, 30);
        PanelAzul.add(HorarioLimpieza);

        //ComboBox para tipo de habitacion
        String[] tiposHabitacion = {"Individual", "Doble", "Suite"};
        tipoHabitacionComboBox = new JComboBox<>(tiposHabitacion);
        tipoHabitacionComboBox.setBounds(240, 150, 160, 30);
        PanelAzul.add(tipoHabitacionComboBox);

        // TextFields
        huespedField = new JTextField();
        huespedField.setBounds(240, 50, 160, 30);
        PanelAzul.add(huespedField);

        numeroHabitacionField = new JTextField();
        numeroHabitacionField.setBounds(240, 100, 75, 30);
        PanelAzul.add(numeroHabitacionField);

        habitacionEliminarField = new JTextField();
        habitacionEliminarField.setBounds(230, 250, 160, 30);
        PanelAzul.add(habitacionEliminarField);

        nombreBuscarHuespedField = new JTextField();
        nombreBuscarHuespedField.setBounds(230, 350, 160, 30);
        PanelAzul.add(nombreBuscarHuespedField);

        // Labels
        JLabel huespedEiminarJLabel = new JLabel("Nombre de huésped a eliminar:");
        huespedEiminarJLabel.setBounds(50, 250, 200, 30);
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

        JLabel tipoHabitacionAgregarJLabel = new JLabel("Tipo de habitación a reservar:");
        tipoHabitacionAgregarJLabel.setBounds(50, 150, 200, 30);
        tipoHabitacionAgregarJLabel.setForeground(Color.white);
        PanelAzul.add(tipoHabitacionAgregarJLabel);

        JLabel huespedBuscarHabitacionJLabel = new JLabel("Nombre de huésped a buscar:");
        huespedBuscarHabitacionJLabel.setBounds(50, 350, 200, 30);
        huespedBuscarHabitacionJLabel.setForeground(Color.white);
        PanelAzul.add(huespedBuscarHabitacionJLabel);

        PanelAzul.add(LabelIma);
        setVisible(true);
    } // Fin del constructor

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Reservar")) {
            String huesped = huespedField.getText();
            String numeroHabitacion = numeroHabitacionField.getText();
            String tipoHabitacion = (String) tipoHabitacionComboBox.getSelectedItem();
            if (!huesped.isEmpty() && !numeroHabitacion.isEmpty()  && tipoHabitacion != null && !tipoHabitacion.isEmpty() ){
                reservas.add(new Habitacion(numeroHabitacion, huesped, tipoHabitacion));
                JOptionPane.showMessageDialog(this,
                        "Reservación hecha de " + huesped + " en habitación número " + numeroHabitacion + " de tipo " + tipoHabitacion + "\n");
                huespedField.setText("");
                numeroHabitacionField.setText("");
                tipoHabitacionComboBox.setSelectedIndex(0);
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
                        habitacionEliminarField.setText("");
                        break;
                    }
                }
                if (!found) {
                    JOptionPane.showMessageDialog(this, "No se encontró ninguna reservación para " + huespedEliminar);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, complete el campo para eliminar.");
            }
        } else if (e.getActionCommand().equals("Consultar habitacion por nombre de huésped")) {
            String huespedBuscar = nombreBuscarHuespedField.getText();
            if (!huespedBuscar.isEmpty()) {
                boolean found = false;
                for (Habitacion habitacion : reservas) {
                    if (habitacion.getHuesped().equals(huespedBuscar)) {
                        JOptionPane.showMessageDialog(this, 
                            "Reservación encontrada:\n" +
                            "Huésped: " + habitacion.getHuesped() + "\n" +
                            "Número de habitación: " + habitacion.getNumeroHabitacion() + "\n" +
                            "Tipo de habitación: " + habitacion.gettipoHabitacion());
                        found = true;
                        nombreBuscarHuespedField.setText("");
                        break;
                    }
                }
                if (!found) {
                    JOptionPane.showMessageDialog(this, "No se encontró ninguna reservación para " + huespedBuscar);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, complete el campo para buscar.");
            }
        }
    } // Fin de actionPerformed
}