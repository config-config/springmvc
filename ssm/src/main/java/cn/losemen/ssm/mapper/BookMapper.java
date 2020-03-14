package cn.losemen.ssm.mapper;

import cn.losemen.ssm.vo.BooksVO;

import java.util.List;

/**
 * @author hz
 * @version 1.0
 * @Function
 * @date 2020/3/12 - 17:30
 */
public interface BookMapper {
    public List<BooksVO> selAll();
}
