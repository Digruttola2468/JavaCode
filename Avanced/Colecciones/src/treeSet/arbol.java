package treeSet;

import java.util.Comparator;
import java.util.TreeSet;

public class arbol {
	
	public static void main(String[] args) {
		
		/*TreeSet<String> ordenaPersonas = new TreeSet<String>();
		
		ordenaPersonas.add("Sandra");
		ordenaPersonas.add("Amanda");
		ordenaPersonas.add("Diana");
		ordenaPersonas.add("Ivan");
		
		for ( String nombres : ordenaPersonas ) {
			System.out.println(nombres);
		}
		*/
		
		
		
		Articulo primero = new Articulo(1,"cPrimer articulo");
		Articulo segundo = new Articulo(2,"bSegundo articulo");
		Articulo tercero = new Articulo(3,"aTercer articulo");
		
		TreeSet<Articulo> ordenaArticulos = new TreeSet<Articulo>();
		ordenaArticulos.add(tercero);
		ordenaArticulos.add(primero);
		ordenaArticulos.add(segundo);
		
        
		for ( Articulo art : ordenaArticulos ) 
			System.out.println(art.getDescripcion());
		
		
		System.out.println("\n");
		
		
		TreeSet<Articulo> ordenaAfabetico = new TreeSet<Articulo> ( new Comparator<Articulo>() {
			@Override
			public int compare(Articulo o1, Articulo o2) {
				
				String descripcion1 = o1.getDescripcion();
				String descripcion2 = o2.getDescripcion();
				
				return descripcion1.compareTo(descripcion2);
			}
		});
		
		ordenaAfabetico.add(primero);
		ordenaAfabetico.add(tercero);
		ordenaAfabetico.add(segundo);
		
		for ( Articulo art: ordenaAfabetico )
			System.out.println(art.getDescripcion());
		
	}
	
	
}


class Articulo implements Comparable<Articulo>{

	private String descripcion;
	private int numero;	
	
	public String getDescripcion() {
		return descripcion;
	}
	
	Articulo(int num , String desc){
		this.numero 	 = num;
		this.descripcion = desc;
	}
	
	@Override
	public int compareTo(Articulo o) {
		return numero - o.numero;
	}

	
}
