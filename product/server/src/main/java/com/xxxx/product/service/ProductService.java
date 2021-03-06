package com.xxxx.product.service;

import com.xxxx.product.DTO.CartDTO;
import com.xxxx.product.common.DecreaseStockInput;
import com.xxxx.product.common.ProductInfoOutput;
import com.xxxx.product.dataobject.ProductInfo;

import java.util.List;

/**
 * Created by xieyaqi
 * 2017-12-09 21:57
 */
public interface ProductService {

    /**
     * 查询所有在架商品列表
     */
    List<ProductInfo> findUpAll();

    /**
     * 查询商品列表
     * @param productIdList
     * @return
     */
    List<ProductInfoOutput> findList(List<String> productIdList);

    /**
     * 扣库存
     * @param cartDTOList
     */
    void decreaseStock2(List<CartDTO> cartDTOList);

    /**
     * 扣库存
     * @param decreaseStockInputList
     */
    void decreaseStock(List<DecreaseStockInput> decreaseStockInputList);
}
