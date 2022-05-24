package com.caq.eduorder.service.impl;

import com.caq.commonutils.ordervo.CourseWebVoOrder;
import com.caq.commonutils.ordervo.UcenterMemberOrder;
import com.caq.eduorder.client.EduClient;
import com.caq.eduorder.client.UcenterClient;
import com.caq.eduorder.entity.Order;
import com.caq.eduorder.mapper.OrderMapper;
import com.caq.eduorder.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.caq.eduorder.utils.OrderNoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.OrderUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 订单 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2022-05-14
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Autowired
    private EduClient eduClient;

    @Autowired
    private UcenterClient ucenterClient;

    @Override
    public String createOrders(String courseId, String memberId) {

        //        通过远程调用获取用户信息
        UcenterMemberOrder userInfoOrder = ucenterClient.getUserInfoOrder(memberId);

        //        通过远程调用获取根据课程id获取课程信息
        CourseWebVoOrder courseInfoOrder = eduClient.getCourseInfoOrder(courseId);

//        创建order对象，向order对象里设置需要数据
        Order order = new Order();
        order.setOrderNo(OrderNoUtil.getOrderNo()); //订单号
        order.setCourseId(courseId);  //课程id
        order.setCourseTitle(courseInfoOrder.getTitle());
        order.setCourseCover(courseInfoOrder.getCover());
        order.setTeacherName(userInfoOrder.getNickname());
        order.setTotalFee(courseInfoOrder.getPrice());
        order.setMemberId(memberId);
        order.setMobile(userInfoOrder.getMobile());
        order.setNickname(userInfoOrder.getNickname());

        order.setStatus(0);     //支付状态0代表未支付
        order.setPayType(1);    //支付类型，微信支付

        baseMapper.insert(order);

        //返回订单号
        return order.getOrderNo();
    }
}
