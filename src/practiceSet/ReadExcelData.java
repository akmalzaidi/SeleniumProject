package practiceSet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcelData {

	@Test
	public void ExcelReadCode() throws Exception {

		File srcFile = new File(
				"C:\\Users\\acer\\eclipse-workspace\\MyFrameworks" + "\\practiceTestNg\\TestData\\UserTestData.xlsx");

		FileInputStream fis = new FileInputStream(srcFile);

		XSSFWorkbook wb = new XSSFWorkbook(fis);

		XSSFSheet sheet = wb.getSheet("Sheet1");
		//XSSFRow row =sheet.getRow(1);
		//XSSFCell cell =row.getCell(0);
		 String value =sheet.getRow(0).getCell(1).getStringCellValue();
		System.out.println(value);
		
		//reading complete data using for loop
		
		int rowcount = sheet.getLastRowNum();
		System.out.println("number of rows: "+ rowcount);
		
		for(int i=0;i<rowcount;i++) {
			String str = sheet.getRow(i).getCell(0).getStringCellValue();
			String str2 =sheet.getRow(i).getCell(1).getStringCellValue();
			
			System.out.print(str+" ");

			System.out.println(str2);
			
		}
		
		

	}

}
