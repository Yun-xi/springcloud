package com.xxxx.product.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 商品上下架状态
 */
@Getter
@AllArgsConstructor
public enum ProductStatusEnum {
    UP(0, "上架"),
    DOWN(1, "下架");

    private Integer code;
    private String message;

}