package com.caq.eduorder.client;

import com.caq.commonutils.ordervo.UcenterMemberOrder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@FeignClient(name = "service-ucenter")
@Component
public interface UcenterClient {

    //根据用户id获取用户信息
    //调用段和被调用段要是同一个对象
    @PostMapping("/eduCenter/member/getUserInfoOrder/{id}")
    public UcenterMemberOrder getUserInfoOrder(@PathVariable("id") String id);


}
