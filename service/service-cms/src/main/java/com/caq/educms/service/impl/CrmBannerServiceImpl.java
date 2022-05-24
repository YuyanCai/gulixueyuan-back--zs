package com.caq.educms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.caq.educms.entity.CrmBanner;
import com.caq.educms.mapper.CrmBannerMapper;
import com.caq.educms.service.CrmBannerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 首页banner表 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2022-04-28
 */
@Service
public class CrmBannerServiceImpl extends ServiceImpl<CrmBannerMapper, CrmBanner> implements CrmBannerService {

    @Cacheable(value = "banner",key = "'selectIndexList'")
    @Override
    public List<CrmBanner> selectAllBanner() {

        //根据id进行降序排序，显示排列之后的前两条记录
        QueryWrapper<CrmBanner> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        //拼接sql语句
        queryWrapper.last("limit 2");
        List<CrmBanner> list = baseMapper.selectList(null);
        return list;
    }
}
