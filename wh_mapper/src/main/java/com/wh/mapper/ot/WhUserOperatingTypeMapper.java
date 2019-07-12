package com.wh.mapper.ot;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wh.entity.ot.WhUserOperatingType;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.Set;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-07-11
 */
public interface WhUserOperatingTypeMapper extends BaseMapper<WhUserOperatingType> {


    /**
     * 通过角色id 去查询可以显示的操作权限
     *
     * @return
     */
    @SelectProvider(type = WhUserOperatingTypeProvider.class, method = "selWhUserOperatingType")
    Set<WhUserOperatingType> selWhUserOperatingType(@Param("rids") String rids);

    /**
     * 通过角色 api url 去查询对应的操作权限
     *
     * @return
     */
    @SelectProvider(type = WhUserOperatingTypeProvider.class, method = "selOperatingType")
    Set<String> selOperatingType(@Param("apiUrl") String apiUrl);


}
