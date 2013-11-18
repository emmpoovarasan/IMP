package keyworddriven.UtilFunctions;

import java.io.File;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import keyworddriven.Logs.GetLogger;

public class ExtractDataFromExcel {

	static Workbook wrkBook=null;
	static Sheet wrkSheet;

	public ExtractDataFromExcel(String filePath){
		try {
			System.out.println("Test "+ getClass().getName());
			wrkBook = Workbook.getWorkbook(new File(filePath));
			GetLogger.fileLogger("Selected correct file");
		} catch (BiffException e) {
			System.out.println("BiffException -- "+e.getMessage());
			GetLogger.fileLogger(e.getMessage());
		} catch (IOException e) {
			System.out.println("IOException -- "+e.getMessage());
			GetLogger.fileLogger(e.getMessage());
		}
	}
	
	public static String[][] getDataFromExcelSheet(String sheetName){
		wrkSheet = wrkBook.getSheet(sheetName);
		
		String[][] extractedData = new String[wrkSheet.getRows()][wrkSheet.getColumns()];
		
		for(int i=0; i < extractedData.length;i++){
			for(int j=0; j<extractedData[i].length;j++){
				extractedData[i][j] = wrkSheet.getCell(j, i).getContents();
				System.out.println(extractedData[i][j]);
			}
		}
		
		return extractedData;
	}
	
	/*public static void main(String a[]){
		ExtractDataFromExcel et = new ExtractDataFromExcel("src\\DataFiles\\KeywordDriven.xls");
		et.getDataFromExcelSheet("Sheet1");
	}*/
}
