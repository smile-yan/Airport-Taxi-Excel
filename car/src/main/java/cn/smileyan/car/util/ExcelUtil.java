package cn.smileyan.car.util;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ExcelUtil {

    public static boolean insertExcel(String fileName, String[] data) throws IOException, BiffException, WriteException {
        File xlsFile = new File(fileName);
        if(xlsFile.exists()) {
            Workbook book = Workbook.getWorkbook(xlsFile);
            WritableWorkbook workbook = Workbook.createWorkbook(xlsFile, book);
            WritableSheet[] sheets = workbook.getSheets();
            int rows = sheets[0].getRows();
            for (int row = rows; row < rows+1; row++) {
                for(int i=0; i<data.length; i++) {
                    Label label = new Label(i, row, data[i]);
                    sheets[0].addCell(label);
                }
            }
            workbook.write();
            workbook.close();
        } else {
            WritableWorkbook workbook = null;
            // 创建一个工作簿
            workbook = Workbook.createWorkbook(xlsFile);
            // 创建一个工作表
            WritableSheet sheet = workbook.createSheet("my-data", 0);
            for (int row = 0; row < 1; row++) {
                for(int i=0; i<data.length; i++) {
                    Label label = new Label(i, row, data[i]);
                    sheet.addCell(label);
                }
            }
            workbook.write();
            workbook.close();
        }
        return true;
    }

    /**
     *
     * @param fileName
     * @return
     * @throws IOException
     * @throws BiffException
     */
    public static List<String> toList(String fileName) throws IOException, BiffException {
        List<String> list = new LinkedList<>();
        File xlsFile = new File(fileName);
        if(xlsFile.exists() == false) {
            return null;
        }
        Workbook book = Workbook.getWorkbook(xlsFile);
        Sheet sheet = book.getSheet(0);
        for(int row=0; row<sheet.getRows(); row++) {
            String result = "";
            for(int column=0; column<sheet.getColumns(); column++) {
                Cell cell = sheet.getCell(column, row);
                System.out.println(cell.getContents());
                result = result + " " + cell.getContents();
            }
            list.add(result);
        }
        return list;
    }
}
