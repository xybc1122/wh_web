package com.wh.mapper.account;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wh.entity.account.WhSellerAccount;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-07-02
 */
public interface WhSellerAccountMapper extends BaseMapper<WhSellerAccount> {


    /**
     * 通过 账号 名查询账号 id
     *
     * @param account
     * @return
     */
    @Select("SELECT`id`FROM `wh_seller_account` WHERE account =#{account}")
    Integer selIdByName(@Param("account") String account);
}
