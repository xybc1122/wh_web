package com.wh.mapper.out.library.transfer;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wh.entity.out.library.transfer.entry.WhTransferOutLibraryEntry;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-06-25
 */
public interface WhTransferOutLibraryEntryMapper extends BaseMapper<WhTransferOutLibraryEntry> {
    @Select("select quantity,t_number from wh_transfer_out_library_entry where sku=#{sku}")
    List<WhTransferOutLibraryEntry> selectOutLibraryEntryBySku(String sku);

}
