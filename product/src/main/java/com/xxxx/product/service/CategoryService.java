package com.xxxx.product.service;

import com.xxxx.product.dataobject.ProductCategory;

import java.util.List;

public interface CategoryService {
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
