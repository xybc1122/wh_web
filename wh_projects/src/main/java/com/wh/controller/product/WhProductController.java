package com.wh.controller.product;

import com.wh.base.ResponseBase;
import com.wh.entity.dto.ProductDto;
import com.wh.service.product.IWhProductService;
import com.wh.utils.PageInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 货品资料
 */
@RestController
@RequestMapping("/api/v1/product")
public class WhProductController {
    @Autowired
    private IWhProductService productService;

    /**
     * 根據条件查询产品信息
     * @param type
     * @param content
     * @return
     */
    @PostMapping("/findByCondition")
    public ResponseBase findProductByCondition(@RequestParam ("type") String type,@RequestParam("content")String content,@RequestParam("pageSize") int pageSize,@RequestParam("currentPage") int currentPage){
        List<ProductDto> productDtos= productService.selectProduct(type,content,pageSize,currentPage);
        // List<ProductDto> list=mapperFacade.mapAsList(productDtos,null);
        return PageInfoUtils.pageResult(productDtos,null);
        //return  productService.selectProduct(type,content,pageSize,currentPage);
    }


  /**
   *根据sku查看产品详细
   * @Date 2019/7/9 12:46
   * @Param [type, sku]
   * @Author yyk
   * @Return com.wh.base.ResponseBase
   */
    @PostMapping("/findDetailBySku")
    public ResponseBase findDetailBySku(@RequestParam ("type") String type,@RequestParam("sku")String sku){
       // return productService.findDetailBySku(type,sku);
        return null;
    }
}
