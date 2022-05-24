package com.caq.eduservice.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.caq.commonutils.R;
import com.caq.eduservice.entity.chapter.EduCourse;
import com.caq.eduservice.entity.teacher.EduTeacher;
import com.caq.eduservice.entity.vo.CourseQuery;
import com.caq.eduservice.entity.vo.chapter.CourseInfoVo;
import com.caq.eduservice.entity.vo.chapter.CoursePublishVo;
import com.caq.eduservice.service.EduCourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections4.Put;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2022-04-18
 */
@RestController
@RequestMapping("/eduService/course")
//@CrossOrigin
@Api(tags = "课程管理")
public class EduCourseController {

    @Autowired
    private EduCourseService courseService;

    @GetMapping("findAll")
    @ApiOperation("所有课程管理")
    public R findAllTeacher() {
        //调用service的方法，实现查询所有的方法
        List<EduCourse> list = courseService.list(null);
        return R.ok().data("items", list);
    }

    @ApiOperation("分页查询和多条件查询")
    @PostMapping("pageCourseCondition/{current}/{limit}")
    public R pageCourseCondition(@PathVariable long current,
                                 @PathVariable long limit,
                                 @RequestBody(required = false) CourseQuery courseQuery) {
        Page<EduCourse> pageCourse = new Page<>(current, limit);
        //构建条件
        QueryWrapper<EduCourse> wrapper = new QueryWrapper<>();
//        多条件组合查询
        String title = courseQuery.getTitle();
        String status = courseQuery.getStatus();

        //判断条件值是否为空，如果不为空拼接条件
        if (!StringUtils.isEmpty(title)) {
            //构建条件
            wrapper.like("title", title);
        }
        if (!StringUtils.isEmpty(status)) {
            wrapper.eq("status", status);
        }
        //排序，新创建的在后面
        wrapper.orderByDesc("gmt_create");

//        调用方法实现条件查询分页
        courseService.page(pageCourse, wrapper);
        long total = pageCourse.getTotal();
        List<EduCourse> records = pageCourse.getRecords();
        return R.ok().data("total", total).data("rows", records);
    }

    @ApiOperation("分页查询课程")
    @PostMapping("pageCourse/{current}/{limit}")
    public R pageCourse(@PathVariable long current,
                        @PathVariable long limit
                        ) {
        //创建page对象
        Page<EduCourse> pageCourse = new Page<>(current, limit);

        //调用方法实现分页
        courseService.page(pageCourse, null);
        long total = pageCourse.getTotal();
        List<EduCourse> records = pageCourse.getRecords();
        Map<String, Object> map = new HashMap();
        map.put("total", total);
        map.put("rows", records);
        return R.ok().data(map);
    }


    //添加课程基本信息的方法
    @PostMapping("addCourseInfo")
    public R addCourseInfo(@RequestBody CourseInfoVo courseInfoVo) {
        //返回添加之后课程id，为了后面添加大纲使用
        String id = courseService.saveCourseInfo(courseInfoVo);
        return R.ok().data("courseId", id);
    }

    //根据课程id查询课程基本信息
    @GetMapping("getCourseInfo/{courseId}")
    public R getCourseInfo(@PathVariable String courseId) {
        CourseInfoVo courseInfoVo = courseService.getCourseInfo(courseId);
        return R.ok().data("courseInfoVo", courseInfoVo);
    }

    //修改课程信息
    @PostMapping("updateCourseInfo")
    public R updateCourseInfo(@RequestBody CourseInfoVo courseInfoVo) {
        courseService.updateCourseInfo(courseInfoVo);
        return R.ok();
    }

    //根据课程id查询课程确认信息
    @GetMapping("getPublishCourseInfo/{id}")
    public R getPublishCourseInfo(@PathVariable String id) {
        CoursePublishVo coursePublishVo = courseService.publishCourseInfo(id);
        return R.ok().data("publishCourse", coursePublishVo);
    }

    //课程最终发布
    //修改课程状态
    @PostMapping("publishCourse/{id}")
    public R publishCourse(@PathVariable String id) {
        EduCourse eduCourse = new EduCourse();
        eduCourse.setId(id);
        eduCourse.setStatus("Normal");//设置课程发布状态
        courseService.updateById(eduCourse);
        return R.ok();
    }

    //删除课程
    @DeleteMapping("deleteCourse/{courseId}")
    public R deleteCourse(@PathVariable String courseId) {
        courseService.removeCourse(courseId);
        return R.ok();
    }

}

