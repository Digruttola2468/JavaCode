package HerenciaGenericos;

public class Pareja<Z> {
	
	private Z primero;
	
	public Pareja(){
		primero = null;
	}
	
	public void setPrimero(Z aux) {
		this.primero = aux;
	}
	
	//? extends Empleado
	//significa que puedo colocar cualquier clase que herede de Empleado
	public static void imprimirTrabajador(Pareja<? extends Empleado> p) {
		Empleado primero = p.getPrimero();
		System.out.println(primero);
	}
	
	public Z getPrimero() {
		return primero;
	}
	
}
