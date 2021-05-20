package MVC;

public class Principal {
	
	public static void main(String[] args) {
		/*	Es un patron de diseño de software para programacion
		 *  que propone separar el codigo de los programas 
		 *  por sus diferentes responsabilidades*/
		
		Modelo mod = new Modelo();
		Vista vista = new Vista();
		Controlador controlador = new Controlador(vista,mod);
		
		vista.setVisible(true);
		
	}
	
}
