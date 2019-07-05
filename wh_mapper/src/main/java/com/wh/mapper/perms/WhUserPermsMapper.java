package com.wh.mapper.perms;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wh.entity.perms.WhUserPerms;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Set;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-06-17
 */
public interface WhUserPermsMapper extends BaseMapper<WhUserPerms> {


    /**
     * 通过角色 api url 去查询对应的 菜单权限
     *
     * @param rids
     * @return
     */
    @SelectProvider(type = WhUserPermsProvider.class, method = "getPermission")
    Set<String> getPermission(@Param("rids") String rids, @Param("apiUrl") String apiUrl);


    /**
     * 查询 权限配置组
     *
     * @return
     */
    @SelectProvider(type = WhUserPermsProvider.class, method = "getPermissionAndOperating")
    List<WhUserPerms> getPermissionAndOperating(@Param("entity") WhUserPerms whUserPerms, @Param("rids") String rids);


    /**
     * 查询 权限配置组
     *
     * @return
     */
    @SelectProvider(type = WhUserPermsProvider.class, method = "roleQueryPermission")
    List<WhUserPerms> roleQueryPermission(@Param("rids") String rids);


}
