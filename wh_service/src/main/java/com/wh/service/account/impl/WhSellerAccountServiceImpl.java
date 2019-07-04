package com.wh.service.account.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wh.base.JsonData;
import com.wh.base.ResponseBase;
import com.wh.entity.account.WhSellerAccount;
import com.wh.entity.dto.SellerAccountDto;
import com.wh.mapper.account.WhSellerAccountMapper;
import com.wh.service.account.IWhSellerAccountService;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-07-02
 */
@Service
public class WhSellerAccountServiceImpl extends ServiceImpl<WhSellerAccountMapper, WhSellerAccount> implements IWhSellerAccountService {
    /**
     * dto 转换工具
     */
    @Autowired
    private MapperFacade mapperFacade;

    @Autowired
    private WhSellerAccountMapper accountMapper;

    @Override
    public ResponseBase serviceGetAccountIdAndName() {
        List<WhSellerAccount> sellerAccount = this.lambdaQuery().select(WhSellerAccount::getId, WhSellerAccount::getAccount).list();
        return JsonData.setResultSuccess(mapperFacade.mapAsList(sellerAccount, SellerAccountDto.class));
    }

    @Override
    public Integer serviceSelIdByName(String account) {
        return accountMapper.selIdByName(account);
    }
}
