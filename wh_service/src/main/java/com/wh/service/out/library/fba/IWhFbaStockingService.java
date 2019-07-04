package com.wh.service.out.library.fba;


import com.baomidou.mybatisplus.extension.service.IService;
import com.wh.base.ResponseBase;
import com.wh.entity.out.library.fba.WhFbaStocking;
import org.springframework.validation.BindingResult;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-06-21
 */
public interface IWhFbaStockingService extends IService<WhFbaStocking> {


    /**
     * 查询 fba 备货
     *
     * @param whFbaStocking
     * @return
     */
    List<WhFbaStocking> serviceSelListWhFbaStocking(WhFbaStocking whFbaStocking);

    /**
     * 修改 fba 备货
     *
     * @param whFbaStocking
     * @return
     */
    ResponseBase serviceUpWhFbaStocking(WhFbaStocking whFbaStocking);

    /**
     * 新增 fba 备货
     *
     * @param whFbaStocking
     * @return
     */
    ResponseBase serviceSaveWhFbaStocking(WhFbaStocking whFbaStocking, BindingResult result);


    /**
     * xls文件新增 fba 备货
     *
     * @param whFbaStocking
     * @return
     */
    boolean serviceXlsSaveWhFbaStocking(List<WhFbaStocking> whFbaStocking);
}
