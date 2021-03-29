public class Principal {
    public static void main(String[] args) {

        OperacionesPadre Sumar = new Suma();
        Sumar.PedirDatos();                     //Pedimos los valores
        Sumar.Operaciones();                    //Hace la suma
        Sumar.MostrarResultado();               //Muestra los Datos

        System.out.println("\n");

        OperacionesPadre Restar = new Resta();
        Restar.PedirDatos();                    //Pedimos los valores
        Restar.Operaciones();                   //Hace la Resta
        Restar.MostrarResultado();              //Muesta los Datos

    }
}
