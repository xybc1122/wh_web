package com.wh.service.out_library.fba;


import com.baomidou.mybatisplus.extension.service.IService;
import com.wh.base.ResponseBase;
import com.wh.entity.out_library.fba.WhFbaStocking;
import org.springframework.validation.BindingResult;

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

    /**
     * 系只能 fba 备货
     *
     * @param whFbaStocking
     * @return
     */
    ResponseBase serviceSaveWhFbaStocking(WhFbaStocking whFbaStocking, BindingResult result);
}
