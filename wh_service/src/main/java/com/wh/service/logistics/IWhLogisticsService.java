package com.wh.service.logistics;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wh.base.ResponseBase;
import com.wh.entity.logistics.WhLogistics;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-07-02
 */
public interface IWhLogisticsService extends IService<WhLogistics> {

    /**
     * 查询运输方式 id 跟名称
     *
     * @return
     */
    ResponseBase serviceGetLogisticsIdAndName();
}
