package com.caq;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthRequest;
import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthResponse;

public class test2 {
    public static void main(String[] args) throws ClientException {
        //根据视频id获取视频播放地址
        //创建初始化对象
        DefaultAcsClient client =InitObject.initVodClient("LTAI5tQNax8eYNbDtdhkLvo8", "kLUIWEMK7mDodLVxZIn5hcjNROxite");

        //创建获取视频凭证request和response对象
        GetVideoPlayAuthRequest request = new GetVideoPlayAuthRequest();
        GetVideoPlayAuthResponse response = new GetVideoPlayAuthResponse();
        //向request对象里面设置视频id
        request.setVideoId("424b5477330841b4ba5f7eba1c904e6a");
        //调用初始化对象里面的方法，传递request，获取凭证
        response = client.getAcsResponse(request);
        //播放凭证
        System.out.print("PlayAuth = " + response.getPlayAuth() + "\n");
        //VideoMeta信息
        System.out.print("VideoMeta.Title = " + response.getVideoMeta().getTitle() + "\n");

    }

}
