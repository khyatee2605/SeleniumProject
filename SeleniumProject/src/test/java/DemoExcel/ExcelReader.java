package DemoExcel;

import java.io.FileInputStream;


import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelReader {

public static XSSFWorkbook workbook;
public static XSSFSheet worksheet;
public static DataFormatter formatter = new DataFormatter();


public static Object[][] ReadData() throws Exception {

 FileInputStream fin = new FileInputStream("C:\\Users\\pdc3a-training.pdc3a\\Desktop\\Login.xlsx");
 workbook = new XSSFWorkbook(fin);
 worksheet = workbook.getSheet("sheet1");
 XSSFRow Row =worksheet.getRow(0);
 int RowNum = worksheet.getPhysicalNumberOfRows();
 int ColNum = Row.getLastCellNum();

 System.out.println("RowNum : "+RowNum+"\n ColNum : "+ColNum);
 Object Data[][]= new Object[RowNum-1][ColNum];
 for(int i=0;i<RowNum-1;i++)
 {
  XSSFRow row =worksheet.getRow(i);
  for(int j=0;j<ColNum;j++) {
   XSSFCell cell =row.getCell(j);
   if(cell==null)
    Data[i][j]="";
   else {
    String value=formatter.formatCellValue(cell);
    Data[i][j]=value;
   }
  }
 }


 return Data;

}
}