package ownClass;

public class Pareja<Z> {
	
	private Z primero;
	
	public Pareja(){
		primero = null;
	}
	
	public void setPrimero(Z aux) {
		this.primero = aux;
	}
	
	public Z getPrimero() {
		return primero;
	}
	
}
