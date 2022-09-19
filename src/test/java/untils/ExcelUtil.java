package untils;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtil {
    private static XSSFSheet ExcelWSheet;
    private static XSSFWorkbook ExcelWBook;
    private static XSSFCell Cell;
    private static XSSFRow Row;

    public static String getCellData(int row, int column) {//Lay GT o hang,cot
        try {
            Cell = ExcelWSheet.getRow(row).getCell(column);//lay data
            String cellValue = Cell.getStringCellValue();
            return cellValue;
        } catch (Exception e) {
            return "";
        }
    }

    public static String[][] getDataFromExcel(String pathFile, String sheetName) throws IOException {
        String[][] tableData = null;
        FileInputStream excelFile = new FileInputStream(pathFile);
        ExcelWBook = new XSSFWorkbook(excelFile);
        ExcelWSheet = ExcelWBook.getSheet(sheetName);
        int startRow = 1;
        int startColumn = 1;
        int ci;
        int cj;
        int totalRows = ExcelWSheet.getLastRowNum();
        int totalColumn = ExcelWSheet.getRow(0).getLastCellNum() - 1;
        tableData = new String[totalRows][totalColumn];
        System.out.println(tableData[0][0]);
        for (int i = startRow; i <= totalRows; i++) {
            ci = i - 1;
            for (int j = startColumn; j <= totalColumn; j++) {
                cj = j - 1;
                tableData[ci][cj] = getCellData(i, j);
            }
        }
        return tableData;
    }
}
