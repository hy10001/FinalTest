package cn.lanqiao.finalTest.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageHelper<T> {
    private int pageNum;//当前页码
    private int pageSize;//每页显示条数
    private List<T> list;//数据
    private int pages;//总页数
}
