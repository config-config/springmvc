package cn.losemen.ssm.service;

import cn.losemen.ssm.mapper.BookMapper;
import cn.losemen.ssm.vo.BooksVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hz
 * @version 1.0
 * @Function
 * @date 2020/3/12 - 17:33
 */
@Service
public class BooksService {
    @Autowired
    private BookMapper bookMapper;
    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }
    public List<BooksVO> selAll() {
        return bookMapper.selAll();
    }
}
