package com.caq.educms.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.caq.commonutils.R;
import com.caq.educms.entity.CrmBanner;
import com.caq.educms.service.CrmBannerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 首页banner表 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2022-04-28
 */
@RestController
@RequestMapping("/eduCms/bannerAdmin")
@CrossOrigin
public class BannerAdminController {

//   1 分页查询banner

    /**
     * 分页查询，两个参数，page当前也，limit代表每页记录数
     *
     * @PathVariable参数用来获取路径中的参数
     * @param page
     * @param limit
     * @return
     */

    @Autowired
    private CrmBannerService crmBannerService;

    //分页查询banner
    @ApiOperation(value = "获取Banner分页列表")
    @GetMapping("pageBanner/{page}/{limit}")
    public R pageBanner(@PathVariable long page, @PathVariable long limit) {

        Page<CrmBanner> pageBanner = new Page<>(page, limit);
        crmBannerService.page(pageBanner, null);
        return R.ok()
                .data("items", pageBanner.getRecords())
                .data("total", pageBanner.getTotal());
    }

    //添加banner

    /**
     * @RequestBody接收前端传递给后端的json字符串
     * @param crmBanner
     * @return
     */
    @ApiOperation(value = "新增Banner")
    @PostMapping("addBanner")
    public R addBanner(@RequestBody CrmBanner crmBanner) {
        crmBannerService.save(crmBanner);
        return  R.ok();
    }


    //通过id获取信息
    @ApiOperation(value = "获取Banner")
    @GetMapping("get/{id}")
    public R getById(@PathVariable String id){
        CrmBanner crmBanner = crmBannerService.getById(id);
        return R.ok().data("item",crmBanner);
    }


    //修改banner
    @PutMapping("update")
    @ApiOperation(value = "修改Banner")
    public R updateBanner(@RequestBody CrmBanner crmBanner){
        boolean b = crmBannerService.updateById(crmBanner);
        if(b){
            return R.ok();
        }
        else{
            return R.error();
        }
    }

    @DeleteMapping("remove/{id}")
    @ApiOperation(value = "删除Banner")
    public R remove(@PathVariable String id){
        boolean b = crmBannerService.removeById(id);
        if(b){
            return R.ok();
        }
        else{
            return R.error();
        }
    }
}

