package com.wh.mapper.site;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wh.entity.site.WhSite;
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
public interface WhSiteMapper extends BaseMapper<WhSite> {


    /**
     * 通过 site 名查询站点 id
     *
     * @param site
     * @return
     */
    @Select("SELECT`id`FROM `wh_site` WHERE site =#{site}")
    Integer selIdByName(@Param("site") String site);


}
