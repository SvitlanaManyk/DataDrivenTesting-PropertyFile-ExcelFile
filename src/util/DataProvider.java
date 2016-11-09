package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

public class DataProvider {
	
	String DATA_SOURCE = "resources/locators.xls";
	
	public String getData(String key){
		InputStream inputStream = PropertiesLoader.class.getClassLoader().getResourceAsStream(DATA_SOURCE);	
	
		if (inputStream==null){
			throw new RuntimeException("Could not find the file :"+DATA_SOURCE);
		}
		
		HSSFWorkbook workbook = null;
		
		try{
			workbook = new HSSFWorkbook(inputStream);	
		}catch (IOException e){
			throw new RuntimeException("Could not get workbook open");
		}
		
		HSSFSheet sheet = workbook.getSheetAt(0);
		
		Iterator<Row> rowIterator = sheet.iterator();
		
		String value = null;
		while(rowIterator.hasNext()){
			Row sheetRow = rowIterator.next();
			
			if(sheetRow.getCell(0).getStringCellValue().equals(key)){
				value = sheetRow.getCell(1).getStringCellValue();
				break;
			}
		}
		return value;
		
	}
	

}
