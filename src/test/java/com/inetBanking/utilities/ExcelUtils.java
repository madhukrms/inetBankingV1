package com.inetBanking.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet sheet;

	public ExcelUtils(String excelPath, String SheetName) throws IOException {
		FileInputStream fis = new FileInputStream(excelPath);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet("SheetName");
	}

	public int getRowCount() {
		int rowCount = sheet.getPhysicalNumberOfRows();
		return rowCount;
	}

	public int getColCount() {

		int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
		return colCount;
	}

    public String getCellData(int rowNum, int colNum) {
        DataFormatter formatter = new DataFormatter();
        return formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
    }

    public Object[][] getDataAsObjectArray() {
        int rowCount = getRowCount();
        int colCount = getColCount();

        Object[][] data = new Object[rowCount - 1][colCount];

        for (int i = 1; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                data[i - 1][j] = getCellData(i, j);
            }
        }
        return data;
    }
}