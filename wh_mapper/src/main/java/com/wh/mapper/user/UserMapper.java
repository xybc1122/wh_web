package com.wh.mapper.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wh.entity.dto.UserDto;
import com.wh.entity.user.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * @ClassName UserMapper
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/6/11 14:42
 **/
public interface UserMapper extends BaseMapper<UserInfo> {

    /**
     * 查询用户 集合
     *
     * @param UserDto
     * @return
     */
    @SelectProvider(type = UserProvider.class, method = "findUsers")
    List<UserInfo> selByUserList(UserDto UserDto);

    /**
     * 通过唯一用户名去查询 是否被删除的单个用户
     *
     * @param userName
     * @return
     */
    @Select("SELECT `uid` FROM `wh_user_info` WHERE user_name=#{userName} AND is_delete=0")
    Long selUserIsDelete(@Param("userName") String userName);

}
