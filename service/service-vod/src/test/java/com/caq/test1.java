package com.caq;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.vod.model.v20170321.GetPlayInfoRequest;
import com.aliyuncs.vod.model.v20170321.GetPlayInfoResponse;

import java.util.List;

public class test1 {
    public static void main(String[] args) throws ClientException {
        //根据视频id获取视频播放地址
        //创建初始化对象
        DefaultAcsClient client =InitObject.initVodClient("LTAI5tQNax8eYNbDtdhkLvo8", "kLUIWEMK7mDodLVxZIn5hcjNROxite");
        GetPlayInfoResponse response = new GetPlayInfoResponse();
        GetPlayInfoRequest request=new GetPlayInfoRequest();
        //向request对象里面设置视频id
        request.setVideoId("424b5477330841b4ba5f7eba1c904e6a");
        //调用初始化对象里面的方法，传递request，获取数据
        response = client.getAcsResponse(request);
        List<GetPlayInfoResponse.PlayInfo> playInfoList = response.getPlayInfoList();
        //播放地址
        for (GetPlayInfoResponse.PlayInfo playInfo : playInfoList) {
            System.out.print("PlayInfo.PlayURL = " + playInfo.getPlayURL() + "\n");
        }
        //Base信息
        System.out.print("VideoBase.Title = " + response.getVideoBase().getTitle() + "\n");
    }

}
