package compareTwoExcels;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;

public class CompareExcels {

	public static void main(String[] args) throws IOException {

		FileInputStream fileInputStream1 = new FileInputStream(
				System.getProperty("user.dir") + "//src//test//java//compareTwoExcels//Book11.xls");
		HSSFWorkbook hssfWorkbook1= new HSSFWorkbook(fileInputStream1);
		HSSFSheet hssfSheet1=hssfWorkbook1.getSheet("Sheet1");
		int rowcount1= hssfSheet1.getPhysicalNumberOfRows();
		int columncount1=hssfSheet1.getRow(0).getPhysicalNumberOfCells();
		FileInputStream fileInputStream2 = new FileInputStream(
				System.getProperty("user.dir") + "//src//test//java//compareTwoExcels//Book22.xls");
		HSSFWorkbook hssfWorkbook2= new HSSFWorkbook(fileInputStream2);
		HSSFSheet hssfSheet2=hssfWorkbook2.getSheet("Sheet1");
		int rowcount2= hssfSheet2.getPhysicalNumberOfRows();
		int columncount2=hssfSheet2.getRow(0).getPhysicalNumberOfCells();
		if(rowcount1==rowcount2 && columncount1==columncount2){
			System.out.println("Both have same number of rows and columns");
			
			for(int i=1;i<rowcount1;i++){
				
				HSSFRow hssfRow1= hssfSheet1.getRow(i);
				HSSFRow hssfRow2= hssfSheet2.getRow(i);
				
				//------------Comparing Column0 Row1 Values------------------------
				String idStr1="";
				HSSFCell id1=hssfRow1.getCell(0);
				if(id1!=null){
					id1.setCellType(CellType.STRING);
					idStr1=id1.getStringCellValue();
				}
				
				String idStr2="";
				HSSFCell id2=hssfRow2.getCell(0);
				if(id2!=null){
					id2.setCellType(CellType.STRING);
					idStr2=id2.getStringCellValue();
				}
				
				if(!idStr1.equals(idStr2)){
					 System.out.println("[ERROR] :"+"Diference for id (book1) " + idStr1 + "| Book 1 id = " + idStr1+ " | Book 2 id = " + idStr2);
				}
				
				// ------------------------------ comapring Name --------------------------
		        String namestr1 = "";
		        HSSFCell name1 = hssfRow1.getCell(1);
		        if (name1 != null) {
		            name1.setCellType(CellType.STRING);
		            namestr1 = name1.getStringCellValue();
		        }


		        String namestr2 = "";
		        HSSFCell name2 = hssfRow2.getCell(1);
		        if (name2 != null) {
		            name2.setCellType(CellType.STRING);
		            namestr2 = name2.getStringCellValue();
		        }

		        if(!namestr1.equals(namestr2))
		        {
		            System.out.println("[ERROR] :"+"Diference for id (book1) " + idStr1 + " | Book 1 name = " + namestr1+ "| Book 2 name = " + namestr2);
		        }
		//------------------------------ End Name Comparison---------------------------------

		        // ------------------------------ comapring branch --------------------------
		        String branchstr1 = "";
		        HSSFCell branch1 = hssfRow1.getCell(2);
		        if (branch1 != null) {
		            branch1.setCellType(CellType.STRING);
		            branchstr1 = branch1.getStringCellValue();
		        }


		        String branchstr2 = "";
		        HSSFCell branch2 = hssfRow2.getCell(2);
		        if (branch2 != null) {
		            branch2.setCellType(CellType.STRING);
		            branchstr2 = branch2.getStringCellValue();
		        }

		        if(!branchstr1.equals(branchstr2))
		        {
		            System.out.println("[ERROR] :"+"Diference for id (book1) " + idStr1 + "| Book 1 branch = " + branchstr1+ "| Book 2 branch = " + branchstr2);
		        }
		//------------------------------ End branch Comparison---------------------------------

		// ------------------------------ comapring marks --------------------------
		        String marksstr1 = "";
		        HSSFCell marks1 = hssfRow1.getCell(3);
		        if (marks1 != null) {
		            marks1.setCellType(CellType.STRING);
		            marksstr1 = marks1.getStringCellValue();
		        }


		        String marksstr2 = "";
		        HSSFCell marks2 = hssfRow2.getCell(3);
		        if (marks2 != null) {
		            marks2.setCellType(CellType.STRING);
		            marksstr2 = marks2.getStringCellValue();
		        }

		        if(!marksstr1.equals(marksstr2))
		        {
		            System.out.println("[ERROR] :"+"Diference for id (book1) " + idStr1 + " | Book 1 marks = " + marksstr1+ " | Book 2 marks = " + marksstr2);
		        }
		//------------------------------ End marks Comparison---------------------------------

		// ------------------------------ comapring city --------------------------
		        String citystr1 = "";
		        HSSFCell city1 = hssfRow1.getCell(4);
		        if (city1 != null) {
		            city1.setCellType(CellType.STRING);
		            citystr1 = city1.getStringCellValue();
		        }


		        String citystr2 = "";
		        HSSFCell city2 = hssfRow2.getCell(4);
		        if (city2 != null) {
		            city2.setCellType(CellType.STRING);
		            citystr2 = city2.getStringCellValue();
		        }

		        if(!citystr1.equals(citystr2))
		        {
		            System.out.println("[ERROR] :"+"Diference for id (book1) " + idStr1 + " | Book 1 city = " + citystr1+ " | Book 2 city = " + citystr2);
		        }
			}
			
			
		}
		else{
			System.out.println(" Number of rows in excel1 is "  + rowcount1);
			System.out.println(" Number of rows in excel2 is " +rowcount2);
		}
		
		hssfWorkbook1.close();
		hssfWorkbook2.close();
	}

}
