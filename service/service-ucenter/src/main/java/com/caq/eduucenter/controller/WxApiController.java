package com.caq.eduucenter.controller;

import com.caq.commonutils.utils.JwtUtils;
import com.caq.eduucenter.entity.UcenterMember;
import com.caq.eduucenter.service.UcenterMemberService;
import com.caq.eduucenter.utils.ConstantWxUtils;
import com.caq.eduucenter.utils.HttpClientUtils;
import com.caq.servicebase.exceptionhandle.Guliexception;
import com.google.gson.Gson;
import jdk.nashorn.internal.parser.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

@CrossOrigin
@Controller
@RequestMapping("/api/ucenter/wx")
public class WxApiController {


    //    注入service是因为我们要把微信扫码后的人注册到数据库
    @Autowired
    private UcenterMemberService ucenterMemberService;

    //2 获取扫描人信息，添加数据
    //步骤是固定的，cv就行
    @GetMapping("callback")
    public String callback(String code, String state) {
//        1.获取code值，临时票据，类似与验证码

//        2.拿着code请求微信固定的地址，得到两个值access_token和openid
        String baseAccessTokenUrl = "https://api.weixin.qq.com/sns/oauth2/access_token" +
                "?appid=%s" +
                "&secret=%s" +
                "&code=%s" +
                "&grant_type=authorization_code";
//        拼接三个参数：id秘钥和code值
        String accessTokenUrl = String.format(baseAccessTokenUrl,
                ConstantWxUtils.WX_OPEN_APP_ID,
                ConstantWxUtils.WX_OPEN_APP_SECRET,
                code);

        //  3.向认证服务器发送请求换取access_token
//        请求这个拼接好的地址，得到返回的两个值access_token和openid
//        使用httpclient发送请求，得到返回结果(httpclient就是能够在不使用浏览器的情况下也能模拟出浏览器的请求和响应过程)
        String accessTokenInfo = null;
        try {
            accessTokenInfo = HttpClientUtils.get(accessTokenUrl);
        } catch (Exception e) {
            new Guliexception(20001, "获取token信息失败");
        }


        //可以看到accesstoken的值是一个json字符串，前端需要的也是json字符串
//        {"access_token":"56_jgDYj0kFSTarb6dLk3S8v32kVFmACL7MSBlAeBllfWMtfCqmFnvaAk2jfQTnjmVJ0tt7mAwaqHQ6NUt3DNJIYq8LH7utQA6QXIwfIdC46lE",
//         "expires_in":7200,
//         "refresh_token":"56_vQaXS1y1Fnp6zf4lZkFBDA7FNRdrkgDBPSytNMFmwdvey5oufKUIB2-7mjdIK7hjNzdD0pCAe3V7Heerszs1xiRm0jjqRufX_ddaDBviuIc",
//         "openid":"o3_SC501zRkVcwqQ_sbnIMcp4awU",
//         "scope":"snsapi_login",
//         "unionid":"oWgGz1FS61brgcCChgq5yO4mQuZM"}
//            System.out.println(accessTokenInfo);


//            4.从accessTokenInfo取得accesstoken和openid
//            把accessTokenInfo字符串转化为map集合，根据map里面key获取对应值
//            使用json工具来转化
        Gson gson = new Gson();
        HashMap mapAccessToken = gson.fromJson(accessTokenInfo, HashMap.class);
        String access_token = (String) mapAccessToken.get("access_token");
        String openid = (String) mapAccessToken.get("openid");

//            6.把扫码人信息注册到数据库中
//            判断数据表是否存在相同的微信信息，根据openid来进行判断
        UcenterMember member = ucenterMemberService.getOpenIdMember(openid);
        if (member == null) {//member是空，表没有相同微信数据，进行添加

//            5.拿着得到的access_token和openid，再去请求微信提供固定的地址，获取到扫描人信息
            //访问微信的资源服务器，获取用户信息
            String baseUserInfoUrl = "https://api.weixin.qq.com/sns/userinfo" +
                    "?access_token=%s" +
                    "&openid=%s";

            //拼接两个参数
            String userInfoUrl = String.format(
                    baseUserInfoUrl,
                    access_token,
                    openid
            );

//            发送请求
//            try {
            String userInfo = null;
            try {
                userInfo = HttpClientUtils.get(userInfoUrl);
            } catch (Exception e) {
                new Guliexception(20001, "登录失败");
            }
//            System.out.println(userInfo);
//            {"openid":"o3_SC501zRkVcwqQ_sbnIMcp4awU",
//            "nickname":"Alpine",
//            "sex":0,
//            "language":"",
//            "city":"",
//            "province":"",
//            "country":"",
//            "headimgurl":"https:\/\/thirdwx.qlogo.cn\/mmopen\/vi_32\/Hk6ZTagyeQiaqzMRYkhenNgsNKjd1SrQLWXbTib5COKs8rJYC2Xde92vVOialAWric5IW06WRjGBttlGXcN8fohryQ\/132",
//            "privilege":[],
//            "unionid":"oWgGz1FS61brgcCChgq5yO4mQuZM"}

            HashMap userInfoMap = gson.fromJson(userInfo, HashMap.class);
            String nickname = (String) userInfoMap.get("nickname");
            String headimgurl = (String) userInfoMap.get("headimgurl");//头像

            member = new UcenterMember();
            member.setOpenid(openid);
            member.setAvatar(headimgurl);
            member.setNickname(nickname);
            ucenterMemberService.save(member);
        }
        //最后：返回首页面
//            使用jwt根据member对象生成token字符串
        String jwtToken = JwtUtils.getJwtToken(member.getId(), member.getNickname());
        //返回首页面，通过路径传递token字符串
        return "redirect:http://localhost:3000?token=" + jwtToken;

    }

    //%s相当于占位符
    @GetMapping("login")
    public String getWxCode() {
        //固定地址，后面拼接参数
//        String url = "https://open.weixin.qq.com/" +
//                "connect/qrconnect?appid="+ ConstantWxUtils.WX_OPEN_APP_ID+"&response_type=code";

        // 微信开放平台授权baseUrl  %s相当于?代表占位符
        String baseUrl = "https://open.weixin.qq.com/connect/qrconnect" +
                "?appid=%s" +
                "&redirect_uri=%s" +
                "&response_type=code" +
                "&scope=snsapi_login" +
                "&state=%s" +
                "#wechat_redirect";

        //对redirect_url进行URLEncoder编码
        String redirectUrl = ConstantWxUtils.WX_OPEN_REDIRECT_URL;
        try {
            redirectUrl = URLEncoder.encode(redirectUrl, "utf-8");
        } catch (Exception e) {
        }

        //设置%s里面值
        String url = String.format(
                baseUrl,
                ConstantWxUtils.WX_OPEN_APP_ID,
                redirectUrl,
                "atguigu"
        );

        //重定向到请求微信地址里面
        return "redirect:" + url;
    }


}
