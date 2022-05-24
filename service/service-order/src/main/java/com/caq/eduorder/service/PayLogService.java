package com.caq.eduorder.service;

import com.caq.eduorder.entity.PayLog;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 支付日志表 服务类
 * </p>
 *
 * @author testjava
 * @since 2022-05-14
 */
public interface PayLogService extends IService<PayLog> {

    Map createNative(String orderNo);

    //根据订单号查询订单状态
    Map<String, String> queryPayStatus(String orderNo);

    //向支付表添加记录，更新订单状态
    void updateOrderStatus(Map<String, String> map);
}
