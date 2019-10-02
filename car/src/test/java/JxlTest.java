import cn.smileyan.car.util.ExcelUtil;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JxlTest {
//    public static void main(String[] args) throws WriteException, IOException, BiffException {
//        File xlsFile = new File("d:\\jxl.xls");
//        if(xlsFile.exists()) {
//            System.out.println("exist");
//            Workbook book = Workbook.getWorkbook(xlsFile);
//            WritableWorkbook workbook = Workbook.createWorkbook(xlsFile, book);
//            WritableSheet[] sheets = workbook.getSheets();
//            int rows = sheets[0].getRows();
//            for (int row = rows; row < rows+5; row++) {
//                for (int col = 0; col < 10; col++) {
//                    // 向工作表中添加数据
//                    sheets[0].addCell(new Label(col, row, "data" + row + col));
//                }
//            }
//            workbook.write();
//            workbook.close();
//        } else {
//            System.out.println("not ");
//            WritableWorkbook workbook = null;
//            // 创建一个工作簿
//            workbook = Workbook.createWorkbook(xlsFile);
//            // 创建一个工作表
//            WritableSheet sheet = workbook.createSheet("sheet1", 0);
//            for (int row = 0; row < 5; row++) {
//                for (int col = 0; col < 10; col++) {
//                    // 向工作表中添加数据
//                    sheet.addCell(new Label(col, row, "data" + row + col));
//                }
//            }
//            workbook.write();
//            workbook.close();
//        }
//
//    }
public static void main(String[] args) throws IOException, BiffException {
    List<String> strings = ExcelUtil.toList("my-data.xls");
}
}
