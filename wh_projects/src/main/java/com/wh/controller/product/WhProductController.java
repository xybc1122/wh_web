package com.wh.controller.product;

import com.wh.base.JsonData;
import com.wh.base.ResponseBase;
import com.wh.entity.dto.ProductDetailEntityDto;
import com.wh.entity.dto.ProductDto;
import com.wh.service.product.IWhProductService;
import com.wh.service.product.WhProductDetailService;
import com.wh.utils.PageInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * 货品资料
 */
@RestController
@RequestMapping("/api/v1/product")
public class WhProductController {
    @Autowired
    private IWhProductService productService;
    @Autowired
    private WhProductDetailService whProductDetailService;
    /**
     * 根據条件查询产品信息
     * @param map
     * @return
     */
    @PostMapping("/findByCondition")
    public ResponseBase findProductByCondition(@RequestBody Map map){
        List<ProductDto> productDtos= productService.selectProduct((int)map.get("type"),(String)map.get("content"),(int)map.get("pageSize"),(int)map.get("currentPage"));
        // List<ProductDto> list=mapperFacade.mapAsList(productDtos,null);
        return PageInfoUtils.pageResult(productDtos,null);
        //return  productService.selectProduct(type,content,pageSize,currentPage);
    }

    @PostMapping("/findByCondition1")
    public ResponseBase findProductByCondition1(@RequestParam("type")int type,@RequestParam("content")String content,@RequestParam("pageSize") int pageSize,@RequestParam("currentPage") int currentPage){
        List<ProductDto> productDtos= productService.selectProduct(type,content,pageSize,currentPage);
        // List<ProductDto> list=mapperFacade.mapAsList(productDtos,null);
        return PageInfoUtils.pageResult(productDtos,null);
    }

  /**
   *根据sku查看产品详细
   * @Date 2019/7/9 12:46
   * @Param [type, sku]
   * @Author yyk
   * @Return com.wh.base.ResponseBase
   */
    @PostMapping("/findDetailBySku")
    public ResponseBase findDetailBySku(@RequestBody Map map){
        ProductDetailEntityDto productDetailEntityDto = whProductDetailService.findDetailBySku((int)map.get("type"),(String)map.get("sku"));
        //ResponseBase rp= PageInfoUtils.pageResult(productDetailEntityDto.getProductDetailDtos(),null);
        //rp.setData(PageInfoUtils.pageResult(productDetailEntityDto.getProductDetailDtos(),null));
        //rp.setData(productDetailEntityDto.getSubtotal());
       // return productService.findDetailBySku(type,sku);
        return JsonData.setResultSuccess(productDetailEntityDto);
    }
    @PostMapping("/findDetailBySku1")
    public ResponseBase findDetailBySku1(@RequestParam("type") int type,@RequestParam("sku")String sku){
        ProductDetailEntityDto productDetailEntityDto = whProductDetailService.findDetailBySku(type,sku);
        return JsonData.setResultSuccess(productDetailEntityDto);
    }
}
