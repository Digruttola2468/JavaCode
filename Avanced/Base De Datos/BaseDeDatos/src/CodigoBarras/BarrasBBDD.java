package CodigoBarras;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.Barcode39;
import com.itextpdf.text.pdf.PdfWriter;

public class BarrasBBDD {
	
	public static void main(String[] args) {
		
		PreparedStatement ps;
		ResultSet rs;
		Connection con;
		
		Image img;
		
		
		try {

			con = new ConexionModelo().getConexion();
			//Consulta
			ps = con.prepareStatement("SELECT * FROM tienda.producto;");
			rs = ps.executeQuery();
				
			
			//
			Document doc = new Document();
			//Generamos nuestro PDF
			PdfWriter pdf = PdfWriter.getInstance( doc, new FileOutputStream("codigos.pdf") );
			
			//Abrimos el archivo
			doc.open();
			
			
			Barcode39 code39 = new Barcode39();
			while(rs.next()) {
				//Colocamos el codigo
				code39.setCode(rs.getString("codigo"));
				img = code39.createImageWithBarcode(pdf.getDirectContent() , BaseColor.BLACK, BaseColor.BLACK);
				//Agregamos
				doc.add(img);
				//Salto de linea
				doc.add(new Paragraph(" "));
			}
			
			
			
			Barcode128 code128 = new Barcode128();
			//Colocamos el codigo
			code128.setCode("1234567890");
			//Creamos la imagen del codigo de barras
			Image img128 = code128.createImageWithBarcode(pdf.getDirectContent() , BaseColor.BLACK, BaseColor.BLACK);
			//Tamaño del codigo de barras medido por porcentaje
			img128.scalePercent(200);
			
			
			
			//Agregamos
			doc.add(img128);
			
			//Cerramos
			doc.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
