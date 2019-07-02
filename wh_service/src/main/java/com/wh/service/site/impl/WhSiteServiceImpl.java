package com.wh.service.site.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wh.base.JsonData;
import com.wh.base.ResponseBase;
import com.wh.entity.site.WhSite;
import com.wh.mapper.site.WhSiteMapper;
import com.wh.service.site.IWhSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-07-02
 */
@Service
public class WhSiteServiceImpl extends ServiceImpl<WhSiteMapper, WhSite> implements IWhSiteService {


    @Override
    public ResponseBase serviceGetSite() {
        return JsonData.setResultSuccess(this.list());
    }
}
