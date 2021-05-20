package Exel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class Principal {
	
	static PreparedStatement ps;
	static ResultSet rs;
	
	public static void main(String[] args) {
		
		/*
		 * HSSFWorkbook – org.apache.poi.hssf.usermodel.HSSFWorkbook

		 * Nos va a permitir trabajar con archivos Excel en formato .xls
		 * XSSFWorkbook – org.apache.poi.xssf.usermodel.XSSFWorkbook

		 * Nos va a permitir trabajar con archivos Excel en formato .xlsx
		 * SXSSFWorkbook – org.apache.poi.xssf.streaming.SXSSFWorkbook
		*/
		
		/*Librerias: 
		 * poi-version.jar
		 * commons-collections-version.jar
		 * poi-ooxml-version.jar
		 * poi-ooxml-schemas-version.jar
		 * xmlbeans-version.jar
		 * */
		
		//Crear y Escribir en Excel
		//crearExcel();
		
		//Leer el archivo Excel
		//Leer();
		
		
		//			MySQL
		//cargarMySQL();
		
		Modificar();
	}
	
	//Crear un Libro en Exel
	public static void crearExcel() {
		
		Workbook boo = new XSSFWorkbook();
		Sheet sheet = boo.createSheet("JavaExcel");
		
		//			Imprimimos en Excel				
		
		//Fila 0
		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue("Hola Mundo");
		row.createCell(1).setCellValue(7.45);
		row.createCell(2).setCellValue(false);
		//Columna 3
		Cell celda = row.createCell(3);
		celda.setCellFormula(String.format("1+1", ""));
		
		
		
		//Fila 1
		Row row1 = sheet.createRow(1);
		row1.createCell(0).setCellValue(7);
		row1.createCell(1).setCellValue(8);
		//Columna 2
		Cell celdados = row1.createCell(2);
		celdados.setCellFormula(String.format("A%d+B%d", 2,2));
		
		try {
			//Creamos el Fichero excel
			FileOutputStream fileOut = new FileOutputStream("Excel.xlsx");
			//Escribimos
			boo.write(fileOut);
			fileOut.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static void Leer() {
		
		try {
			
			FileInputStream file = new FileInputStream(new File("D:\\eclipseWorkspace\\BaseDeDatos\\productos.xlsx"));
			
			//Extraer la informacion del archivo
			XSSFWorkbook wb = new XSSFWorkbook(file);
			//Indicamos con que hoja vamos a trabajar
			XSSFSheet sheet = wb.getSheetAt(0);
			
			//Pedimos el Numero de Filas
			int numFilas = sheet.getLastRowNum();
			
			for(int i=0 ; i<=numFilas ; i++) {
				Row fila = sheet.getRow(i);
				int numColum = fila.getLastCellNum();
				
				for(int j=0 ; j<numColum ; j++) {
					Cell celda = fila.getCell(j);
					//Tipo de celda que vamos a traer
					switch(celda.getCellTypeEnum().toString()) {
						case "NUMERIC":
							System.out.print(celda.getNumericCellValue() + " ");
							break;
						case "STRING":
							System.out.print(celda.getStringCellValue() + " ");
							break;
						case "FORMULA":
							System.out.print(celda.getCellFormula() + " ");
							break;
					}
				}

				System.out.println();
			}
			
			
			
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
		
	}
	
	public static void cargarMySQL() {

		try {
			Connection con = new ConexionModelo().getConexion();
			FileInputStream file = new FileInputStream(new File("D:\\eclipseWorkspace\\BaseDeDatos\\productos.xlsx"));
			
			//Extraer la informacion del archivo
			XSSFWorkbook wb = new XSSFWorkbook(file);
			//Indicamos con que hoja vamos a trabajar
			XSSFSheet sheet = wb.getSheetAt(0);
			
			//Pedimos el Numero de Filas
			int numFilas = sheet.getLastRowNum();
			
			for(int i=1 ; i<=numFilas ; i++) {
				Row fila = sheet.getRow(i);
				
				ps = con.prepareStatement("INSERT INTO producto (codigo,nombre,precio,cantidad) VALUES(?,?,?,?)");
				
				ps.setDouble(1, fila.getCell(0).getNumericCellValue());
				ps.setString(2, fila.getCell(1).getStringCellValue());
				ps.setDouble(3, fila.getCell(2).getNumericCellValue());
				ps.setDouble(4, fila.getCell(3).getNumericCellValue());
				
				ps.execute();
				
			}
			
			con.close();
			
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
		
	}
	
	public static void Modificar() {
		try {
			
			FileInputStream file = new FileInputStream(new File("D:\\eclipseWorkspace\\BaseDeDatos\\productos.xlsx"));
			
			//Extraer la informacion del archivo
			XSSFWorkbook wb = new XSSFWorkbook(file);
			//Indicamos con que hoja vamos a trabajar
			XSSFSheet sheet = wb.getSheetAt(0);
			
			XSSFRow fila = sheet.getRow(1);
			
			if(fila == null) {
				fila.getSheet().createRow(1);
			}
			
			XSSFCell celda = fila.createCell(1);
			
			if(celda == null) {
				celda = fila.createCell(1);
			}
			
			celda.setCellValue("Modificacion");
			
			file.close();
			FileOutputStream output = new FileOutputStream("D:\\eclipseWorkspace\\BaseDeDatos\\nuevo.xlsx");
			wb.write(output);
			output.close();
			
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
		
	}
	}
	
	

