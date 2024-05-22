    import java.awt.*;
    import javax.swing.JButton;
    import javax.swing.JFrame;
    import javax.swing.JLabel;
    import javax.swing.JPanel;
    
    
    public class JFrameServidor extends JFrame {
        private JLabel LabelIma;
        private JPanel PanelAzul;
            
    public static void main(String[] args) {
        // Instancia la clase JFrameServidor
        JFrameServidor frame = new JFrameServidor();
    }
    
        public JFrameServidor() {
            setBounds(0, 0, 800, 500);
            setBackground(new Color(77, 151, 75));
            setLayout(null);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            // Fin del JFrame
    
            //Area para solicitudes
            TextArea Text;
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
            text.setBounds(300, 50, 400, 300);
            text.setEditable(false);
            PanelAzul.add(text);
    
            //Botones
            JButton Reservar = new JButton("Reservar"); 
            Reservar.setForeground(Color.black);
            Reservar.setBounds(50, 50, 100, 30);
    
            PanelAzul.add(Reservar);
    
            JButton Eliminar = new JButton("Eliminar"); 
            Eliminar.setForeground(Color.BLACK);
            Eliminar.setBounds(50, 100, 100, 30);
    
            PanelAzul.add(Eliminar);
    
            JButton HorarioComida = new JButton("Enviar Horario de Comida");
            HorarioComida.setForeground(Color.BLACK);
            HorarioComida.setBounds(50, 150, 185, 30);
            PanelAzul.add(HorarioComida);
    
            JButton HorarioLimpieza = new JButton("Enviar Horario de Limpieza");
            HorarioLimpieza.setForeground(Color.BLACK);
            HorarioLimpieza.setBounds(50, 200, 185, 30); // Adjusted bounds to prevent overlap
            PanelAzul.add(HorarioLimpieza);
    
            PanelAzul.add(LabelIma); // Add the label once to the panel
            setVisible(true);
        } // Fin del constructor
    
    } // Fin de la clase

