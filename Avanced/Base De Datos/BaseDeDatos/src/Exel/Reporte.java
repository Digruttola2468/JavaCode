package Exel;

import org.apache.poi.ss.usermodel.Font;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.sun.net.httpserver.Headers;

public class Reporte {
	
	public static void main(String[] args) {
		Reporte();
	}
	
	public static void Reporte()  {
		
		Workbook book = new XSSFWorkbook();
		Sheet sheet = book.createSheet("Productos");
		
		try {
			
			InputStream in = new FileInputStream("src//Exel//PopImage.jpg");
			//Traer la imagen
			byte[] bytes = IOUtils.toByteArray(in);
			//traemos el Index de la Imagen
			int imgIndex = book.addPicture(bytes,Workbook.PICTURE_TYPE_JPEG);
			//Cerramos
			in.close();
			
			//Trabejar dentro del helper
			CreationHelper help = book.getCreationHelper();
			//Crear la imagen
			Drawing draw = sheet.createDrawingPatriarch();
			//Ancho de la imagen
			ClientAnchor anchor = help.createClientAnchor();
			anchor.setCol1(0);
			anchor.setRow1(1);
			
			Picture pict = draw.createPicture(anchor, imgIndex);
			//cambiamos el tamaño
			pict.resize(1,3);
			
			//Estilo para el Titulo
			CellStyle tituloEstilo = book.createCellStyle();
			//Alineaciones
			tituloEstilo.setAlignment(HorizontalAlignment.CENTER);
			tituloEstilo.setVerticalAlignment(VerticalAlignment.CENTER);
			//tipo de fuente
			Font fuenteTitulo = book.createFont();
			fuenteTitulo.setFontName("Arial");
			fuenteTitulo.setBold(true);
			fuenteTitulo.setFontHeightInPoints( (short) 14);
			tituloEstilo.setFont(fuenteTitulo);
			
			//Fila donde estara el titulo
			Row filaTitulo = sheet.createRow(1);
			Cell celdaTitulo = filaTitulo.createCell(1);
			celdaTitulo.setCellStyle(tituloEstilo);
			celdaTitulo.setCellValue("Reporte de Productos");
			
			//Indicar que este en varias celdas
			sheet.addMergedRegion(new CellRangeAddress(1 , 2 , 1 , 3));
			
			String[] cabecera = new String[] {
					"Codigo","Nombre","Precio","Cantidad","Importe"
			};
			
			//Celda
			CellStyle headerStyle = book.createCellStyle();
			headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
			headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			headerStyle.setBorderBottom(BorderStyle.THIN);
			headerStyle.setBorderLeft(BorderStyle.THIN);
			headerStyle.setBorderRight(BorderStyle.THIN);
			headerStyle.setBorderBottom(BorderStyle.THICK);
			
			//Fuente
			Font font = book.createFont();
			font.setFontName("Arial");
			font.setBold(true);
			font.setColor(IndexedColors.WHITE.getIndex());
			font.setFontHeightInPoints( (short) 12);
			headerStyle.setFont(font);
			
			//Colocamos la fila
			Row filaEncabezados = sheet.createRow(4);
			for(int i=0 ; i<cabecera.length ; i++) {
				
				Cell celdaEncabezado = filaEncabezados.createCell(i);
				celdaEncabezado.setCellStyle(headerStyle);
				celdaEncabezado.setCellValue(cabecera[i]);
				
			}
			
			//Conexion a MySQL para obtener los contenidos
			Connection con = new ConexionModelo().getConexion();
			PreparedStatement ps;
			ResultSet rs;
			
			//Fila de los datos de MySQL
			int numfilaDatos = 5;
			
			//Estilo de los datos
			CellStyle datosEstilo = book.createCellStyle();
			datosEstilo.setBorderBottom(BorderStyle.THIN);
			datosEstilo.setBorderLeft(BorderStyle.THIN);
			datosEstilo.setBorderRight(BorderStyle.THIN);
			datosEstilo.setBorderBottom(BorderStyle.THICK);
			
			//
			ps = con.prepareStatement("SELECT codigo , nombre , precio , cantidad FROM producto");
			rs = ps.executeQuery();
			
			int numCol = rs.getMetaData().getColumnCount();
			
			while( rs.next() ) {
				
				Row filaDatos = sheet.createRow(numfilaDatos);
				
				//Creamos cada una de las celdas
				for(int a=0 ; a<numCol ; a++) {
					
					//Creamos las celdas
					Cell CeldaDatos = filaDatos.createCell(a);
					CeldaDatos.setCellStyle(datosEstilo);
					
					//Valor a cada una de las celdas
					if(a == 2 || a==3) {
						CeldaDatos.setCellValue(rs.getDouble(a+1));
					}else
						CeldaDatos.setCellValue(rs.getString(a+1));
				}
				
				Cell celdaImporte = filaDatos.createCell(4);
				celdaImporte.setCellStyle(datosEstilo);
				celdaImporte.setCellFormula(String.format("C%d+D%d", numfilaDatos+1,numfilaDatos+1));
				
				numfilaDatos++;
			}
			
			//Ajustamos las columnas 
			sheet.autoSizeColumn(0);
			sheet.autoSizeColumn(1);
			sheet.autoSizeColumn(2);
			sheet.autoSizeColumn(3);
			sheet.autoSizeColumn(4);
			
			//zoom
			sheet.setZoom(150);
			
			//Reporte
			FileOutputStream fileOut = new FileOutputStream("ReporteProductos.xlsx");
			book.write(fileOut);
			fileOut.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
