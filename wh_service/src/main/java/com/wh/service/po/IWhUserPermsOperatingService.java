package com.wh.service.po;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wh.base.ResponseBase;
import com.wh.entity.po.WhUserPermsOperating;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-06-18
 */
public interface IWhUserPermsOperatingService extends IService<WhUserPermsOperating> {


    /**
     * 添加操作权限下面的 增删改信息
     *
     * @param permsOperating
     * @return
     */
    ResponseBase serviceSavePermsOperating(WhUserPermsOperating permsOperating);

}
