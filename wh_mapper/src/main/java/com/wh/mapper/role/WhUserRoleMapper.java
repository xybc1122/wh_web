package com.wh.mapper.role;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wh.entity.role.WhUserRole;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Set;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-06-11
 */
public interface WhUserRoleMapper extends BaseMapper<WhUserRole> {

    /**
     * 通过角色查询 权限组
     *
     * @return
     */
    @SelectProvider(type = WhUserRoleProvider.class, method = "selRoleAndPerm")
    List<WhUserRole> selRoleAndPerm(@Param("entity") WhUserRole role, @Param("rids") String rids);


    @SelectProvider(type = WhUserRoleProvider.class, method = "selRole")
    List<WhUserRole> selRole(@Param("uid") Long uid, @Param("tid") Integer tid);

    @SelectProvider(type = WhUserRoleProvider.class, method = "selSignList")
    Set<String> selSignList(String rids);
}
