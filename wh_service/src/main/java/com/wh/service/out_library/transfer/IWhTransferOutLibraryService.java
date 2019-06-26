package com.wh.service.out_library.transfer;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wh.base.ResponseBase;
import com.wh.entity.out_library.transfer.WhTransferOutLibrary;

import java.util.Map;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-06-25
 */
public interface IWhTransferOutLibraryService extends IService<WhTransferOutLibrary> {

    /**
     * 查询调拨出库信息
     *
     * @param outLibrary
     * @return
     */
    ResponseBase serviceSelOutLibraryInfo(WhTransferOutLibrary outLibrary);


    /**
     * 删除调拨出库信息
     *
     * @param objectMap
     * @return
     */
    ResponseBase serviceDelOutLibraryInfo(Map<String, Object> objectMap);

    /**
     * 标记发货更新状态
     *
     * @return
     */
    ResponseBase serviceUpOutLibraryStatus(WhTransferOutLibrary outLibrary);

    /**
     * 新增调拨出库 AND sku条目信息
     *
     * @param outLibrary
     * @return
     */
    ResponseBase serviceSaveOutLibraryInfo(WhTransferOutLibrary outLibrary);

}
