package reuableComponents;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelOperations {

	String filepath;
	Workbook wb;
	Sheet sh;

	public ExcelOperations(String sheetName) {

		try {
			filepath = System.getProperty("user.dir") + PropertiesOperations.getPropertyValueByKey("testDataLocation");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File testDataFile = new File(filepath);

		 try {
			wb = WorkbookFactory.create(testDataFile);
		} catch (EncryptedDocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		 sh = wb.getSheet(sheetName);
	}

	public HashMap<String,String> getDataInMap(int rowNum) throws Exception, IOException   {


		//location of excel

		//open workbook

		//read data row by row and put it in map

		//sh.getRow(0).getCell(1).toString();

		HashMap<String , String> hm  = new HashMap<String , String >();

		for(int i=0;i<sh.getRow(0).getLastCellNum();i++) {

			sh.getRow(rowNum).getCell(i).setCellType(CellType.STRING);
			hm.put(sh.getRow(0).getCell(i).toString(), sh.getRow(rowNum).getCell(i).toString());

		}
		return hm;
	}


	public int getRowCount() {

		return sh.getLastRowNum();
	}
	
	public int getColCount() {
		return sh.getRow(0).getLastCellNum();
	}
}
