package Mapas;

import java.util.HashMap;
import java.util.Map;

public class PruebaMapas {
	
	public static void main(String[] args) {
		
		HashMap<String, Empleado> personal = new HashMap<String,Empleado>();
		
		//Agregar
		personal.put( "145" , new Empleado("Ivan") );
		personal.put( "146" , new Empleado("Brisa") );
		personal.put( "147" , new Empleado("Sebastian") );
		
		//Eliminar
		personal.remove("145");
		
		//Substituir
		personal.put("147", new Empleado("Paula"));
		
		//Map a Set
		//System.out.println(personal.entrySet());
		
		//Recorrer elemento a elemento de forma de set
		for ( Map.Entry<String, Empleado> entrada : personal.entrySet() ) {
			System.out.println("Clave: " + entrada.getKey() + ", Valor: " + entrada.getValue());
		}
		
		System.out.println(personal);
		
	}
	
}

class Empleado{
	
	private String nombre;
	private double sueldo;
	
	public Empleado(String n) {
		
		this.nombre = n;
		this.sueldo = 2000;
		
	}
	
	public String toString() {
		return "[ Nombre = " + nombre + ", Sueldo =" + sueldo + " ]";
	}
	
}
