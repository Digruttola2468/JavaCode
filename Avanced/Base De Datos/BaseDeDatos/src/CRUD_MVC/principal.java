package CRUD_MVC;

public class principal {
	
	public static void main(String[] args) {
		
		ProductoModelo producto = new ProductoModelo();
		ConsultasProductoModelo consulta = new ConsultasProductoModelo();
		VistaProducto vista = new VistaProducto();
		new ControlProducto(producto, consulta, vista);
		
		vista.setVisible(true);
	}
	
}
