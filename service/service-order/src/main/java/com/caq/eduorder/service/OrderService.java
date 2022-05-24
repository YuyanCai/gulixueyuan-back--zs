package com.caq.eduorder.service;

import com.caq.eduorder.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 订单 服务类
 * </p>
 *
 * @author testjava
 * @since 2022-05-14
 */
public interface OrderService extends IService<Order> {

    String createOrders(String courseId, String memberId);
}
