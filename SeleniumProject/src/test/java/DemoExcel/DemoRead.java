package DemoExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class DemoRead {
  @Test
  public void f() throws IOException {
	  File src=new File("C:/Users/pdc3a-training.pdc3a/Desktop/Ansh.xlsx");
	  FileInputStream fis=new FileInputStream(src);
	  XSSFWorkbook wb = new XSSFWorkbook(fis);
	  XSSFSheet s1=wb.getSheetAt(0);
	  XSSFRow row=s1.getRow(0);
	  int rowCount=s1.getLastRowNum();
	  System.out.println("Total rows: "+rowCount);
	  
	  int colCount=row.getLastCellNum();
	  System.out.println("Total columns: "+colCount);
	  
	  for(int i=0;i<=rowCount;i++) {
		  double data=s1.getRow(i).getCell(0).getNumericCellValue();
		  System.out.println("Test data(Integer): "+data);
		  
		  String data1=s1.getRow(i).getCell(1).getStringCellValue();
		  System.out.println("Test data(String): "+data1);
	  }
	  
	  for(int i=0;i<rowCount;i++) {
	  s1.getRow(i).createCell(2).setCellValue("Heylo");
	  }
	  
	  FileOutputStream fout=new FileOutputStream(new File("C:/Users/pdc3a-training.pdc3a/eclipse-workspace/SeleniumProject/Kate.xlsx"));
	  wb.write(fout);
	  fout.close();
	  
  }
}
