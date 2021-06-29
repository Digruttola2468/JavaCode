package ExampleHilo4;

public class Principal {
	public static void main(String[] args) throws InterruptedException {
		
		Hilo1 hilo1 = new Hilo1();
		Hilo2 hilo2 = new Hilo2();
		Hilo3 hilo3 = new Hilo3();
		Hilo4 hilo4 = new Hilo4();
		
		hilo1.start();
		
		hilo2.start();
		
		hilo3.start();
		
		hilo4.start();
		
		
	}
}
