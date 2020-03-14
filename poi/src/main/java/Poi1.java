import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author hz
 * @version 1.0
 * @Function
 * @date 2020/3/13 - 20:50
 */
public class Poi1 {
    public static void main(String[] args) throws IOException {
        //创建一个输入流 读取文件
        FileInputStream fs = new FileInputStream("d:\\excel1.xls");
        POIFSFileSystem pfs = new POIFSFileSystem(fs);
        HSSFWorkbook wb = new HSSFWorkbook(pfs);
        //获取第一个sheet页
        HSSFSheet sheetAt = wb.getSheetAt(0);
        if(sheetAt == null) {
            return ;
        }
        //遍历行
        for(int row = 0; row<=sheetAt.getLastRowNum();row++) {
            HSSFRow r = sheetAt.getRow(row);
            if(r == null) {
                continue;
            }
            //遍历cell
            for(int cell=0;cell<=r.getLastCellNum();cell++) {
                HSSFCell c = r.getCell(cell);
                if(c == null) {
                    continue;
                }
                System.out.print(getValue(c) + " ");
            }
            System.out.println();

        }
    }
    public static String getValue(HSSFCell c) {
        if(c.getCellType() == HSSFCell.CELL_TYPE_BOOLEAN){
            return String.valueOf(c.getBooleanCellValue());
        }else if(c.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
            return String.valueOf(c.getNumericCellValue());
        }else {
            return String.valueOf(c.getStringCellValue());
        }
    }
}
