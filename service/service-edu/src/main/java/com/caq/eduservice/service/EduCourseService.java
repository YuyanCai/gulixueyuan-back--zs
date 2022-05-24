package com.caq.eduservice.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.caq.eduservice.entity.chapter.EduCourse;
import com.baomidou.mybatisplus.extension.service.IService;
import com.caq.eduservice.entity.frontvo.CourseFrontVo;
import com.caq.eduservice.entity.frontvo.CourseWebVo;
import com.caq.eduservice.entity.teacher.EduTeacher;
import com.caq.eduservice.entity.vo.CourseQuery;
import com.caq.eduservice.entity.vo.TeacherQuery;
import com.caq.eduservice.entity.vo.chapter.CourseInfoVo;
import com.caq.eduservice.entity.vo.chapter.CoursePublishVo;

import java.util.Map;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author testjava
 * @since 2022-04-18
 */
public interface EduCourseService extends IService<EduCourse> {

    //添加课程基本信息的方法
    String saveCourseInfo(CourseInfoVo courseInfoVo);

    //根据课程id查询课程基本信息
    CourseInfoVo getCourseInfo(String courseId);

    //修改课程信息
    void updateCourseInfo(CourseInfoVo courseInfoVo);

    //根据课程id查询课程确认信息
    CoursePublishVo publishCourseInfo(String id);

    //删除课程
    void removeCourse(String courseId);

    Map<String, Object> getCourseFrontList(Page<EduCourse> pageCourse, CourseFrontVo courseFrontVo);

    CourseWebVo getBaseCourseInfo(String courseId);
}
