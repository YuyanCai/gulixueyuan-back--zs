package com.caq.eduservice.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.caq.eduservice.entity.teacher.EduTeacher;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author ${author}
 * @since 2022-04-09
 */
public interface EduTeacherService extends IService<EduTeacher> {


    Map<String, Object> getTeacherFrontList(Page<EduTeacher> pageParam);
}
