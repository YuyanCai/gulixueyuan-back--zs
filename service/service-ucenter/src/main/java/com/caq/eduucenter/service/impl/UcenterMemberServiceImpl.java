package com.caq.eduucenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.caq.commonutils.MD5;
import com.caq.commonutils.utils.JwtUtils;
import com.caq.eduucenter.entity.UcenterMember;
import com.caq.eduucenter.entity.vo.LoginVo;
import com.caq.eduucenter.entity.vo.RegisterVo;
import com.caq.eduucenter.mapper.UcenterMemberMapper;
import com.caq.eduucenter.service.UcenterMemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.caq.servicebase.exceptionhandle.Guliexception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 会员表 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2022-05-12
 */
@Service
public class UcenterMemberServiceImpl extends ServiceImpl<UcenterMemberMapper, UcenterMember> implements UcenterMemberService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public String login(LoginVo loginVo) {
        //获取手机号和密码
        String mobile = loginVo.getMobile();
        String password = loginVo.getPassword();

        //手机号和密码非空判断
        if (StringUtils.isEmpty(mobile) || StringUtils.isEmpty(password)) {
            throw new Guliexception(20001, "账户和密码不能为空！");
        }

        QueryWrapper<UcenterMember> wrapper = new QueryWrapper<>();
        wrapper.eq("mobile", mobile);
        UcenterMember mobileMember = baseMapper.selectOne(wrapper);
        //判断查询对象是否为空
        /**
         * 也就是判断四种情况
         * 1.有没有输入账号或密码
         * 2.账号是否正确
         * 3.密码是否正确
         * 4.账户是否被禁用
         */
        if (mobileMember == null) {
            throw new Guliexception(20001, "账号或密码错误");
        }

        //判断密码
        //数据库存的密码加密后在和数据库中密码进行比较
        //因为存入数据库中密码是加密后的，不能明文存储
        if (!MD5.encrypt(password).equals(mobileMember.getPassword())) {
            throw new Guliexception(20001, "账号或密码错误");
        }

        //判断用户是否禁用
        if (mobileMember.getIsDisabled()) {
            throw new Guliexception(20001, "账户已禁用");
        }

        String jwtToken = JwtUtils.getJwtToken(mobileMember.getId(), mobileMember.getNickname());
        return jwtToken;
    }

    @Override
    public void register(RegisterVo registerVo) {
        //获取注册信息，进行校验
        String nickname = registerVo.getNickname();
        String mobile = registerVo.getMobile();
        String password = registerVo.getPassword();
        String code = registerVo.getCode();

        //校验参数
        if (StringUtils.isEmpty(nickname) ||
            StringUtils.isEmpty(mobile) ||
            StringUtils.isEmpty(password) ||
            StringUtils.isEmpty(code)) {
            throw new Guliexception(20001, "请完成必填项！");
        }

        //校验校验验证码
        //从redis获取发送的验证码
        String redisCode = redisTemplate.opsForValue().get(mobile);
        if (!code.equals(redisCode)) {
            throw new Guliexception(20001, "验证码错误！");
        }

        //查询数据库中是否存在相同的手机号码
        //防止一个账户多次注册
        QueryWrapper<UcenterMember> wrapper = new QueryWrapper<>();
        wrapper.eq("mobile", mobile);
        Integer count = baseMapper.selectCount(wrapper);

        if (count.intValue() > 0) {
            throw new Guliexception(20001, "此账号已存在，请直接登录！");
        }

        //以上都没问题了，那就存数据库
        //添加注册信息到数据库
        UcenterMember member = new UcenterMember();
        member.setNickname(nickname);
        member.setMobile(registerVo.getMobile());
        //注册的时候密码也要加密
        member.setPassword(MD5.encrypt(password));
        member.setIsDisabled(false);
        member.setAvatar("http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132");
        this.save(member);
    }

    @Override
    public UcenterMember getLoginInfo(String memberId) {
        UcenterMember member = baseMapper.selectById(memberId);
        return member;
    }

    //根据openid判断
    @Override
    public UcenterMember getOpenIdMember(String openid) {
        QueryWrapper<UcenterMember> wrapper = new QueryWrapper<>();
        wrapper.eq("openid",openid);
        UcenterMember member = baseMapper.selectOne(wrapper);
        return member;
    }

    @Override
    public Integer countRegisterDay(String day) {
        return baseMapper.countRegisterDay(day);
    }

}
