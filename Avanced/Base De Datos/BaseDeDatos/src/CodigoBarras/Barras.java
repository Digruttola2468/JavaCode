package CodigoBarras;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.Barcode39;
import com.itextpdf.text.pdf.PdfWriter;

public class Barras {
	
	public static void main(String[] args) {
		
		//lib ---> itext5-itextpdf and itext5-itext-pdfa
		
		try {
			
			//
			Document doc = new Document();
			//Generamos nuestro PDF
			PdfWriter pdf = PdfWriter.getInstance( doc, new FileOutputStream("codigos.pdf") );
			
			//Abrimos el archivo
			doc.open();
			
			
			Barcode39 code39 = new Barcode39();
			//Colocamos el codigo
			code39.setCode("1234567890");
			Image img39 = code39.createImageWithBarcode(pdf.getDirectContent() , BaseColor.BLACK, BaseColor.BLACK);
			
			
			Barcode128 code128 = new Barcode128();
			//Colocamos el codigo
			code128.setCode("1234567890");
			//Creamos la imagen del codigo de barras
			Image img128 = code128.createImageWithBarcode(pdf.getDirectContent() , BaseColor.BLACK, BaseColor.BLACK);
			//Tamaño del codigo de barras medido por porcentaje
			img128.scalePercent(200);
			
			//Agregamos
			doc.add(img39);
			
			//Salto de linea
			doc.add(new Paragraph(" "));
			
			//Agregamos
			doc.add(img128);
			
			//Cerramos
			doc.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
}
