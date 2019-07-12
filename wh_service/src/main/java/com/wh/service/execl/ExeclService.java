package com.wh.service.execl;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ExeclService
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/7/10 12:19
 **/
public interface ExeclService {


    void exportTemplate(List<Map<String, Object>> titleList, String title, String path, int colWidth, int rowHeight);

}
