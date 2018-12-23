package com.xxxx.product.service.impl;

import com.xxxx.product.dataobject.ProductInfo;
import com.xxxx.product.enums.ProductStatusEnum;
import com.xxxx.product.repository.ProductInfoRepository;
import com.xxxx.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }
}
