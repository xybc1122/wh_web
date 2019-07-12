package com.wh.service.file.impl;

import com.wh.base.JsonData;
import com.wh.base.ResponseBase;
import com.wh.entity.out.library.fba.WhFbaStocking;
import com.wh.entity.out.library.fba.entry.WhFbaStockingEntry;
import com.wh.entity.upload.WhUserUpload;
import com.wh.exception.LsException;
import com.wh.service.account.IWhSellerAccountService;
import com.wh.service.file.FileDealWithService;
import com.wh.service.out.library.fba.IWhFbaStockingService;
import com.wh.service.site.IWhSiteService;
import com.wh.service.template.IWhTemplateService;
import com.wh.service.upload.IWhUserUploadService;
import com.wh.utils.CollectionUtils;
import com.wh.utils.JsonUtils;
import com.wh.utils.StrUtils;
import com.wh.utils.excel.XlsUtils;
import com.wh.utils.excel.ExcelTool;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;
import java.util.concurrent.Future;

/**
 * @ClassName FileDealWithServiceImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/7/1 15:03
 **/
@Service
public class FileDealWithServiceImpl implements FileDealWithService {

    @Autowired
    private IWhUserUploadService userUploadService;

    @Autowired
    private IWhFbaStockingService stockingService;

    @Autowired
    private IWhSiteService siteService;
    @Autowired
    private IWhSellerAccountService accountService;

    @Autowired
    private IWhTemplateService templateService;


    @Override
    public List<ResponseBase> serviceFileDealWith(WhUserUpload upload) {
        List<ResponseBase> responseBaseList = new ArrayList<>();
        if (upload == null || upload.getUploadSuccessList() == null || upload.getUploadSuccessList().size() <= 0) {
            throw new LsException("处理数据为空");
        }
        int baseNum = upload.getUploadSuccessList().size();
        try {
            for (int i = 0; i < baseNum; i++) {
                WhUserUpload userUpload = upload.getUploadSuccessList().get(i);
                int fileIndex = userUpload.getName().lastIndexOf(".");
                String typeFile = userUpload.getName().substring(fileIndex + 1);
                switch (typeFile) {
                    case "xlsx":
                        //这里写处理xls 文件的逻辑
                        ResponseBase responseBase;
                        responseBase = importXls(userUpload).get();
                        responseBaseList.add(responseBase);
                        break;
                    default:
                        throw new LsException("不是xlsx文件");
                }
            }
            return responseBaseList;

        } catch (Exception e) {
            e.printStackTrace();
            throw new LsException("数据导入异常");
        }
    }


    /**
     * 处理xlis表
     *
     * @return
     * @throws Exception
     */

    @Transactional
    @Async("executor")
    public Future<ResponseBase> importXls(WhUserUpload upload) throws Exception {
        /**
         * 多线程返回接收
         */
        return new AsyncResult<>(threadXls(upload.getUuidName()
                , upload.getFilePath(), upload.getId()
        ));
    }


    /**
     * 处理xls 表 封装
     */
    @Transactional
    public ResponseBase threadXls(String uuIdName, String saveFilePath, Long id) throws
            Exception {
        // 开始时间
        Long begin = new Date().getTime();
        String filePath = saveFilePath + uuIdName;

        //判断文件类型 fileType ()
        try (FileInputStream in = new FileInputStream(filePath);
             Workbook wb = XlsUtils.fileType(in, new File(filePath))) {
            if (wb == null) {
                //删除文件
                //返回错误信息
                return setErrorInfo(id, "不是excel文件", null);
            }
            //获取xls里第一行表头 这里可以检验表头
            List<String> xlsListHead = XlsUtils.getXlsHead(wb);

//            //对比表头
//            boolean isFlg = CollectionUtils.eqOrderList(xlsListHead, sqlHead);
//
//            //如果表头对比失败
//            if (!isFlg) {
//                //删除文件
//                return setErrorInfo(id, "导入表头不一致", JsonUtils.json(sqlHead, xlsListHead));
//            }

            //获取xls表体数据
            ExcelTool<List<List<Map<String, String>>>> excelTool1 = new ExcelTool<>();
            List<List<Map<String, String>>> excelMapVal = excelTool1.getExcelMapVal(filePath, 1);
            if (excelMapVal == null || excelMapVal.size() <= 0) {
                //删除文件
                return setErrorInfo(id, "文件内容为空", null);
            }

//            switch(){
//
//            }
            //这里返回逻辑 TODO 这里后期如果处理的多了要增加逻辑
            return setFbaStocking(excelMapVal, id);
        }
    }


    public ResponseBase setFbaStocking(List<List<Map<String, String>>> excelMapVal, Long id) {

        List<WhFbaStocking> stockingList = new ArrayList<>();
        List<WhFbaStockingEntry> entry = new ArrayList<>();

        //这层循环是获得第一页的表
        for (List<Map<String, String>> lMap : excelMapVal) {
            //获得对象
            WhFbaStocking fbaStocking = new WhFbaStocking();
            WhFbaStockingEntry stockingEntry = new WhFbaStockingEntry();

            //这层循环获得本页的表
            for (Map<String, String> map : lMap) {
                for (String key : map.keySet()) {
                    String value = map.get(key);
                    switch (key) {
                        case "账号":
                            fbaStocking.setAccountId(accountService.serviceSelIdByName(StrUtils.cStr(value)));
                            break;
                        case "站点":
                            fbaStocking.setSiteId(siteService.serviceSelIdByName(StrUtils.cStr(value)));
                            break;
                        case "FNSKU":
                            stockingEntry.setFnSku(StrUtils.cStr(value));
                            break;
                        case "数量":
                            stockingEntry.setQuantity(StrUtils.cInt(value));
                            break;
                        case "单据日期":
                            fbaStocking.setDocumentTime(StrUtils.cLon(value));
                            break;
                        case "单据号":
                            fbaStocking.setRecordNo(StrUtils.cStr(value));
                            break;
                        case "recordNum":
                            fbaStocking.setRecordNum(StrUtils.cStr(value));
                            stockingEntry.setRecordNum(StrUtils.cStr(value));
                            break;
                        case "运送时间":
                            fbaStocking.setDocumentTime(StrUtils.cLon(value));
                            break;
                        case "跟踪号":
                            stockingEntry.setTrackingNumber(StrUtils.cStr(value));
                            break;
                        case "规格":
                            stockingEntry.setSpecification(StrUtils.cStr(value));
                            break;
                        case "SKU":
                            stockingEntry.setSku(StrUtils.cStr(value));
                            break;
                    }
                }
            }
            stockingList.add(fbaStocking);
            entry.add(stockingEntry);
        }

        //TODO 这里去重   这里后期都要封装掉
        Map<String, WhFbaStocking> map = new HashMap<>();
        for (WhFbaStocking stocking : stockingList) {
            map.put(stocking.getRecordNum(), stocking);
        }
        stockingList.clear();
        stockingList.addAll(map.values());

        for (WhFbaStocking stocking : stockingList) {
            List<WhFbaStockingEntry> newEntry = new ArrayList<>();
            for (WhFbaStockingEntry stockingEntry : entry) {
                if (stocking.getRecordNum().equals(stockingEntry.getRecordNum())) {
                    newEntry.add(stockingEntry);
                }
            }
            stocking.setEntry(newEntry);
        }
        //这里存入数据库
        if (stockingService.serviceXlsSaveWhFbaStocking(stockingList)) {
            //更新导入状态 success
            upMsg(null, id, 0);
            return JsonData.setResultSuccess("success");
        }
        return JsonData.setResultError("error");
    }


    //这里设置对象
//            if (xlsListHead.get(j).equals("账号")) {
//                fbaStocking.setAccountId(accountService.serviceSelIdByName(StrUtils.cStr(cell)));
//            } else if (xlsListHead.get(j).equals("站点")) {
//
//                fbaStocking.setSiteId(siteService.serviceSelIdByName(StrUtils.cStr(cell)));
//
//            } else if (xlsListHead.get(j).equals("FNSKU")) {
//                stockingEntry.setFnSku(StrUtils.cStr(cell));
//
//            } else if (xlsListHead.get(j).equals("数量")) {
//                stockingEntry.setQuantity(StrUtils.cInt(cell));
//
//            } else if (xlsListHead.get(j).equals("单据日期")) {
//                fbaStocking.setDocumentTime(StrUtils.cLon(cell));
//
//            } else if (xlsListHead.get(j).equals("单据号")) {
//                fbaStocking.setRecordNo(StrUtils.cStr(cell));
//
//            } else if (xlsListHead.get(j).equals("recordNum")) {
//                fbaStocking.setRecordNum(StrUtils.cStr(cell));
//                stockingEntry.setRecordNum(StrUtils.cStr(cell));
//
//            } else if (xlsListHead.get(j).equals("运送时间")) {
//                fbaStocking.setDocumentTime(StrUtils.cLon(cell));
//
//            } else if (xlsListHead.get(j).equals("跟踪号")) {
//                stockingEntry.setTrackingNumber(StrUtils.cStr(cell));
//
//            } else if (xlsListHead.get(j).equals("规格")) {
//                stockingEntry.setSpecification(StrUtils.cStr(cell));
//            }


    /**
     * 错误更新信息
     *
     * @param recordingId 文件记录表ID
     * @param msg         错误消息
     * @param data        错误数据
     */
    private ResponseBase setErrorInfo(Long recordingId, String msg, String data) {
        //更新上传信息
        upMsg(msg, recordingId, 1);
        if (StringUtils.isEmpty(data)) {
            return JsonData.setResultError(msg);
        }
        return JsonData.setResultError(msg + data);
    }

    /**
     * 封装更新失败信息
     *
     * @param msg
     */
    private void upMsg(String msg, Long id, Integer dwStatus) {
        WhUserUpload userUpload = new WhUserUpload();
        userUpload.setId(id);
        userUpload.setDwStatus(dwStatus);
        userUpload.setRemark(msg);
        userUploadService.updateById(userUpload);
    }

}
