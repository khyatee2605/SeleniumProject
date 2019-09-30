package DemoExcel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Scenario1 {
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static DataFormatter form=new DataFormatter();
  @Test
  public static Object[][] ReadData() throws IOException {
	  FileInputStream fis=new FileInputStream("C:/Users/pdc3a-training.pdc3a/Desktop/Login.xlsx");
	  wb=new XSSFWorkbook(fis);
	  ws=wb.getSheet("sheet1");
	  XSSFRow row=ws.getRow(0);
	  
	  int rowCount=ws.getPhysicalNumberOfRows();
	  System.out.println("Total rows: "+rowCount);
	  
	  int colCount=row.getLastCellNum();
	  System.out.println("Total columns: "+colCount);
	  
	  Object Data[][]=new Object[rowCount-1][colCount];
	  for(int i=0;i<rowCount-1;i++) {
		  XSSFRow row1=ws.getRow(i);
		  for(int j=0;j<colCount;j++) {
			  XSSFCell cell=row1.getCell(j);
			  if(cell==null) {
				  Data[i][j]="";
			  }
			  else {
				  String value=form.formatCellValue(cell);
				  Data[i][j]=value;
			  }
		  }
	  }
	  return Data;
  }
}
