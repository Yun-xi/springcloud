package com.xxxx.order.repository;

import com.xxxx.order.dataobject.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by xieyaqi
 * 2017-12-10 16:11
 */
@Repository
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {
}
