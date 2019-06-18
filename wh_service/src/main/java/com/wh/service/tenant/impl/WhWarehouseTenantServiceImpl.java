package com.wh.service.tenant.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wh.service.tenant.IWhWarehouseTenantService;
import com.wh.mapper.tenant.WhWarehouseTenantMapper;
import com.wh.entity.tenant.WhWarehouseTenant;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 租户表 服务实现类
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-06-11
 */
@Service
public class WhWarehouseTenantServiceImpl extends ServiceImpl<WhWarehouseTenantMapper, WhWarehouseTenant> implements IWhWarehouseTenantService {

}
