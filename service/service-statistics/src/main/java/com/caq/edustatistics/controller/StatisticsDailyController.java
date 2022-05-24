package com.caq.edustatistics.controller;


import com.caq.commonutils.R;
import com.caq.edustatistics.client.UcenterClient;
import com.caq.edustatistics.service.StatisticsDailyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 网站统计日数据 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2022-05-17
 */
@RestController
@RequestMapping("/eduStatistics/sta")
@RefreshScope //支持Nacos的动态刷新功能。
//@CrossOrigin
public class StatisticsDailyController {

    @Autowired
    private StatisticsDailyService staService;

    //统计某一天注册人数,生成统计数据
    @PostMapping("registerCount/{day}")
    public R registerCount(@PathVariable String day) {
        staService.registerCount(day);
        return R.ok();
    }

    //图表显示，返回两部分数据，日期json数组，数量json数组
    @GetMapping("showData/{type}/{begin}/{end}")
    public R showData(@PathVariable String type,@PathVariable String begin,
                      @PathVariable String end) {
        Map<String,Object> map = staService.getShowData(type,begin,end);
        return R.ok().data(map);
    }

}

