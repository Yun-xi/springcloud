package com.xxxx.product.service;

import com.xxxx.product.dataobject.ProductCategory;

import java.util.List;

/**
 * 类目
 * Created by xieyaqi
 * 2017-12-09 22:06
 */
public interface CategoryService {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
