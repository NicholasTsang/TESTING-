package testingweek;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class SpreadSheetReader {
	
	private static Workbook mworkbook =null;
	
	public SpreadSheetReader(String Filename) {
		FileInputStream excelFile = null;
		
		try {
			excelFile = new FileInputStream (new File(Filename));
			mworkbook = new XSSFWorkbook(excelFile);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		finally {
			try {
				if (excelFile != null){
					excelFile.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	  public List<String> readRow(int rowNo, String sheetName){ 
		          List<String> row = new ArrayList<String>(); 
		           Sheet datatypeSheet = mworkbook.getSheet(sheetName);
		        		    
		           Row currentRow =  ((org.apache.poi.ss.usermodel.Sheet) datatypeSheet).getRow(rowNo); 
		           for (Cell currentCell : currentRow) { 
		           switch (currentCell.getCellTypeEnum()) { 
		              	case STRING: 
		                       row.add(currentCell.getStringCellValue()); 
		                       break; 
		                case NUMERIC: 
		                       row.add(String.valueOf(currentCell.getNumericCellValue())); 
		                      break; 
		                case BOOLEAN: 
		                      row.add(String.valueOf(currentCell.getBooleanCellValue())); 
		                     break; 
		                case BLANK: 
		                     row.add(currentCell.getStringCellValue()); 
		                      break; 
		                case _NONE: 
		                     System.out.println("No Value in cell"); 
		                     break; 
		                case ERROR: 
		                       System.out.println("Error in cell"); 
		                       break; 
		                case FORMULA: 
		                       row.add(currentCell.getCellFormula()); 
		                      break; 
		              } 
		           } 
		           return row; 
	  } 

	
}
