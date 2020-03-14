package cn.losemen.ssm.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hz
 * @version 1.0
 * @Function
 * @date 2020/3/12 - 17:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BooksVO {
    private int bookID;
    private String bookName;
    private int bookCounts;
    private String detail;
}
