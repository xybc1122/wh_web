package com.wh.service.po.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wh.base.JsonData;
import com.wh.base.ResponseBase;
import com.wh.entity.po.WhUserPermsOperating;
import com.wh.mapper.po.WhUserPermsOperatingMapper;
import com.wh.service.po.IWhUserPermsOperatingService;
import com.wh.utils.CheckUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-06-18
 */
@Service
public class WhUserPermsOperatingServiceImpl extends ServiceImpl<WhUserPermsOperatingMapper, WhUserPermsOperating>
        implements IWhUserPermsOperatingService {

    @Override
    public ResponseBase serviceSavePermsOperating(WhUserPermsOperating permsOperating) {
        if (permsOperating == null || permsOperating.getPermsOperatingList() == null ||
                permsOperating.getPermsOperatingList().size() <= 0) {
            return JsonData.setResultError("参数 is null");
        }

        boolean result = this.saveBatch(permsOperating.getPermsOperatingList());
        CheckUtils.saveResult(result);
        return JsonData.setResultSuccess("success");
    }
}
