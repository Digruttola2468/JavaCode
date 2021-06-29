package ExampleHilo1;

public class Principal {
	
	public static void main(String[] args) {
		
		//Threads ----- Hilos
		
		Proceso1 hilo1 = new  Proceso1();
		Proceso1 hilo3 = new Proceso1();
		Thread hilo2 = new Thread(new Proceso2());
		
		
		hilo1.start();
		hilo2.start();
		hilo3.start();
	}
	
}
