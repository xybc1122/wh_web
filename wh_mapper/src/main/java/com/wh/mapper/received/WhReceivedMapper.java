package com.wh.mapper.received;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wh.entity.received.WhReceived;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yyk
 * @date 2019/7/10 16:49
 * @description 查询入库的相关信息
 */
@Repository
public interface WhReceivedMapper extends BaseMapper<WhReceived> {

    @Results(id = "ReceicedMap" ,value = {
            @Result(column = "id",property = "id"),
            @Result(column = "no",property = "no"),
            @Result(column = "foreign_no",property = "foreignNo"),
            @Result(column = "user_id",property = "userId"),
            @Result(column = "created_at",property = "createdAt")
    })
    @Select("select id,no,foreign_no,user_id,created_at from wh_received where id in (select received_id from wh_received_batch_item where asin=#{sku})")
    List<WhReceived> findReceivedBySku(String sku);

    @ResultMap("ReceicedMap")
    @Select("select id,no,foreign_no,user_id,created_at from wh_received where id=(select received_id from wh_received_batch_relation where batch_id=#{id})")
    WhReceived selectWhReceivedById(int id);


}
