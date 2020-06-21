package com.dataprovider;

import java.io.IOException;
import java.util.ArrayList;

public class TestUtil {
	
	
	static String sheetname="Registration";
	public static ArrayList<Object[]> getDatafromExcel() throws IOException
	{
		Excel excel = null;
		
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		
		//Reading excel file location and sheetname
		try {
			 excel = new Excel("E://Git//SeleniumExercises//src//test//java//com//dataprovider//ebay.xlsx", 
					 sheetname);
		} catch (IOException e) {
			System.out.println("File Not found");
		}
		
		//Getting data from excel
		for(int i=1;i<=Excel.getRowCount()-1;i++)
		{
			String firstname= excel.getCellData(sheetname, 0, i);
			
			String lastname=excel.getCellData(sheetname, 1, i);
			
			String email= excel.getCellData(sheetname, 2, i);
			
			String password= excel.getCellData(sheetname, 3, i);
			
			Object obj[] ={firstname, lastname, email, password};
			myData.add(obj);
		
		}
		return myData;
	}
	

}

