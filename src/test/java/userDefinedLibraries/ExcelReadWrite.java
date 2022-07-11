package userDefinedLibraries;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadWrite {

	public static File src;
	public static FileInputStream fileIP;
	public static FileOutputStream fileOP;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFCell cell1;
	public static XSSFCell cell2;
	public static XSSFCell cell3;
	public static XSSFCell cell4;
	public static XSSFCell cell5;
	public static XSSFCell cell6;
	public static XSSFCell cell7;
	public static XSSFRow row;
	public static String excelFilePath = "./src/test/java/dataTables/GSDInputsOutputs.xlsx";
	public static String srhText;
	public static String iFrameName;
	public static String cntrName;
	public static int Row;

	public static int excelRead() {
		
		try {
			
			src = new File(excelFilePath);
			fileIP = new FileInputStream(src);
			workbook = new XSSFWorkbook(fileIP);
			sheet = workbook.getSheetAt(0);
			
			for(int i=1; i<=sheet.getLastRowNum(); i++) {
				
				if(i==1) {
					
					srhText    = (sheet.getRow(1).getCell(0).getStringCellValue());
					iFrameName = (sheet.getRow(1).getCell(1).getStringCellValue());
					cntrName   = (sheet.getRow(1).getCell(2).getStringCellValue());
					Row = i;
					break;
			
				}
				
			}
			
		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

		return Row;
		
	}
	
	public static void excelWrite(String NAME, String DESIGNATION) {
		
		try {
			
			fileIP.close();
			sheet = workbook.getSheetAt(1);
			
			row = sheet.getRow(Row);
			
			if(row == null)
				row = sheet.createRow(Row);
			
			cell1 = row.getCell(0);
			
			if(cell1 == null)
				cell1 = row.createCell(0);
			
			cell1.setCellValue(NAME);
			
			cell2 = row.getCell(1);
			
			if(cell2 == null)
				cell2 = row.createCell(1);
			
			cell2.setCellValue(DESIGNATION);
			
			fileOP = new FileOutputStream(new File(excelFilePath));
			workbook.write(fileOP);
			fileOP.close();
			
		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
		
	}
	
	public static void excelWrite(String[] Header, String[] gsdList1, String[] gsdList2, String[] gsdList3, String[] gsdList4) {
		
		try {
			
			sheet = workbook.getSheetAt(2);
			
			row = sheet.getRow(0);
			
			if(row == null)
				row = sheet.createRow(0);
			
			for(int i=0; i<Header.length;i++) {
				
				cell3 = row.getCell(i);
				
				if(cell3 == null)
					cell3 = row.createCell(i);
				
				cell3.setCellValue(Header[i]);
				
			}
			
			for(int i=1; i<=gsdList1.length;i++) {
				
				row = sheet.getRow(i);
				
				if(row == null)
					row = sheet.createRow(i);
				
				cell4 = row.getCell(0);
				
				if(cell4 == null)
					cell4 = row.createCell(0);
				
				cell4.setCellValue(gsdList1[i-1]);
				
			}
			
			for(int i=1; i<=gsdList2.length;i++) {
				
				row = sheet.getRow(i);
				
				if(row == null)
					row = sheet.createRow(i);
				
				cell5 = row.getCell(1);
				
				if(cell5 == null)
					cell5 = row.createCell(1);
				
				cell5.setCellValue(gsdList2[i-1]);
				
			}
			
			for(int i=1; i<=gsdList3.length;i++) {
				
				row = sheet.getRow(i);
				
				if(row == null)
					row = sheet.createRow(i);
				
				cell6 = row.getCell(2);
				
				if(cell6 == null)
					cell6 = row.createCell(2);
				
				cell6.setCellValue(gsdList3[i-1]);
				
			}
			
			for(int i=1; i<=gsdList4.length;i++) {
				
				row = sheet.getRow(i);
				
				if(row == null)
					row = sheet.createRow(i);
				
				cell7 = row.getCell(3);
				
				if(cell7 == null)
					cell7 = row.createCell(3);
				
				cell7.setCellValue(gsdList4[i-1]);
				
			}
			
			fileOP = new FileOutputStream(new File(excelFilePath));
			workbook.write(fileOP);
			fileOP.close();
			
		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
		
	}
	
}