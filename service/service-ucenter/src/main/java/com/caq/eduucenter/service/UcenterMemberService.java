package com.caq.eduucenter.service;

import com.caq.eduucenter.entity.UcenterMember;
import com.baomidou.mybatisplus.extension.service.IService;
import com.caq.eduucenter.entity.vo.LoginVo;
import com.caq.eduucenter.entity.vo.RegisterVo;

/**
 * <p>
 * 会员表 服务类
 * </p>
 *
 * @author testjava
 * @since 2022-05-12
 */
public interface UcenterMemberService extends IService<UcenterMember> {

    String login(LoginVo loginVo);

    void register(RegisterVo registerVo);

    UcenterMember getLoginInfo(String memberId);

    //根据openid判断
    UcenterMember getOpenIdMember(String openid);

    Integer countRegisterDay(String day);
}
