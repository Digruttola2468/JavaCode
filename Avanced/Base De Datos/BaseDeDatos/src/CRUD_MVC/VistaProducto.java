package CRUD_MVC;


import javax.swing.*;

public class VistaProducto extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private JLabel jlCodigo,jlNombre,jlPrecio,jlCantidad;
	public JTextField txtCodigo,txtNombre,txtPrecio,txtCantidad,txtID;
	JButton btGuardar,btModificar,btEliminar,btLimpiar,btBuscar;
	
	public VistaProducto() {
		
		setLayout(null);
		setTitle("CRUD with MVC");
		setSize(500,300);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		jlCodigo = new JLabel("Codigo: ");
		jlCodigo.setBounds(10,10,70,20);
		add(jlCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(70,10,100,20);
		add(txtCodigo);
		
		jlNombre = new JLabel("Nombre: ");
		jlNombre.setBounds(10,50,70,20);
		add(jlNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(70,50,100,20);
		add(txtNombre);
		
		jlPrecio = new JLabel("Precio: ");
		jlPrecio.setBounds(10,95,70,20);
		add(jlPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(70,95,100,20);
		add(txtPrecio);
		
		jlCantidad = new JLabel("Cantidad: ");
		jlCantidad.setBounds(10,130,70,20);
		add(jlCantidad);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(70,130,100,20);
		add(txtCantidad);
		
		btGuardar = new JButton("Guardar");
		btGuardar.setBounds(10,170,100,20);
		add(btGuardar);
		
		btModificar = new JButton("Modificar");
		btModificar.setBounds(120,170,100,20);
		add(btModificar);
		
		btEliminar = new JButton("Eliminar");
		btEliminar.setBounds(230,170,100,20);
		add(btEliminar);
		
		btLimpiar = new JButton("Limpiar");
		btLimpiar.setBounds(340,170,100,20);
		add(btLimpiar);
		
		btBuscar = new JButton("Buscar");
		btBuscar.setBounds(190,10,100,20);
		add(btBuscar);
		
		txtID = new JTextField();
		txtID.setBounds(190,50,50,20);
		txtID.setEditable(false);
		add(txtID);
	}
	
	
	
	
}
