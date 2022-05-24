package com.caq.educms.service;

import com.caq.educms.entity.CrmBanner;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 首页banner表 服务类
 * </p>
 *
 * @author testjava
 * @since 2022-04-28
 */
public interface CrmBannerService extends IService<CrmBanner> {

    List<CrmBanner> selectAllBanner();
}
