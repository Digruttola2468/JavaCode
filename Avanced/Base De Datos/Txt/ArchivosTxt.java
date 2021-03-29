//----------Libreria para Escribir Fichero----------
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

//----------Libreria para leer Fichero----------
import java.io.FileReader;
import java.io.BufferedReader;

//----------Libreria para los errores-----------
import java.io.IOException;

import javax.swing.JOptionPane;

public class ArchivosTxt{
   
   public void leeTxt(){
      
      //Obligatorio try-catch
      String temp = "", bfRead;
      
      String nombre = JOptionPane.showInputDialog("Nombre Fichero: ");
      File archivo = new File(nombre);
      
      if(!archivo.exists()){
	  try{
	     archivo.createNewFile();
	  }catch(Exception e){JOptionPane.showMessageDialog(null,"Error: " + e);}
      } 

      try{
         BufferedReader bf = new BufferedReader(new FileReader(archivo.getAbsolutePath()));
         System.out.println("\nLeyendo...");
         while( (bfRead = bf.readLine()) != null ){
            temp += bfRead;
	    System.out.println(temp);
	    temp = "";
         }
         
      }catch(Exception e){
         JOptionPane.showMessageDialog(null,"No se encontro el Archivo");
      }
   }





   public void EscribirFichero(){
       File f;
       FileWriter w;
       BufferedWriter bw;
       PrintWriter wr;
       
       String nombre = JOptionPane.showInputDialog("Nombre Fichero: ");
       File archiv = new File(nombre);
      
       if(!archiv.exists()){
	   try{
	      archiv.createNewFile();
	   }catch(Exception e){JOptionPane.showMessageDialog(null,"Error: " + e);}
       } 
       
       try{
          f = new File(archiv.getAbsolutePath());
          w = new FileWriter(f);
          wr = new PrintWriter(f);
          
	  for(int i=0 ; i<500 ; i++){
	      String texto = JOptionPane.showInputDialog("Espacio: " + i + 
	  	 			      		 "\nColoque lo que quiera escribir" +
							 "\nColoque Salir para Finalizar la Operacion");
  	      
 	      if(texto.equals("Salir"))
		   break;
              System.out.println(texto);
	      wr.println(texto);
	  }          
          wr.close();
	  w.close();
       }catch(Exception e){
	  JOptionPane.showMessageDialog(null,"No se encontro el Archivo");
       }
	  
   }
   




   public void CrearFicheros(){
      String numero = JOptionPane.showInputDialog("1.CrearFichero" + "\n2.EliminarFichero");
      
      if(numero.equals("1")){
         String nombre = JOptionPane.showInputDialog("Nombre Fichero: ");
         File archivo = new File(nombre);
	 
	 try{
	    if(!archivo.exists())		//Si el archivo no existe
	       archivo.createNewFile();		//Crea el archivo
	    else
	       JOptionPane.showMessageDialog(null,"Ya existe");	   //Sino no cree nada
	 }catch(Exception e){
	     JOptionPane.showMessageDialog(null,"Error: " + e);
         }

	 System.out.println("Nombre del archivo: " + archivo.getName());
	 System.out.println("Nombre Completo: " + archivo.getPath());
	 System.out.println("Direccion: " + archivo.getAbsolutePath());
	 System.out.println("Tamaño de bytes: " + archivo.length());
      }
      else if(numero.equals("2")){
	 String nombre = JOptionPane.showInputDialog("Obligatorio la extencion\nNombre Fichero: ");
	 File eliminar = new File(nombre);
	 
	 try{
	    eliminar.delete();
	 }catch(Exception e){
	    JOptionPane.showMessageDialog(null,"Error: " + e);
         }
      }else
	 JOptionPane.showMessageDialog(null,"Error de eleccion"); 
   }







   public void CrearCarpetas(){
      String nombre = JOptionPane.showInputDialog("Nombre de la carpeta: ");
      File archivo = new File(nombre);
      
      try{
         archivo.mkdir();
      }catch(Exception e){
	 JOptionPane.showMessageDialog(null,"Error: " + e);
      }
   }
}