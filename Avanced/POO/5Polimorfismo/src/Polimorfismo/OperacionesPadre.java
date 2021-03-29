import java.util.Scanner;

public abstract class OperacionesPadre {
    protected int valor1,valor2,Resultado;

    Scanner teclado = new Scanner(System.in);
    
    //Pedimos datos al usuario
    public void PedirDatos(){
        System.out.print("Dame el primer valor: ");
        valor1 = teclado.nextInt();

        System.out.print("Dame el segundo valor: ");
        valor2 = teclado.nextInt();
    }

    //Polimorfismo
    public abstract void Operaciones();

    public void MostrarResultado(){
        System.out.print(Resultado);
    }

}
