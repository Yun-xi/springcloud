package com.xxxx.order.repository;

import com.xxxx.order.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by xieyaqi
 * 2017-12-10 16:12
 */
@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {
}
