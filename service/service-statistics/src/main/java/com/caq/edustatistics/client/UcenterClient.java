package com.caq.edustatistics.client;

import com.caq.commonutils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient("service-ucenter")
public interface UcenterClient {

    //查询某一天注册人数
    @GetMapping("/eduCenter/member/countRegister/{day}")
    public R countRegister(@PathVariable("day") String day);
}

