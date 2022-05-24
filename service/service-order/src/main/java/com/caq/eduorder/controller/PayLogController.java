package com.caq.eduorder.controller;


import com.caq.commonutils.R;
import com.caq.eduorder.service.PayLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 支付日志表 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2022-05-14
 */
@RestController
@RequestMapping("/eduOrder/paylog")
@CrossOrigin
public class PayLogController {

    @Autowired
    private PayLogService payLogService;

    //生成微信支付二维码接口
//    参数是订单号
    @GetMapping("createNative/{orderNo}")
    public R createNative(@PathVariable String orderNo){

        //返回信息，包括二维码地址，还有其他信息.返回map取值更方便
        Map map = payLogService.createNative(orderNo);
        return R.ok().data(map);
    }

    //查询订单支付状态
    @GetMapping("queryPayStatus/{orderNo}")
    public R queryPayStatus(@PathVariable String orderNo){
        Map<String,String> map =  payLogService.queryPayStatus(orderNo);
        if (map == null){
            return R.error().message("支付出错了");
        }
        //如果返回map不为空，通过map获取订单状态
        //固定写法
        if (map.get("trade_state").equals("SUCCESS")){//支付成功
            //添加记录到支付表，更新订单表订单状态
            payLogService.updateOrderStatus(map);
            return R.ok();
        }
        return R.ok().code(25000).message("支付中");

    }

}

