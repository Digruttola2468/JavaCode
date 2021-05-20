package CRUD_MVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class ControlProducto implements ActionListener{

	private ProductoModelo produto;
	private ConsultasProductoModelo consulta;
	private VistaProducto vista;
	
	public ControlProducto(ProductoModelo producto,ConsultasProductoModelo consulta, VistaProducto vista) {
		
		this.produto = producto;
		this.consulta = consulta;
		this.vista = vista;
		
		vista.btBuscar.addActionListener(this);
		vista.btEliminar.addActionListener(this);
		vista.btGuardar.addActionListener(this);
		vista.btLimpiar.addActionListener(this);
		vista.btModificar.addActionListener(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == vista.btGuardar) {
			produto.setCodigo(vista.txtCodigo.getText());
			produto.setNombre(vista.txtNombre.getText());
			produto.setPrecio(Double.parseDouble(vista.txtPrecio.getText()));
			produto.setCantidad(Integer.parseInt(vista.txtCantidad.getText()));
			
			if(consulta.Registrar(produto)) {
				JOptionPane.showMessageDialog(null, "Registro Guardado");
				Limpiar();
			}else
				JOptionPane.showMessageDialog(null, "Error al Guardar");
			
		}
		
		if(e.getSource() == vista.btModificar) {
			produto.setID(Integer.parseInt(vista.txtID.getText()));
			produto.setCodigo(vista.txtCodigo.getText());
			produto.setNombre(vista.txtNombre.getText());
			produto.setPrecio(Double.parseDouble(vista.txtPrecio.getText()));
			produto.setCantidad(Integer.parseInt(vista.txtCantidad.getText()));
			
			if(consulta.Modificar(produto)) {
				JOptionPane.showMessageDialog(null, "Modificado");
				Limpiar();
			}else
				JOptionPane.showMessageDialog(null, "Error al Modificar");
		}
		
		if(e.getSource() == vista.btEliminar) {
			produto.setID(Integer.parseInt(vista.txtID.getText()));
			
			if(consulta.Eliminar(produto)) {
				JOptionPane.showMessageDialog(null, "Eliminar");
				Limpiar();
			}else
				JOptionPane.showMessageDialog(null, "Error al Eliminar");
		}
		
		if(e.getSource() == vista.btLimpiar) {
			Limpiar();
		}
		
		if(e.getSource() == vista.btBuscar) {
			produto.setCodigo(vista.txtCodigo.getText());
			
			if(consulta.Buscar(produto)) {
				
				vista.txtID.setText(String.valueOf(produto.getId()));
				vista.txtCodigo.setText(produto.getCodigo());
				vista.txtPrecio.setText(String.valueOf(produto.getPrecio()));
				vista.txtCantidad.setText(String.valueOf(produto.getCantidad()));
				vista.txtNombre.setText(produto.getNombre());
				
			}else
				JOptionPane.showMessageDialog(null, "Error al Buscar");
		}
		
		
		
	}
	
	public void Limpiar() {
		vista.txtCantidad.setText("");
		vista.txtCodigo.setText("");
		vista.txtID.setText("");
		vista.txtNombre.setText("");
		vista.txtPrecio.setText("");
	}
	
	
	
}
