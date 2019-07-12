package com.wh.service.execl.impl;

import com.wh.exception.LsException;
import com.wh.service.execl.ExeclService;
import com.wh.utils.excel.Column;
import com.wh.utils.excel.ExcelTool;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ExeclServiceImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/7/10 12:20
 **/
@Service
public class ExeclServiceImpl implements ExeclService {
    @Override
    public void exportTemplate(List<Map<String, Object>> titleList, String title, String path, int colWidth, int rowHeight) {
        try {
            ExcelTool<Map<String, Object>> excelTool = new ExcelTool<>(title, colWidth, rowHeight);
            List<Column> titleData = excelTool.columnTransformer(titleList, "id", "pid", "content", "file_name", "0");
            excelTool.exportExcel(titleData, new ArrayList<>(), path, true, false);
        } catch (Exception e) {
            e.printStackTrace();
            throw new LsException("导出模板异常");
        }
    }
}
