

public class Bici implements Rueda , Silla{
	
	Bici(){}

	@Override
	public void avanzar() {
		System.out.println("La Bicicleta avanza");
	}

	@Override
	public void detener() {
		System.out.println("La bicicleta se detiene");
	}

	@Override
	public void sentarse() {
		System.out.println("Estoy sentado ");
	}
	
	
	
}
