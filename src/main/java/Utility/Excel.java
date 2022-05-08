package Utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {
	public static String getTextdata(String sheetName,int row,int cell) throws EncryptedDocumentException, IOException {
		FileInputStream file=new FileInputStream("D:\\Automation\\kiteZeroda\\src\\test\\resources\\Copy of Text_Data1.xlsx");
		
		String value=WorkbookFactory.create(file).getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
		return value;
		
	}
	
}
