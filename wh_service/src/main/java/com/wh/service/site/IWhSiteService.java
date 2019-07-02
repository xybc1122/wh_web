package com.wh.service.site;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wh.base.ResponseBase;
import com.wh.entity.site.WhSite;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-07-02
 */
public interface IWhSiteService extends IService<WhSite> {

    /**
     * 查询站点
     *
     * @return
     */
    ResponseBase serviceGetSite();

}
