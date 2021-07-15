package ownClass;

public class UsoPareja {
	
	public static void main(String[] args) {
		
		Pareja<String> una = new Pareja<String>();
		una.setPrimero("Juan");
		System.out.println( una.getPrimero() );
		
		Pareja<Persona> dos = new Pareja<Persona>();
		dos.setPrimero( new Persona("Ana") );
		dos.setPrimero( new Persona("Luis") );
		
		System.out.println( dos.getPrimero().getNombre() );
		
	}
	
}

class Persona{
	private String nombre;
	
	public Persona(String nombre) {
		this.nombre = nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombre() {
		return "Nombre: " + nombre;
	}
	
}
