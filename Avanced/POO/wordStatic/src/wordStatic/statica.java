package wordStatic;

public class statica {
	
	public static void main(String[] args) {
		
		Empleado empleado1 = new Empleado("Ivan");
		Empleado empleado2 = new Empleado("Brisa");
		Empleado empleado3 = new Empleado("Gaston");
		
		System.out.println(empleado1.devolverDatos());
		System.out.println(empleado2.devolverDatos());
		System.out.println(empleado3.devolverDatos());
	}
	
}

class Empleado{
	
	private final String name;
	private String seccion;
	
	private int Id;
	private static int IDsiguiente = 1;
	
	public Empleado(String name) {
		this.name = name;
		this.seccion = "Administrador";
		
		Id = IDsiguiente;
		IDsiguiente++;
		
	}
	
	public String devolverDatos() {
		return "El nombre es: " + name + " y la seccion es " + seccion + " y el id = " + Id;
	}
	
	
	
}
