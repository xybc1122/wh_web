package com.wh.service.out.library.transfer;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wh.base.ResponseBase;
import com.wh.entity.out.library.transfer.entry.WhTransferOutLibraryEntry;

import java.util.Map;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-06-25
 */
public interface IWhTransferOutLibraryEntryService extends IService<WhTransferOutLibraryEntry> {


    /**
     * 修改/新增/删除 调拨子表
     *
     * @return
     */
    ResponseBase serviceUpOutLibrary(Map<String, Object> objectMap);
}
