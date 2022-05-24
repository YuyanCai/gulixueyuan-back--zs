package com.caq.eduorder.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.caq.commonutils.R;
import com.caq.commonutils.utils.JwtUtils;
import com.caq.eduorder.entity.Order;
import com.caq.eduorder.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.management.Query;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 订单 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2022-05-14
 */
@RestController
@RequestMapping("/eduOrder/order")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 生成订单需要两个参数，一个课程id，一个用户id
     * 课程id我们通过路径获取，
     * 登录之后用户的信息放在cookie中了，前端我们写的有拦截器，
     * 拦截器将cookie中的信息取出放到request请求头中
     * 通过jwt工具类可以获取request请求头中的用户id
     * @param courseId
     * @param request
     * @return
     */
    //1、生成订单的方法
    @PostMapping("createOrder/{courseId}")
    public R saveOrder(@PathVariable String courseId, HttpServletRequest request){
        String id = JwtUtils.getMemberIdByJwtToken(request);

        //创建订单，返回订单号
        String orderNo = orderService.createOrders(courseId,id);
        return R.ok().data("orderId",orderNo);
    }

    //2、根据订单id查询订单信息
    @GetMapping("getOrderInfo/{orderId}")
    public R getOrderInfo(@PathVariable String orderId){
        QueryWrapper<Order> wrapper = new QueryWrapper<>();
        wrapper.eq("order_no",orderId);
        Order order = orderService.getOne(wrapper);
        return R.ok().data("item",order);
    }

    //根据课程id和用户id查询订单表中订单状态
    @GetMapping("isBuyCourse/{courseId}/{memberId}")
    public boolean isBuyCourse(@PathVariable String courseId,@PathVariable String memberId) {
        QueryWrapper<Order> wrapper = new QueryWrapper<>();
        wrapper.eq("course_id",courseId);
        wrapper.eq("member_id",memberId);
        wrapper.eq("status",1);//支付状态 1代表已经支付
        int count = orderService.count(wrapper);
        if(count>0) { //已经支付
            return true;
        } else {
            return false;
        }
    }


}

