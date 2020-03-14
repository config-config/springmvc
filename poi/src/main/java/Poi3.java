import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

/**
 * @author hz
 * @version 1.0
 * @Function
 * @date 2020/3/13 - 21:16
 */
public class Poi3 {
    public static void main(String[] args) throws IOException {
        //定义一个新的工作簿
        Workbook workbook = new HSSFWorkbook();
        //创建第一个sheet页
        Sheet sheet = workbook.createSheet("第一个");
        //创建第一行
        Row row = sheet.createRow(0);
        //设置行高
        row.setHeightInPoints(30);

        createCell("bbb",workbook,row,(short) 0, HSSFCellStyle.ALIGN_CENTER,HSSFCellStyle.VERTICAL_BOTTOM);
        //创建文件输出流 指定路径
        FileOutputStream fileOutputStream = new FileOutputStream("d:\\excel2.xls");
        workbook.write(fileOutputStream);
        //关闭流
        fileOutputStream.close();
    }
    private static void createCell(Object value,Workbook wb,Row r,short column,short halign,short valign) {
        Cell cell = r.createCell(column);
        cell.setCellValue(String.valueOf(value));
        CellStyle cellStyle = wb.createCellStyle();
        //设置单元格水平对齐方式
        cellStyle.setAlignment(valign);
        //设置单元格垂直对齐方式
        cellStyle.setVerticalAlignment(halign);
        //设置单元格样式
        cell.setCellStyle(cellStyle);
    }
}
