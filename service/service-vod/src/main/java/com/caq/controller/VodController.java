package com.caq.controller;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.vod.model.v20170321.DeleteVideoRequest;
import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthRequest;
import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthResponse;
import com.caq.commonutils.R;
import com.caq.service.VodService;
import com.caq.servicebase.exceptionhandle.Guliexception;
import com.caq.utils.ConstantVodUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/eduVod/video")
//@CrossOrigin
public class VodController {
    @Autowired
    private VodService vodService;

    public static DefaultAcsClient initVodClient(String accessKeyId, String accessKeySecret) {
        String regionId = "cn-shanghai";  // 点播服务接入区域
        DefaultProfile profile = DefaultProfile.getProfile(regionId, accessKeyId, accessKeySecret);
        DefaultAcsClient client = new DefaultAcsClient(profile);
        return client;
    }

    @PostMapping("uploadAliYunVideo")
    public R uploadAlyiVideo(MultipartFile file){
//        返回上传视频id
        String videoId= vodService.uploadVideoAly(file);
        return R.ok().data("videoId",videoId);
    }


    @DeleteMapping("removeAliYunVideo/{id}")
    public R removeAlyVideo(@PathVariable String id){

        try {
            //初始化对象
            DefaultAcsClient client = initVodClient(ConstantVodUtils.ACCESS_KEY_ID, ConstantVodUtils.ACCESS_KEY_SECRET);
            //创建删除视频的request对象
            DeleteVideoRequest request=new DeleteVideoRequest();
            //向request设置删除的视频id
            request.setVideoIds(id);
            client.getAcsResponse(request);
            return R.ok();
        }catch (Exception e){
            e.printStackTrace();
            throw new Guliexception(20001,"删除视频失败");
        }
    }


    //删除多个阿里云视频的方法
    //参数多个视频id list
    @DeleteMapping("delete-batch")
    public R deleteBatch(@RequestParam("videoIdList") List<String> videoIdList){
        vodService.removeMoreAlyVideo(videoIdList);
        return R.ok();
    }

    //根据视频id获取视频凭证
    @GetMapping("getPlayAuth/{id}")
    public R getPlayAuth(@PathVariable String id) {
        try {
            //创建初始化对象
            DefaultAcsClient client = initVodClient(ConstantVodUtils.ACCESS_KEY_ID, ConstantVodUtils.ACCESS_KEY_SECRET);
            //创建获取凭证request和response对象
            GetVideoPlayAuthRequest request = new GetVideoPlayAuthRequest();
            //向request设置视频id
            request.setVideoId(id);
            //调用方法得到凭证
            GetVideoPlayAuthResponse response = client.getAcsResponse(request);
            String playAuth = response.getPlayAuth();
            return R.ok().data("playAuth",playAuth);
        }catch(Exception e) {
            throw new Guliexception(20001,"获取凭证失败");
        }
    }

}
