package com.caq.msmservice.controller;


import com.caq.commonutils.R;
import com.caq.msmservice.service.MsmService;
import com.caq.msmservice.utils.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/eduMsm/msm")
//@CrossOrigin
public class MsmController {

    @Autowired
    private MsmService msmService;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    //发送短信方法
    @GetMapping("send/{phone}")
    public R sendMsm(@PathVariable String phone){
        //1.从redis获取验证码，如果获取到直接返回
        String code = redisTemplate.opsForValue().get(phone);
        if (!StringUtils.isEmpty(code)){
            return R.ok().message("短信发送成功");
        }

        //2.如果redis获取不到，进行腾讯云发送
        code = RandomUtil.getSixBitRandom();
        boolean isSend = msmService.send(code,phone);
        if (isSend){
            //设置有效时间为5分钟
            redisTemplate.opsForValue().set(phone,code,5, TimeUnit.MINUTES);
            return R.ok();
        }else{
            return R.error().message("短信发送失败");
        }
    }


}
