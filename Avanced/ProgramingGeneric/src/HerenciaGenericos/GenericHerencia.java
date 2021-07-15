package HerenciaGenericos;


public class GenericHerencia {
	
	public static void main(String[] args) {
		
		/*
		Empleado administrativa = new Empleado("Juan" , 34 , 1500);
		Jefe DirectorComercial = new Jefe("Ivan" , 28 , 3600);
		Empleado nueb = DirectorComercial;
		*/
		
		Pareja<Empleado> administrativa = new Pareja<Empleado>();
		Pareja<Jefe> DirectorComercial = new Pareja<Jefe>();
		
		//Pareja<Empleado> nuevoEmpleado = DirectorComercial;
		
		
		Pareja.imprimirTrabajador(DirectorComercial);
		Pareja.imprimirTrabajador(administrativa);
		
	}
	
}

