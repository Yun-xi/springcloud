package com.xxxx.order.exception;

import com.xxxx.order.enums.ResultEnum;

/**
 * Created by xieyaqi
 * 2017-12-10 17:27
 */
public class OrderException extends RuntimeException {

    private Integer code;

    public OrderException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public OrderException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
