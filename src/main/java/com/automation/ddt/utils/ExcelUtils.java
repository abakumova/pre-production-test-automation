package com.automation.ddt.utils;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

import static org.apache.poi.ss.usermodel.CellType.*;

public class ExcelUtils {

    private static XSSFSheet excelWSheet;
    private static XSSFWorkbook excelWBook;
    private static XSSFCell cell;

    public static Object[][] getTableArray(String filePath, String sheetName) {
        String[][] tabArray = null;
        try {
            FileInputStream excelFile = new FileInputStream(filePath);
            excelWBook = new XSSFWorkbook(excelFile);
            excelWSheet = excelWBook.getSheet(sheetName);
            int startRow = 1;
            int startCol = 1;
            int ci, cj;
            int totalRows = excelWSheet.getLastRowNum() - 1;
            System.out.println(totalRows);
            int totalCols = 2;
            tabArray = new String[totalRows][totalCols];
            ci = 0;
            for (int i = startRow; i <= totalRows; i++, ci++) {
                cj = 0;
                for (int j = startCol; j <= totalCols; j++, cj++) {
                    tabArray[ci][cj] = getCellData(i, j);
                    System.out.println(tabArray[ci][cj]);
                }
            }
        } catch (IOException e) {
            System.out.println("Could not read the Excel sheet");
            e.printStackTrace();
        }
        return (tabArray);
    }

    private static String getCellData(int rowNum, int colNum) {
        try {
            cell = excelWSheet.getRow(rowNum).getCell(colNum);
            CellType dataType = cell.getCellType();
            if (dataType == _NONE) {
                return "";
            } else {
                return cell.getStringCellValue();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw (e);
        }
    }
}