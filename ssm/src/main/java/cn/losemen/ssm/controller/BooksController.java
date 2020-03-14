package cn.losemen.ssm.controller;

import cn.losemen.ssm.service.BooksService;
import cn.losemen.ssm.vo.BooksVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * @author hz
 * @version 1.0
 * @Function
 * @date 2020/3/12 - 17:32
 */
@Controller
public class BooksController {
    @Autowired
    private BooksService booksService;

    public void setBooksService(BooksService booksService) {
        this.booksService = booksService;
    }
    @RequestMapping("/allbook")
    public String selAll(Model model) {
        List<BooksVO> bl = booksService.selAll();
        model.addAttribute("bl",bl);
        return "book";
    }
    @RequestMapping("/poibook")
    @ResponseBody
    public String poiBook(HttpServletResponse res) throws IOException {
        List<BooksVO> bl = booksService.selAll();
        FileInputStream fis = new FileInputStream("d:\\excel.xls");
        POIFSFileSystem pfs = new POIFSFileSystem(fis);
        HSSFWorkbook wb = new HSSFWorkbook(pfs);
        HSSFSheet sheetAt = wb.getSheetAt(0);
        //获取列数
        short cells = sheetAt.getRow(0).getLastCellNum();
        int rowIndex = 1;
        for (BooksVO b : bl) {
            //创建行
            HSSFRow row = sheetAt.createRow(rowIndex++);
            for(int i =0;i<=cells;i++) {
                row.createCell(i).setCellValue(1);
            }
        }
        FileOutputStream fos = new FileOutputStream("d:\\excel1.xls");
        wb.write(fos);
        //关闭流
        fos.close();
        fis.close();
        return "下载成功";
    }

    @RequestMapping("/jsonSelAll")
    @ResponseBody
    public String jsonSelAll() throws JsonProcessingException {
        //创建一个jackson的对象映射器，用来解析数据
        ObjectMapper mapper = new ObjectMapper();
        List<BooksVO> bl = booksService.selAll();
        //将我们的对象解析成为json格式
        String str = mapper.writeValueAsString(bl);
        //由于@ResponseBody注解，这里会将str转成json格式返回；
        return str;
    }
}
