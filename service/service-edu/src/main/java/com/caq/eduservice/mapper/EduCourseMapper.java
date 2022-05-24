package com.caq.eduservice.mapper;

import com.caq.eduservice.entity.chapter.EduCourse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.caq.eduservice.entity.frontvo.CourseWebVo;
import com.caq.eduservice.entity.vo.chapter.CoursePublishVo;

/**
 * <p>
 * 课程 Mapper 接口
 * </p>
 *
 * @author testjava
 * @since 2022-04-18
 */
public interface EduCourseMapper extends BaseMapper<EduCourse> {
    public CoursePublishVo getPublishCourseInfo(String courseId);

    //根据课程id，编写sql语句查询课程信息
    CourseWebVo getBaseCourseInfo(String courseId);

}
