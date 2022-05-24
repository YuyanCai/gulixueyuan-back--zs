package com.caq.eduservice.client;

import com.caq.commonutils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@FeignClient(name = "service-vod")
@Component
public interface VodClient {

    //定义调用方法的路径
    @DeleteMapping("/eduVod/video/removeAliYunVideo/{id}")
    public R removeAlyVideo(@PathVariable("id") String id);

    @DeleteMapping("/eduVod/video/delete-batch")
    public R deleteBatch(@RequestParam("videoIdList") List<String> videoIdList);

}
