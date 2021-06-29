package ExampleHilo3;

public class Principal {
	
	public static void main(String[] args) {
		
		//Primer estado: Crear una clase de tipo Thread
		Proceso pro1 = new Proceso();
		Proceso pro2 = new Proceso();
		
		//Segundo estado: Inicializar el Hilo
		pro1.start();
		
		//Metodo sleep()
		try {
			pro1.sleep(5000);
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		}
		
		pro2.start();
		
		//Metodo stop()
		pro2.stop();
		
	}
	
}
