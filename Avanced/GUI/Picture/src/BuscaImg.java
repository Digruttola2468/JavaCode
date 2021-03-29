import javax.swing.*;

public class BuscaImg extends JFrame{

    public static JFileChooser busca;

    public BuscaImg(){
        setLayout(null);
        setDefaultCloseOperation(3);

        busca = new JFileChooser("C:/Users/ivans/Pictures");
        busca.setBounds(5,5,500,500);;
        add(busca);
    }
}
