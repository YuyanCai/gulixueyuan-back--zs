package com.caq.eduucenter.controller;


import com.caq.commonutils.R;
import com.caq.commonutils.ordervo.UcenterMemberOrder;
import com.caq.commonutils.utils.JwtUtils;
import com.caq.eduucenter.entity.UcenterMember;
import com.caq.eduucenter.entity.vo.LoginVo;
import com.caq.eduucenter.entity.vo.RegisterVo;
import com.caq.eduucenter.service.UcenterMemberService;
import com.caq.servicebase.exceptionhandle.Guliexception;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 会员表 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2022-05-12
 */
@RestController
@RequestMapping("/eduCenter/member")
@CrossOrigin
public class UcenterMemberController {

    @Autowired
    private UcenterMemberService memberService;

    @ApiOperation(value = "会员登录")
    @PostMapping("login")
    public R login(@RequestBody LoginVo loginVo) {
        String token = memberService.login(loginVo);
        return R.ok().data("token", token);
    }

    @ApiOperation(value = "会员注册")
    @PostMapping("register")
    public R register(@RequestBody RegisterVo registerVo){
        memberService.register(registerVo);
        return R.ok();
    }

    //用户登录成功后，在页面显示用户的昵称和id
    @ApiOperation(value = "根据token获取登录信息")
    @GetMapping("getMemberInfo")
    public R getLoginInfo(HttpServletRequest request){
        try {
            //调用jwt工具类的方法，根据request对象获取头信息，返回用户id
            String memberId = JwtUtils.getMemberIdByJwtToken(request);
            UcenterMember ucenterMember = memberService.getLoginInfo(memberId);
            return R.ok().data("userInfo", ucenterMember);
        }catch (Exception e){
            e.printStackTrace();
            throw new Guliexception(20001,"error");
        }
    }

    //根据用户id获取用户信息
    //调用段和被调用段要是同一个对象
    @PostMapping("getUserInfoOrder/{id}")
    public UcenterMemberOrder getUserInfoOrder(@PathVariable String id){
        UcenterMember member = memberService.getById(id);
//        把member对象里的值赋值给UcenterMemberOrder对象
        UcenterMemberOrder ucenterMemberOrder;
        if (member != null){
            ucenterMemberOrder = new UcenterMemberOrder();
            BeanUtils.copyProperties(member,ucenterMemberOrder);
            //返回的是调用端和被调用段同一个对象
            return ucenterMemberOrder;
        }
        return null;
    }

    //查询某一天注册人数
    @GetMapping("countRegister/{day}")
    public R countRegister(@PathVariable String day) {
        Integer count = memberService.countRegisterDay(day);
        return R.ok().data("countRegister",count);
    }
}

