package com.xxxx.product.service.impl;

import com.xxxx.product.dataobject.ProductCategory;
import com.xxxx.product.enums.ProductStatusEnum;
import com.xxxx.product.repository.ProductCategoryRepository;
import com.xxxx.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return productCategoryRepository.findByCategoryTypeIn(categoryTypeList);
    }
}
