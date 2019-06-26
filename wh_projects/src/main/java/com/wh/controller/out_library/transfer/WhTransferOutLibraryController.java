package com.wh.controller.out_library.transfer;


import com.wh.base.ResponseBase;
import com.wh.entity.out_library.transfer.WhTransferOutLibrary;
import com.wh.service.out_library.transfer.IWhTransferOutLibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-06-25
 */
@RestController
@RequestMapping("/api/v1/wh-transfer-out-library")
public class WhTransferOutLibraryController {


    @Autowired
    private IWhTransferOutLibraryService outLibraryService;

    /**
     * 查询调拨出库跟条目
     *
     * @return
     */
    @PostMapping("/findByTransferInfo")
    public ResponseBase findByTransferInfo(@RequestBody WhTransferOutLibrary outLibrary) {
        return outLibraryService.serviceSelOutLibraryInfo(outLibrary);
    }

    /**
     * 删除调拨出库跟条目
     *
     * @return
     */
    @DeleteMapping("/delTransferInfo")
    public ResponseBase delTransferInfo(@RequestBody Map<String, Object> objectMap) {
        return outLibraryService.serviceDelOutLibraryInfo(objectMap);
    }

    /**
     * 新增调拨出库跟条目
     */
    @PostMapping("/saveTransferInfo")
    public ResponseBase saveTransferInfo(@RequestBody WhTransferOutLibrary outLibrary) {

        return outLibraryService.serviceSaveOutLibraryInfo(outLibrary);
    }

    /**
     * 更新标记发货
     */
    @PutMapping("/upTransferInfo")
    public ResponseBase upTransferInfo(@RequestBody WhTransferOutLibrary outLibrary) {
        return outLibraryService.serviceUpOutLibraryStatus(outLibrary);
    }
}
