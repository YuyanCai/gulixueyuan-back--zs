package com.caq.educms.controller;


import com.caq.commonutils.R;
import com.caq.educms.entity.CrmBanner;
import com.caq.educms.service.CrmBannerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 首页banner表 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2022-04-28
 */
@RestController
@RequestMapping("/eduCms/bannerFront")
@CrossOrigin
public class BannerFrontController {
    @Autowired
    private CrmBannerService bannerService;

    //查询所有banner
    @GetMapping("getAllBanner")
    @ApiOperation(value = "获取首页banner")
    public R getAllBanner() {
        List<CrmBanner> list = bannerService.selectAllBanner();
        return R.ok().data("list", list);
    }

}

