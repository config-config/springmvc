import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author hz
 * @version 1.0
 * @Function
 * @date 2020/3/13 - 21:29
 */
public class Poi4 {
    public static void main(String[] args) throws IOException {
        //定义一个新的工作簿
        Workbook workbook = new HSSFWorkbook();
        //创建第一个sheet页
        Sheet sheet = workbook.createSheet("第一个");
        //创建第一行
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(1);
        cell.setCellValue("合并");
        //起始行  结束行  起始列  结束列
        sheet.addMergedRegion(new CellRangeAddress(1,5,1,2));
        //创建文件输出流 指定路径
        FileOutputStream fileOutputStream = new FileOutputStream("d:\\excel2.xls");
        workbook.write(fileOutputStream);
        //关闭流
        fileOutputStream.close();
    }
}
