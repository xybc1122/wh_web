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
     * 通过唯一用户名去查询 是否有重名
     *
     * @param userName
     * @return
     */
    @Select("SELECT `uid` FROM `wh_user_info` WHERE user_name=#{userName} AND is_delete=0")
    Long selUserIsDelete(@Param("userName") String userName);

    /**
     * 通过角色名字去查找用户信息
     *
     * @param rName
     * @return
     */
    @Select("SELECT u.`uid`,u.`user_name`FROM `wh_user_info` AS u\n" +
            "LEFT JOIN (SELECT u_id,r_id FROM `wh_user_role_user` WHERE is_delete=0) AS ru ON ru.`u_id`=u.`uid`\n" +
            "LEFT JOIN (SELECT r_id,r_name FROM `wh_user_role` WHERE is_delete=0) AS r ON r.`r_id`=ru.`r_id`\n" +
            "WHERE r.`r_name`=#{rName}")
    List<UserInfo> selUserByRName(@Param("rName") String rName);

}
