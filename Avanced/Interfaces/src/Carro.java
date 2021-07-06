
public class Carro implements Rueda{
	
	public Carro() {
		
	}

	@Override
	public void avanzar() {
		System.out.println("El carro avanza a " + valor);
	}

	@Override
	public void detener() {
		System.out.println("El carro se detiene");
	}
	
}
