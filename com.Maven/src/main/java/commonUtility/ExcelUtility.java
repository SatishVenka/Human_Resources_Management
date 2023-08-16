package commonUtility;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ExcelUtility {
	

	/**
	 * 
	 * @param sheet
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws Throwable
	 * @throws IOException
	 */
		public String getValueFromExcel(String sheet, int rowNo, int cellNo ) throws Throwable, IOException
		{
			FileInputStream fi = new FileInputStream(IPathConstantsUtility.excelFilePath);
			Workbook wb = WorkbookFactory.create(fi);
			Sheet sh = wb.getSheet(sheet);
			String data = sh.getRow(rowNo).getCell(cellNo).getStringCellValue();
			return data;
		}
		/**
		 * 
		 * @param sheet
		 * @param rowNo
		 * @param cellNo
		 * @param value
		 * @throws Throwable
		 */
		public void setValueFRomExcel(String sheet,int rowNo,int cellNo,String value) throws Throwable
		{
			FileInputStream fi = new FileInputStream(IPathConstantsUtility.excelFilePath);
			Workbook wb = WorkbookFactory.create(fi);
			Sheet sh = wb.getSheet(sheet);
			sh.getRow(rowNo).getCell(cellNo).setCellValue(value);
			FileOutputStream fos = new FileOutputStream(IPathConstantsUtility.excelFilePath);
			wb.write(fos);
			wb.close();
		}
		/**
		 * 
		 * @param sheet
		 * @param KeyNo
		 * @param ValueNo
		 * @return
		 * @throws Throwable
		 */
		public HashMap<String, String> getMultipuldata(String sheet,int KeyNo,int ValueNo ) throws Throwable
		{
			FileInputStream fi = new FileInputStream(IPathConstantsUtility.excelFilePath);
			Workbook wb = WorkbookFactory.create(fi);
			Sheet sh = wb.getSheet(sheet);
			int count = sh.getLastRowNum();
			
		JavaUtlity Jlib = new JavaUtlity();
		
		
			HashMap<String,String> map = new HashMap<String,String>();
			for(int i=0;i<count;i++)
			{
				String key = sh.getRow(i).getCell(KeyNo).getStringCellValue();
				String value = sh.getRow(i).getCell(ValueNo).getStringCellValue();
				map.put(key, value);
			}
			
			//for(Entry<String, String> set:map.entrySet())
			//{
		//		driver.findElement(By.name(set.getKey())).sendKeys(Jlib.randamNumberGeneration()+set.getValue());
			//}
			return map;
		}
		/**
		 * 
		 * @param sheet
		 * @return
		 * @throws EncryptedDocumentException
		 * @throws IOException
		 */
		public Object[][] getmultipulSetData(String sheet ,int a) throws EncryptedDocumentException, IOException
		{
			FileInputStream  fis = new FileInputStream(IPathConstantsUtility.excelFilePath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheet);
			int lastRow = sh.getLastRowNum();
			 int lastCell = sh.getRow(a).getLastCellNum();;
			Object[][] obj = new Object[lastRow+1][lastCell];
			for(int i=0;i<=lastRow;i++)
			{
				for(int j=0;j<lastCell;j++)
				{
					obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
				}
			
			}
			return obj;
		}
			
	

	
}
		
	


