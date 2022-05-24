package com.caq.eduservice.controller;


import com.alibaba.excel.util.StringUtils;
import com.caq.commonutils.R;
import com.caq.eduservice.client.VodClient;
import com.caq.eduservice.entity.chapter.EduVideo;
import com.caq.eduservice.service.EduVideoService;
import com.caq.servicebase.exceptionhandle.Guliexception;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 课程视频 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2022-04-18
 */
@RestController
@RequestMapping("/eduService/video")
//@CrossOrigin
public class EduVideoController {
    @Autowired
    private EduVideoService videoService;

    @Autowired
    private VodClient vodClient;

    //添加小节
    @PostMapping("addVideo")
    public R addVideo(@RequestBody EduVideo eduVideo) {
        videoService.save(eduVideo);
        return R.ok();
    }

    //删除小节
    // TODO 后面这个方法需要完善：删除小节时候，同时把里面视频删除
    @DeleteMapping("{id}")
    public R deleteVideo(@PathVariable String id) {
        EduVideo eduVideo = videoService.getById(id);
        String videoSourceId = eduVideo.getVideoSourceId();
        //判断小节里面是否有视频id。没有的话就不调用
        if (!StringUtils.isEmpty(videoSourceId)) {
            R result = vodClient.removeAlyVideo(videoSourceId);
            if (result.getCode() == 20001) {
                throw new Guliexception(20001, "删除视频失败，熔断器。。。。。。。");
            }
        }

        /**
         * 先删视频在删小节，删除小节再删视频的话小节的信息也会被删除
         */
        //删除小节
        boolean b = videoService.removeById(id);
        if (b) {
            return R.ok();
        } else {
            return R.error();
        }

    }

    //修改小节 TODO

}

