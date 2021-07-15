package MetodoGenerico;

import java.util.ArrayList;
import java.util.Iterator;

public class UsoEmpleado {
	
	public static void main(String[] args) {
		/*
		Empleado listaEmpleado[] = new Empleado[3];
		listaEmpleado[0] = new Empleado("Ana" , 45 , 2500);
		listaEmpleado[1] = new Empleado("Ana" , 55 , 2000);
		listaEmpleado[2] = new Empleado("Ana" , 25 , 2600);
		
		*/
		
		
		ArrayList<Empleado> listaEmpleado = new ArrayList<Empleado>();
		
		listaEmpleado.add(new Empleado("Ivan" , 17, 2400));
		listaEmpleado.add(new Empleado("Brisa" , 13, 2500));
		listaEmpleado.add(new Empleado("Sebastian" , 14, 2700));
		listaEmpleado.add(new Empleado("Paula" , 74, 2500));
		listaEmpleado.add(new Empleado("Hernan" , 24, 2600));
		listaEmpleado.add(new Empleado("Lucia" , 34, 2100));
		listaEmpleado.add(new Empleado("Ivan" , 17, 2400));
		listaEmpleado.add(new Empleado("Brisa" , 13, 2500));
		listaEmpleado.add(new Empleado("Sebastian" , 14, 2700));
		listaEmpleado.add(new Empleado("Paula" , 74, 2500));
		listaEmpleado.add(new Empleado("Hernan" , 24, 2600));
		listaEmpleado.add(new Empleado("Lucia" , 34, 2100));
		
		/*
		listaEmpleado.set(11, new Empleado("Juan" , 19 , 2999) );
		
		System.err.println(listaEmpleado.get(11).getDatos());
		
		System.err.println( listaEmpleado.size() );
		
		
		Empleado arrayEmpleados[] = new Empleado[ listaEmpleado.size() ];
		listaEmpleado.toArray(arrayEmpleados);
		
		for ( int i=0 ; i<arrayEmpleados.length ; i++ ) {
			System.out.println(arrayEmpleados[i].getDatos());
		}*/
		
		//Iterator
		Iterator<Empleado> iterator = listaEmpleado.iterator();
		while ( iterator.hasNext() ) {
			System.out.println(iterator.next().getDatos());
		}
		
	}
	
	
}

class Empleado{
	
	private String nombre;
	private int edad;
	private double sueldo;
	
	Empleado(String nombre , int edad , double sueldo){
		this.nombre = nombre;
		this.edad = edad;
		this.sueldo = sueldo;
	}
	
	public String getDatos() {
		return "Nombre:" + nombre + "   Edad:" + edad  + "   Salario:"  + sueldo + "  ";
	}
	
}