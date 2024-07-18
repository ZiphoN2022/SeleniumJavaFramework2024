package Utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadData {

    String testDataDir = System.getProperty("user.dir") + "/src/test/java/TestData/TestData.xlsx";

    FileInputStream fileInputStream = new FileInputStream(testDataDir);
    XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);


    public ReadData() throws IOException {
    }

    XSSFSheet sheet =workbook.getSheet("Login Details");

    public String username =sheet.getRow(1).getCell(2).getStringCellValue();
    public String pasword =sheet.getRow(8).getCell(3).getStringCellValue();

    @Test
    public void test(){
        System.out.println(username);
        System.out.println(pasword);
    }

}
