package CRUD_MVC;

public class ProductoModelo {
	
	private int ID;
	private String codigo,Nombre;
	private double precio;
	private int cantidad;
	
	//setter
	public void setID(int id) {
		this.ID = id;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public void setNombre(String Nombre) {
		this.Nombre = Nombre;
	}
	public void setPrecio(double Precio) {
		this.precio = Precio;
	}
	public void setCantidad(int Cantidad) {
		this.cantidad = Cantidad;
	}
	
	
	//Getter
	public int getId() {
		return this.ID;
	}
	public String getCodigo() {
		return this.codigo;
	}
	public String getNombre() {
		return this.Nombre;
	}
	public double getPrecio() {
		return this.precio;
	}
	public int getCantidad() {
		return this.cantidad;
	}
}
