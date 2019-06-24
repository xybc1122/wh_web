package com.wh.service.fba;


import com.baomidou.mybatisplus.extension.service.IService;
import com.wh.base.ResponseBase;
import com.wh.entity.fba.WhFbaStocking;

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
    ResponseBase serviceSelListWhFbaStocking(WhFbaStocking whFbaStocking);

    /**
     * 修改 fba 备货
     *
     * @param whFbaStocking
     * @return
     */
    ResponseBase serviceUpWhFbaStocking(WhFbaStocking whFbaStocking);
}
