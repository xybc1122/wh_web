package com.wh.mapper.api;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wh.entity.api.WhUserApi;
import com.wh.entity.dto.UserApiDto;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-07-11
 */
public interface WhUserApiMapper extends BaseMapper<WhUserApi> {


    /**
     * 通过权限列表id 去查询可以显示的操作api路径
     *
     * @return
     */
    @SelectProvider(type = WhUserApiProvider.class, method = "selApiInfo")
    List<UserApiDto> selApiInfo(@Param("rids") String rids);


}
