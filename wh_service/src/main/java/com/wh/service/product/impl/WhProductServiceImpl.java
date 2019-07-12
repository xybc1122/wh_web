package com.wh.service.product.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wh.base.ResponseBase;
import com.wh.customize.PermissionCheck;
import com.wh.entity.dto.ProductDto;
import com.wh.entity.position.WhPosition;
import com.wh.entity.position.WhPostionSku;
import com.wh.entity.product.WhProduct;
import com.wh.entity.product.WhProductSku;
import com.wh.entity.received.WhReceivedBatchItem;
import com.wh.mapper.position.WhPositionMapper;
import com.wh.mapper.position.WhPostionSkuMapper;
import com.wh.mapper.product.WhProductMapper;
import com.wh.mapper.received.WhReceivedBatchItemMapper;
import com.wh.service.product.IWhProductService;
import com.wh.service.product.IWhProductSkuService;
import com.wh.toos.Constants;
import com.wh.utils.PageInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class WhProductServiceImpl  extends ServiceImpl<WhProductMapper, WhProduct> implements IWhProductService{

    @Autowired
    private WhProductMapper whProductMapper;
    @Autowired
    private IWhProductSkuService iWhProductSkuService;
    @Autowired
    private WhPostionSkuMapper whPostionSkuMapper;
    @Autowired
    private WhPositionMapper whPositionMapper;
    /* @Autowired
     private WhPositionService whPositionService;*/
  /*  @Autowired
    private WhPostionSkuService whPostionSkuService;*/
   /* @Autowired
    private WhReceivedBatchItemService whReceivedBatchItemService;*/
    @Autowired
    private WhReceivedBatchItemMapper whReceivedBatchItemMapper;
    //List<ProductDto> productDtos=new ArrayList<>();
    List<WhProduct> products;
    @Override
    @PermissionCheck(type = Constants.MODIFY)
    @Transactional
    public List<ProductDto> selectProduct(String type, String content,int pageSize,int currentPage) {
        PageInfoUtils.setPage(pageSize,currentPage);
        List<ProductDto> list=new ArrayList<>();
        List<ProductDto> productDtos=new ArrayList<>();
        //拆分传过来的条件
        String[] datas=content.split(",");
        if(datas.length==0)
            throw new RuntimeException("查询的条件为空");

        //根据条件查询
        for(int i=0;i<datas.length;i++){
            if(type.equals("sku")){
                productDtos= selectProductByOption(content);
            }else if (type.equals("option")){
                productDtos=selectProductByPostion(content);
            }else if (type.equals("name")){
                products=whProductMapper.selectProductByName(content);
                productDtos= selectProductByNameOrPurchaser(products);
            }else if(type.equals("purchaser")){
                products=whProductMapper.selectProductByPurchaser(content);
                productDtos= selectProductByNameOrPurchaser(products);
            }
            list.addAll(productDtos);
        }
        return list;
        //return JsonData.setResultSuccess(list);
    }

    /**
     * 根据sku查看产品详细
     * @param type
     * @param sku
     * @return
     */
   /* @Override
    //@PermissionCheck(type = Constants.MODIFY)
    @Transactional
    public List<ProductDetailDto> findDetailBySku(String type, String sku) {
        return null;
    }*/

    /**
     * 根据sku查询产品信息
     * @param sku
     * @return
     */
    public List<ProductDto> selectProductByOption(String sku){
        List<ProductDto> productDtos=new ArrayList<>();
        products= whProductMapper.selectProductByOption(sku);
        List<WhPosition> whPositions=whPositionMapper.getBaseByProductId(sku);
        for(WhProduct product:products){
            for (WhPosition whPosition:whPositions) {
                ProductDto pd = getProductDto(product);
                pd.setSku(sku);
                // 获取仓位
                //WhPosition whPosition=whPositionService.getBaseByProductId(sku);
                pd.setOption_id(whPosition.getPositionName());
                //获取库存数据
                pd = getInventory(pd);
                productDtos.add(pd);
            }
        }
        return productDtos;
    }

    /**
     * 根据货物名称或者采购员
     * @param
     * @return
     */
    public List<ProductDto> selectProductByNameOrPurchaser(List<WhProduct> products){
        List<ProductDto> productDtos=new ArrayList<>();
        for(WhProduct product:products){
            //获取sku
            WhProductSku whProductSku=iWhProductSkuService.selectProductSku(product.getAsin());
            // 获取仓位
            List<WhPosition> whPositions=whPositionMapper.getBaseByProductId(whProductSku.getAsin());
            for (WhPosition whPosition:whPositions) {
                ProductDto pd = getProductDto(product);
                // WhPosition whPosition=whPositionService.getBaseByProductId(whProductSku.getAsin());
                pd.setOption_id(whPosition.getPositionName());
                pd.setSku(whProductSku.getAsin());
                //获取库存数据
                pd = getInventory(pd);
                productDtos.add(pd);
            }
        }
        return productDtos;
    }

    /**
     * 根据仓位查询产品
     * @param postionName
     * @return
     */
    public List<ProductDto> selectProductByPostion(String postionName){
        List<ProductDto> productDtos=new ArrayList<>();
        //根据仓库名称获取仓库id
        List<WhPosition> whPositions=whPositionMapper.selectAsinByOptionName(postionName);
        for (WhPosition whPosition: whPositions){
            products= whProductMapper.selectProductByOption(whPosition.getAsin());
            if (products.size()==0)
                continue;
            for(WhProduct product:products) {
                ProductDto pd = getProductDto(product);
                pd.setSku(whPosition.getAsin());
                pd.setOption_id(postionName);
                //获取库存数据
                pd = getInventory(pd);
                productDtos.add(pd);
            }
        }
        return productDtos;
    }

    /**
     * 获取Dto对象
     * @param product
     * @return
     */
    public ProductDto getProductDto(WhProduct product){
        ProductDto pd=new ProductDto();
        pd.setPicture(product.getPicJson());
        pd.setWeight(product.getWeight());
        pd.setGoodStatus(product.getGoodStatus());
        pd.setIsNew(product.getIsNew());
        pd.setPurchaser(product.getPurchaseUser());
        pd.setSupplier(product.getSupplierId());
        pd.setName(product.getNameCn());
        pd.setTotalPrice(product.getPricePurchase());
        return pd;
    }

    /**
     * 获取库存信息
     * @param productDto
     * @return
     */
    public ProductDto  getInventory(ProductDto productDto){
        int actualStock=0;
        int distributionStock=0;
        int putStock = 0;
        String sku=productDto.getSku();
        List<WhPostionSku> whPostionSkus=whPostionSkuMapper.selectInventoryBySku(sku);
        for(WhPostionSku whPostionSku:whPostionSkus) {
            //实际库存
            actualStock += whPostionSku.getStock();
            //配货库存
            distributionStock = +whPostionSku.getScanStock();
        }

        productDto.setActualStock(actualStock);
        //缺货库存
        int outOfStock=actualStock-distributionStock;
        productDto.setShortStock(outOfStock);

        List<WhReceivedBatchItem> whReceivedBatchItems=whReceivedBatchItemMapper.selectStockByAsin(sku);
        for(WhReceivedBatchItem whReceivedBatchItem:whReceivedBatchItems) {
            whReceivedBatchItem.getStatus();
            if (whReceivedBatchItem.getStatus() == 3) {
                //入库库存
                putStock += whReceivedBatchItem.getStockNumber();
                //return whReceivedBatchItem.getStockNumber();
            }
        }
        //可用库存
        int availableStock=actualStock+putStock+distributionStock;
        productDto.setShortStock(outOfStock);
        productDto.setAvailStock(availableStock);
        productDto.setArrivalStock(putStock);
        productDto.setActualStock(actualStock);
        //货值
        productDto.setTotalPrice(productDto.getTotalPrice()*actualStock);
        return productDto;
    }

}
