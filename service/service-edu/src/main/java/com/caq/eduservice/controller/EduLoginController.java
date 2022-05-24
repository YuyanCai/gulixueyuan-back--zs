package com.caq.eduservice.controller;

import com.caq.commonutils.R;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/eduService/user")
//@CrossOrigin
public class EduLoginController {

    /**登录接口*/
    @PostMapping("login")
    public R login(){
        return R.ok().data("token", "admin");
    }

    /**获取登录用户信息*/
    @GetMapping("info")
    public R info(){
        return R.ok().data("roles", "[admin]").data("name", "admin").data("avatar", "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fnimg.ws.126.net%2F%3Furl%3Dhttp%253A%252F%252Fdingyue.ws.126.net%252F2021%252F0820%252F0142054dp00qy3hyz0019d200u0015dg00u0015d.png%26thumbnail%3D650x2147483647%26quality%3D80%26type%3Djpg&refer=http%3A%2F%2Fnimg.ws.126.net&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1634440222&t=bfa361b71f6a6a988859a0c3dfda7a2c");
    }

}
