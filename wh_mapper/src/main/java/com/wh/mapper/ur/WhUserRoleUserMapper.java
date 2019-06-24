package com.wh.mapper.ur;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wh.entity.ur.WhUserRoleUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 用户跟角色表 Mapper 接口
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-06-14
 */
public interface WhUserRoleUserMapper extends BaseMapper<WhUserRoleUser> {


//    /**
//     * 查询一个用户下的 所有角色
//     *
//     * @param uid
//     * @return
//     */
//    @Select("SELECT `r_id` FROM `wh_user_role_user` WHERE u_id=#{uid} AND is_delete=0")
//    List<Integer> selRids(@Param("uid") Long uid);

}
