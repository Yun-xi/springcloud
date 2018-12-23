package com.xxxx.product.repository;

import com.xxxx.product.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductInfoRepository extends JpaRepository<ProductInfo, Integer> {
    List<ProductInfo> findByProductStatus(Integer productStatus);
}
