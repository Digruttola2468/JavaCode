package JTablas;

import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.swing.*;

public class Vista extends JFrame implements ActionListener{
	
	String[] columsTienda = {"Codigo" , "Producto" , "Precio" , "Cantidad"};
	String[][] datos = { {"1","Coca","12","2"} , {"2","Pepci","10","3"}};
	
	JButton btCargar, btGuardar , btModificar , btEliminar;
	JLabel jlCodigo , jlNombre, jlPrecio,jlCantidad;
	JTextField txtCodigo , txtNombre, txtPrecio , txtCantidad;
	
	JTable tabla;
	
	DefaultTableModel modelo;
	
	public Vista() {
		
		setLayout(null);
		setTitle("MySQL with JTable");
		setLocationRelativeTo(null);
		setResizable(false);
		setSize(600,400);
		setDefaultCloseOperation(3);

		tabla = new JTable(datos,columsTienda);
		tabla.setBounds(10,50,300,300);
		
		btCargar = new JButton("Cargar");
		btCargar.setBounds(180,10,100,20);
		btCargar.addActionListener(this);
		add(btCargar);
		
		jlCodigo = new JLabel("Codigo: ");
		jlCodigo.setBounds(10,10,50,20);
		add(jlCodigo);

		txtCodigo = new JTextField("");
		txtCodigo.setBounds(60,10,100,20);
		add(txtCodigo);
		
		jlNombre = new JLabel("  Nombre: ");
		jlNombre.setBounds(340,50,80,20);
		add(jlNombre);
		
		txtNombre = new JTextField("");
		txtNombre.setBounds(420,50,100,20);
		add(txtNombre);
		
		jlPrecio = new JLabel("    Precio: ");
		jlPrecio.setBounds(340,80,80,20);
		add(jlPrecio);
		
		txtPrecio = new JTextField("");
		txtPrecio.setBounds(420,80,100,20);
		add(txtPrecio);
		
		jlCantidad = new JLabel("Cantidad: ");
		jlCantidad.setBounds(340,110,80,20);
		add(jlCantidad);
		
		txtCantidad = new JTextField("");
		txtCantidad.setBounds(420,110,100,20);
		add(txtCantidad);
		
		btGuardar = new JButton("Guardar");
		btGuardar.setBounds(340,150,100,20);
		btGuardar.addActionListener(this);
		add(btGuardar);
		
		btModificar = new JButton("Modificar");
		btModificar.setBounds(470,150,100,20);
		btModificar.addActionListener(this);
		add(btModificar);
		
		btEliminar = new JButton("Eliminar");
		btEliminar.setBounds(340,190,100,20);
		btEliminar.addActionListener(this);
		add(btEliminar);
		
		CargarTabla();
		
		mouseClicked();
		
		add(tabla);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(btCargar == e.getSource()) 
			CargarTabla();
		
		if( btGuardar == e.getSource() ) {
			
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			try {
				
				Connection con = new ConexionModelo().getConexion();
				
				ps = con.prepareStatement("INSERT INTO producto (codigo,nombre,precio,cantidad) VALUES (?,?,?,?)");
				
				ps.setString(1, txtCodigo.getText());
				ps.setString(2, txtNombre.getText());
				ps.setString(3, txtPrecio.getText());
				ps.setString(4, txtCantidad.getText());
				
				ps.execute();
				
				JOptionPane.showMessageDialog(null, "Producto Guardado");
				
				Object[] fila = new Object[4];
				fila[0] = txtCodigo.getText();
				fila[1] = txtNombre.getText();
				fila[2] = txtPrecio.getText();
				fila[3] = txtCantidad.getText();
				
				modelo.addRow(fila);
				
				} catch (Exception e2) {
				// TODO: handle exception
			}
			
		}
		
		if(btModificar == e.getSource()) {
			
			PreparedStatement ps = null;
			
			Connection con = new ConexionModelo().getConexion();
			
			try {
			
				ps = con.prepareStatement("UPDATE producto SET nombre=?, precio=?, cantidad=? WHERE codigo=?");
			
				ps.setString(4, txtCodigo.getText());
				ps.setString(1, txtNombre.getText());
				ps.setString(2, txtPrecio.getText());
				ps.setString(3, txtCantidad.getText());
				
				int res = ps.executeUpdate();
				
				if(res > 0) 
					JOptionPane.showMessageDialog(null, "Producto Modificado");
				else
					JOptionPane.showMessageDialog(null, "Error al Modificar Producto");
				
				
				con.close();
			}catch(Exception e3) {
				System.err.println(e3);
			}
		}
		
		if(btEliminar == e.getSource()) {
			PreparedStatement ps = null;
			
			try {
				
				Connection con = new ConexionModelo().getConexion();
				
				int Fila = tabla.getSelectedRow();
				String codigo = tabla.getValueAt(Fila, 0).toString();
				
				ps = con.prepareStatement("DELETE FROM producto WHERE codigo=?");
				ps.setString(1, codigo);
				ps.execute();
				
				modelo.removeRow(Fila);
				
			} catch (Exception e2) {
				System.err.println(e2);
			}
			
		}
		
	}
	
	private void mouseClicked() {
		tabla.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				

				PreparedStatement ps = null;
				ResultSet rs = null;
				
				try {
					
					ConexionModelo objcon = new ConexionModelo();
					Connection conn = objcon.getConexion();
					
					int Fila = tabla.getSelectedRow();
					String codigo = tabla.getValueAt(Fila, 0).toString();
					
					ps = conn.prepareStatement("SELECT codigo,nombre,precio,cantidad FROM producto WHERE codigo=?");
					ps.setString(1, codigo);
					rs = ps.executeQuery();
					
					while ( rs.next() ) {
						txtCodigo.setText(rs.getString("codigo"));
						txtNombre.setText(rs.getString("nombre"));
						txtPrecio.setText(rs.getString("precio"));
						txtCantidad.setText(rs.getString("cantidad"));
					}
					
					
				} catch (Exception e2) {
					System.err.println(e2);
				}
			}
		}
			
		);
	}
	
	private void CargarTabla() {
		String campo = txtCodigo.getText();
		String where = "";
		
		if( !"".equals(campo) ) {
			where = " WHERE codigo = '" + campo + "'";
		}
		
		try {
			
			modelo = new DefaultTableModel();
			tabla.setModel(modelo);
			
			PreparedStatement ps = null;
			ResultSet rs = null;
			Connection con = new ConexionModelo().getConexion();
			
			String sql = "SELECT codigo,nombre,precio,cantidad FROM producto" + where;
			
			System.out.println("SQL: " + sql);
			
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			//Pasandole el resultado de la consulta
			ResultSetMetaData rsMD = rs.getMetaData();
			
			int cantidadColumnas = rsMD.getColumnCount();
			
			modelo.addColumn("Codigo");
			modelo.addColumn("Nombre");
			modelo.addColumn("Precio");
			modelo.addColumn("Cantidad");
			
			while(rs.next()) {
				
				Object[] filas = new Object[cantidadColumnas];
				
				//Pasamos todos los datos a este tipo Object
				for(int i=0 ; i<cantidadColumnas ; i++) {
					filas[i] = rs.getObject(i+1);
				}
				
				//Agregamos al modelo
				modelo.addRow(filas);
			}
			
		} catch (Exception e2) {
			System.err.println(e2);
		}
	}
	
}

