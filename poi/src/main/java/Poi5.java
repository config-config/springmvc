import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author hz
 * @version 1.0
 * @Function
 * @date 2020/3/13 - 21:34
 */
public class Poi5 {
    public static void main(String[] args) throws IOException {
        //定义一个新的工作簿
        Workbook workbook = new HSSFWorkbook();
        //创建第一个sheet页
        Sheet sheet = workbook.createSheet("第一个");
        //创建第一行
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(1);
        cell.setCellValue("的那款\n撒娇呢");
        //创建一个字体处理类
        Font font = workbook.createFont();
        font.setFontHeight((short) 10);
        font.setFontHeightInPoints((short) 30);
        font.setItalic(true);
        CellStyle cellStyle = workbook.createCellStyle();
        //设置字体
//        cellStyle.setFont(font);
        //设置可以换行
        cellStyle.setWrapText(true);
        //调整行高
        row.setHeightInPoints(2*sheet.getDefaultRowHeightInPoints());
        //调整单元格宽度
        sheet.autoSizeColumn(2);
        cell.setCellStyle(cellStyle);
        //创建文件输出流 指定路径
        FileOutputStream fileOutputStream = new FileOutputStream("d:\\excel2.xls");
        workbook.write(fileOutputStream);
        //关闭流
        fileOutputStream.close();
    }
}
