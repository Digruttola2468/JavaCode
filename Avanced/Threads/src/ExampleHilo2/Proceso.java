package ExampleHilo2;

public class Proceso extends Thread{
	
	int parametro;
	
	public Proceso(String nombreHilo){
		super(nombreHilo);
	}
	
	@Override
	public void run() {
		
		for(int i=0 ; i<= parametro ; i++) {
			System.out.println(i + this.getName());
		}
		System.out.println();
		
	}
	
	public void setParametro(int parametro) {
		this.parametro = parametro;
	}
	
}
