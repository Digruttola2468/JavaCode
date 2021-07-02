import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CuentasUsuarios {

	public static void main(String[] args) {
		
		//Agregamos nuevos Clientes
		Clientes cl1 = new Clientes("Ivan Di Gruttola" 		, "00001" , 80000);
		Clientes cl2 = new Clientes("Brisa Di Gruttola" 	, "00002" , 60000);
		Clientes cl3 = new Clientes("Sebastian Di Gruttola" , "00003" , 100000);
		Clientes cl4 = new Clientes("Hernana Di Gruttola" 	, "00004" , 90000);
		Clientes cl5 = new Clientes("Ivan Di Gruttola" 		, "00001" , 80000);
		
		//Usamos de tipo Coleccion el Set
		Set <Clientes> clientesBanco = new HashSet<Clientes>();
		
		//Agregamos en la coleccion
		clientesBanco.add(cl1);
		clientesBanco.add(cl2);
		clientesBanco.add(cl3);
		clientesBanco.add(cl4);
		clientesBanco.add(cl5);
		
		//Para eliminar elementos es preferible usar un Iterator
		Iterator<Clientes> it = clientesBanco.iterator();
		while(it.hasNext()) {
			
			String nombre = it.next().getNombre();
			if( nombre.equals("Ivan Di Gruttola") )
				it.remove();
			
		}
		
		//Mostramos en Pantalla
		for(Clientes clientes : clientesBanco) {

			System.out.println( clientes.getNombre() + " " + 
								clientes.getnCuenta() + " " +
								clientes.getSaldo());
			
		}
		
		/*	Este codigo no serve para imprimir todos los objetos
		Iterator<Clientes> it = clientesBanco.iterator();
		while(it.hasNext()){
			
			String nombreCliente = it.next().getNombre();
			
			System.out.println("Nombre: " + nombreCliente);
			
		}*/
		
	}

}
