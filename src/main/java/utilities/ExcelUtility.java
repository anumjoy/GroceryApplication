package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	static FileInputStream f;
	static XSSFWorkbook wb;
	static XSSFSheet sh;

	public static synchronized String getStringData(int a, int b) throws IOException {
		f = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\resources\\Excel\\ValidCredentials.xlsx");
		wb = new XSSFWorkbook(f);
		sh = wb.getSheet("Sheet1");
		Row r = sh.getRow(a);
		Cell c = r.getCell(b);
		return c.getStringCellValue();
	}

	public static synchronized String getInvalidStringData(int a, int b) throws IOException {
		f = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\resources\\Excel\\InvalidCredentials.xlsx");
		wb = new XSSFWorkbook(f);
		sh = wb.getSheet("Sheet1");
		Row r = sh.getRow(a);
		Cell c = r.getCell(b);
		return c.getStringCellValue();
	}

	public static int getNumericData(int a, int b) throws IOException {
		f = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\resources\\Excel\\ValidCredentials.xlsx");
		wb = new XSSFWorkbook(f);
		sh = wb.getSheet("Sheet1");
		Row r = sh.getRow(a);
		Cell c = r.getCell(b);
		int x = (int) c.getNumericCellValue();
		return x;
	}
}
