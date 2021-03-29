
import javax.swing.*;
import java.awt.Color;

import java.awt.event.*;

public class Vista extends JFrame implements ActionListener{

    JButton buscar;
    JTextField CampoRuta;
    JLabel Imagen;

    File archivo;

    public Vista(){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        buscar = new JButton("Buscar");
        buscar.setBounds(10,10,100,25);
        buscar.addActionListener(this);
        add(buscar);

        CampoRuta = new JTextField("");
        CampoRuta.setBounds(120,10,350,25);
        CampoRuta.setBackground(Color.white);
        CampoRuta.setForeground(Color.black);
        add(CampoRuta);


        Imagen = new JLabel();
        Imagen.setBounds(10,45,300,300);
        add(Imagen);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == buscar){
            int resultado;

            BuscaImg Buscador = new BuscaImg();
            Buscador.setBounds(0,0,520,520);
            Buscador.setLocationRelativeTo(null);

            this.setVisible(false);
            Buscador.setVisible(true);

            FileNameExtensionFilter formato = new FileNameExtensionFilter("JPG, PNG , GIF y JFIF","jpg","png","gif","jfif");

            Buscador.busca.setFileFilter(formato);

            resultado = Buscador.busca.showOpenDialog(null);

            if(JFileChooser.APPROVE_OPCION == resultado){
                Buscador.setVisible(false);
                this.setVisible(true);
                archivo = Buscador.busca.getSelectedFile();

                CampoRuta.setText(archivo.getAbsolutePath());

                try {
                    ImageIcon imgIcon = new ImageIcon(archivo.toString());
                    Icon icono = new ImageIcon(imgIcon.getImage().getScaledInstance(imagen.getWidth(),imagen.getHeight(),Image.SCALE_DEFAULT));

                    imagen.setIcon(icono);

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,"Error al Abrir: " + e);
                }

            }
        }
    }

    
}
