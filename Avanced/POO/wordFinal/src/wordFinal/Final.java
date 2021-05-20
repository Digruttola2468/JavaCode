package wordFinal;

public class Final {
	public static void main(String[] args) {
		
		Empleados empleado1 = new Empleados("Ivan");
		Empleados empleado2 = new Empleados("Brisa");
		
		System.out.println(empleado1.mostrarSeccion());
		System.out.println(empleado2.mostrarSeccion() + "\n");
		
		empleado1.cambiaSeccion("RRHH");
		
		System.out.println(empleado1.mostrarSeccion());
		System.out.println(empleado2.mostrarSeccion());
		
	}
}

class Empleados{
	
	private final String nombre;
	private String seccion;
	
	public Empleados(String nom){
		this.nombre = nom;
		this.seccion = "Administracion";
	}
	
	//Getter y Setter
	public void cambiaSeccion(String seccion) { //Setter
		this.seccion = seccion;
	}
	public String mostrarSeccion() {			//Getter
		return "El nombre es: " + nombre + " y la seccion es " + seccion;
	}
	
}
