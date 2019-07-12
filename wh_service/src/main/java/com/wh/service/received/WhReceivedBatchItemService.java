package com.wh.service.received;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wh.entity.received.WhReceivedBatchItem;
import org.springframework.stereotype.Service;

@Service
public interface WhReceivedBatchItemService extends IService<WhReceivedBatchItem> {
    int selectStockByAsin(String asin);
}
