package Correos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class VistaCorreo extends JFrame implements ActionListener{
	
	JLabel jlCorreo;
	JTextField txtCorreo;
	JButton jbEnviar;
	
	public VistaCorreo() {
		
		setLayout(null);
		setTitle("CorreoElectronico");
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(3);
		setSize(400,100);
		
		jlCorreo = new JLabel("Correo:");
		jlCorreo.setBounds(10,20,50,20);
		add(jlCorreo);
		
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(60,20,200,20);
		add(txtCorreo);
		
		
		jbEnviar = new JButton("Enviar");
		jbEnviar.setBounds(280,20,100,20);
		jbEnviar.addActionListener(this);
		add(jbEnviar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == jbEnviar) {
			try {
				//Propiedades
				Properties props = new Properties();
				//Configuramos las Propiedades
				props.setProperty("mail.smtp.host", "smtp.gmail.com");
	            props.setProperty("mail.smtp.starttls.enable", "true");
	            props.setProperty("mail.smtp.port", "587");
	            props.setProperty("mail.smtp.auth", "true");
			
				//Session obtiene las propiedades que configuramos
				Session session = Session.getDefaultInstance(props);
				//Colocamos el mensaje con el DefaultInstance de Properties
				MimeMessage message = new MimeMessage(session);
				
				//Colocamos los datos
				String correoRemitente = "ivansandigruttola@gmail.com";	//Mi correo
				String paswordRemitente = "digruttola333";							//Mi contraseña
				String correoReceptor = txtCorreo.getText();			//El gmail que le vamos a enviar
				String asunto = "Mi primer correo en Java";				//Asunto de mi envie
				String mensaje = "Este es el contenido de mi primer correo\nSalto de linea pa";	//Mensaje
			
			
			
				//Propietaro del mensaje
				message.setFrom(new InternetAddress(correoRemitente));
				
				//Se lo mandamos a tal correo
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(correoReceptor));
				
				message.setSubject(asunto);
				message.setText(mensaje);
				
				Transport t = session.getTransport("smtp");
				t.connect("smtp.gmail.com",correoRemitente,paswordRemitente);
				t.sendMessage(message , message.getAllRecipients());
				t.close();
				
				JOptionPane.showMessageDialog(null, "Se ha enviado el Correo");
				
			} catch (AddressException e1) {
				JOptionPane.showMessageDialog(null, "Error al enviar: " + e1);
				e1.printStackTrace();
			} catch (MessagingException e1) {
				JOptionPane.showMessageDialog(null, "Error al enviar: " + e1);
				e1.printStackTrace();
			}
			
		}
	}
	
	private static void enviarConGMail(String destinatario, String asunto, String cuerpo) {
	    // Esto es lo que va delante de @gmail.com en tu cuenta de correo. Es el remitente también.
	    String remitenteString = "nomcuenta";  //Para la dirección nomcuenta@gmail.com

	    Properties props = System.getProperties();
	    props.put("mail.smtp.host", "smtp.gmail.com");  //El servidor SMTP de Google
	    props.put("mail.smtp.user", remitenteString);
	    props.put("mail.smtp.clave", "miClaveDeGMail");    //La clave de la cuenta
	    props.put("mail.smtp.auth", "true");    //Usar autenticación mediante usuario y clave
	    props.put("mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
	    props.put("mail.smtp.port", "587"); //El puerto SMTP seguro de Google

	    Session session = Session.getDefaultInstance(props);
	    MimeMessage message = new MimeMessage(session);

	    try {
	        message.setFrom(new InternetAddress(remitenteString));
	        message.addRecipients(Message.RecipientType.TO, destinatario);   //Se podrían añadir varios de la misma manera
	        message.setSubject(asunto);
	        message.setText(cuerpo);
	        Transport transport = session.getTransport("smtp");
	        transport.connect("smtp.gmail.com", remitenteString, "");
	        transport.sendMessage(message, message.getAllRecipients());
	        transport.close();
	    }
	    catch (MessagingException me) {
	        me.printStackTrace();   //Si se produce un error
	    }
	}
	
}
