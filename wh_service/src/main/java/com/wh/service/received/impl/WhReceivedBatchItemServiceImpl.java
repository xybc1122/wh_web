package com.wh.service.received.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wh.entity.received.WhReceivedBatchItem;
import com.wh.mapper.received.WhReceivedBatchItemMapper;
import com.wh.service.received.WhReceivedBatchItemService;
import org.springframework.beans.factory.annotation.Autowired;

public class WhReceivedBatchItemServiceImpl extends ServiceImpl<WhReceivedBatchItemMapper, WhReceivedBatchItem> implements WhReceivedBatchItemService {

    @Autowired
    private WhReceivedBatchItemMapper whReceivedBatchItemMapper;
    @Override
    public int selectStockByAsin(String asin) {
        //WhReceivedBatchItem whReceivedBatchItem=whReceivedBatchItemMapper.selectStockByAsin(asin);
       /* whReceivedBatchItem.getStatus();
        if(whReceivedBatchItem.getStatus()==3){
            return whReceivedBatchItem.getStockNumber();
        }else{
            return 0;
        }*/
       return 0;
    }
}
