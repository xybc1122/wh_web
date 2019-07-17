package com.wh.mapper.received;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wh.entity.received.WhReceivedBatch;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author yyk
 * @date 2019/7/12 12:37
 * @description 批次子类
 */
@Repository
public interface WhReceivedBatchMapper extends BaseMapper<WhReceivedBatch> {

    @Results(id="ReceivedBatchMap",value = {
            @Result(column = "id",property = "id"),
            @Result(column = "status",property = "status"),
            @Result(column = "qc_finish",property = "qcFinshed"),
            @Result(column = "total_number",property = "totalNumber"),
            @Result(column = "tally_uid",property = "tallyUid"),
            @Result(column = "tally_date",property = "tallyDate")
    })
    @Select("select id,status,qc_finish,total_number,tally_uid,tally_date from wh_received_batch where batch_no=#{batchNo}")
    WhReceivedBatch selectBatchByBatchNo(String batchNo);

}
