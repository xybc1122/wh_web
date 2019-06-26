package com.wh.mapper.out_library.transfer;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wh.entity.out_library.transfer.WhTransferOutLibrary;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-06-25
 */
public interface WhTransferOutLibraryMapper extends BaseMapper<WhTransferOutLibrary> {


    /**
     * 查询调拨出库信息
     *
     * @param outLibrary
     * @return
     */
    @SelectProvider(type = WhTransferOutLibraryProvider.class, method = "selOutLibraryInfo")
    List<WhTransferOutLibrary> selOutLibraryInfo(WhTransferOutLibrary outLibrary);


    /**
     * 查询 执行流程状态
     *
     * @return
     */
    @Select("SELECT `execution_status` FROM `wh_transfer_out_library` WHERE t_number=#{tNumber}")
    Integer selExecutionStatus(@Param("tNumber") String tNumber);

}
