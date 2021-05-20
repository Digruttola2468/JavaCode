package MVC;

public class Modelo {
	
	private int Numero1,Numero2,Resultado;
	
	//Setter
	public void setNumero1(int valor1) {
		this.Numero1 = valor1;
	}
	public void setNumero2(int valor2) {
		this.Numero2 = valor2;
	}
	public void setResultado(int Resultado) {
		this.Resultado = Resultado;
	}
	
	//Getter
	public int getNumero1(){
		return Numero1;
	}
	public int getNumero2(){
		return Numero2;
	}
	public int getResultado(){
		return Resultado;
	}
	
	
	public int Multiplicar() {
		this.Resultado = this.Numero1 * this.Numero2;
		return this.Resultado;
	}
}
