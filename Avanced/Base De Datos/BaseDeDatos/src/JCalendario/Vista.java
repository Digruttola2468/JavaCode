package JCalendario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class Vista extends JFrame implements ActionListener{
	
	JDateChooser jdcFecha;
	JButton btaceptar,btPasar;
	JTextField txtCampo;
	
	public Vista() {
		
		setLayout(null);
		setTitle("JCalendar");
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(3);
		setSize(300,300);
		
		jdcFecha = new JDateChooser();
		jdcFecha.setBounds(10,10,100,30);
		jdcFecha.setDateFormatString("dd/MM/yyyy");
		add(jdcFecha);
		
		btaceptar = new JButton("Aceptar");
		btaceptar.setBounds(10, 50, 90, 20);
		btaceptar.addActionListener(this);
		add(btaceptar);
		
		txtCampo = new JTextField();
		txtCampo.setBounds(150,10,100,20);
		add(txtCampo);
		
		btPasar = new JButton("Pasar");
		btPasar.setBounds(150,50,100,20);
		btPasar.addActionListener(this);
		add(btPasar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btaceptar) {
			
			//Obtenemos la fecha del jdcFecha
			Date date = jdcFecha.getDate();
			
			//Convercion para que MySQL lo pueda Leer
			long d = date.getTime();
			java.sql.Date fecha = new java.sql.Date(d);
			
			
			
			//Mostramos
			JOptionPane.showMessageDialog(null, fecha);
		}
		
		if(e.getSource() == btPasar) {
			
			SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
			Date fechaTxt;
			
			try {
				fechaTxt = formatoFecha.parse(txtCampo.getText());
				jdcFecha.setDate(fechaTxt);
				
			} catch (ParseException e1) {
				System.err.println(e1);
				JOptionPane.showMessageDialog(null, e1);
				e1.printStackTrace();
			}
			
		}
		
		
	}
	
	
	
}
