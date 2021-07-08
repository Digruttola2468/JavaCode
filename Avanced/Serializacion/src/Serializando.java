import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;


public class Serializando {
	
	public static void main(String[] args) {
		
		
		Administrador jefe = new Administrador("Ivan" , 90000, 2004 , 3, 8);
		jefe.setIncentivo(5000);
		
		Empleado[] persona = new Empleado[3];
		persona[0] = jefe;
		persona[1] = new Empleado ("Ana" , 25000 , 2008, 10, 1);
		persona[2] = new Empleado ("Luis" , 18000 , 2002 , 9 , 15);
		
		//Escribirmos el archivo creador automaticamente si es que no existe
		/*try {
			ObjectOutputStream escribir = new ObjectOutputStream(new FileOutputStream("C:\\Users\\ivans\\Desktop\\nuevo.txt"));
			escribir.writeObject(persona);
			
			escribir.close();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}*/
		
		//Recuperando fichero escrito anteriormente
		try {
			ObjectInputStream leer = new ObjectInputStream(new FileInputStream("C:\\Users\\ivans\\Desktop\\nuevo.txt"));
			Empleado[] personaRecuperado = (Empleado[]) leer.readObject();
			
			leer.close();
			
			for ( Empleado perso : personaRecuperado ) 
				System.out.println(perso);
			
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		
	}
	
	
}

class Empleado implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5558812148737237760L;
	private String nombre;
	private double sueldos;
	private Date fechaContrato;
	
	public Empleado(String n , double s , int agno , int mes , int dia) {
		this.nombre = n;
		this.sueldos = s;
		GregorianCalendar calendar = new GregorianCalendar(agno,mes-1,dia);
		fechaContrato = calendar.getTime();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getSueldo() {
		return sueldos;
	}

	public void setSueldo(double sueldo) {
		this.sueldos = sueldo;
	}

	public void subirSueldo(double porcentaje) {
		double aumento = sueldos * porcentaje / 100;
		sueldos += aumento;
	}
	
	//Descripcion de nuestra clase , osea que es lo que hace nuestra clase
	public String toString() {
		return "Nombre: " + nombre + ", sueldo = " + sueldos + " , fecha de contrato = " + fechaContrato;
	}
	
}

class Administrador extends Empleado{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2138837468407811860L;
	
	private double incentivo;
	public Administrador(String n, double s, int agno, int mes, int dia) {
		super(n, s, agno, mes, dia);
		incentivo = 0;
	}
	
	public double getSueldo() {
		double sueldoBase = super.getSueldo();
		return sueldoBase + incentivo;
	}
	
	public void setIncentivo (double b) {
		incentivo = b;
	}
	
	public String toString() {
		return super.toString() + " Incentivo " + incentivo;
	}
	
}