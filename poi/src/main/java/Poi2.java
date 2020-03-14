import org.apache.poi.hssf.extractor.ExcelExtractor;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author hz
 * @version 1.0
 * @Function
 * @date 2020/3/13 - 21:13
 */
public class Poi2 {
    public static void main(String[] args) throws IOException {
        //创建一个输入流 读取文件
        FileInputStream fs = new FileInputStream("d:\\excel1.xls");
        POIFSFileSystem pfs = new POIFSFileSystem(fs);
        HSSFWorkbook wb = new HSSFWorkbook(pfs);
        ExcelExtractor excelExtractor = new ExcelExtractor(wb);
        excelExtractor.setIncludeSheetNames(false);//不打印sheet页的名字
        System.out.println(excelExtractor.getText());
    }
}
