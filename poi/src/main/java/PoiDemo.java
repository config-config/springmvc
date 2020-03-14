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
 * @date 2020/3/13 - 20:12
 */
public class PoiDemo {
    public static void main(String[] args) throws IOException {
        //定义一个新的工作簿
        Workbook workbook = new HSSFWorkbook();
        //创建第一个sheet页
        Sheet sheet = workbook.createSheet("第一个");
        //创建第一行
        Row row = sheet.createRow(0);
        //创建第一个单元格
        Cell cell = row.createCell(0);
        CreationHelper creationHelper = workbook.getCreationHelper();
        //设置单元格样式类
        CellStyle cellStyle = workbook.createCellStyle();
        //设置时间格式
        cellStyle.setDataFormat(creationHelper.createDataFormat().getFormat("yy-mm-dd hh:mm:ss"));
        //设置值
        cell.setCellValue(new Date());
        //设置样式
        cell.setCellStyle(cellStyle);
        //创建文件输出流 指定路径
        FileOutputStream fileOutputStream = new FileOutputStream("d:\\excel1.xls");
        workbook.write(fileOutputStream);
        //关闭流
        fileOutputStream.close();
    }
}
