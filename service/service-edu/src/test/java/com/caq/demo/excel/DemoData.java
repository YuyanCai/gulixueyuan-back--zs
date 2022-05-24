package com.caq.demo.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class DemoData {
    //设置excel表头名称
    //index代表列的索引
    @ExcelProperty(value = "一级分类",index = 0)
    private String sno;

    @ExcelProperty(value = "二级分类",index = 1)
    private String sname;
}
