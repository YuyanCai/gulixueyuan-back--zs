package com.caq.eduservice.controller.front;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.caq.commonutils.R;
import com.caq.eduservice.entity.chapter.EduCourse;
import com.caq.eduservice.entity.teacher.EduTeacher;
import com.caq.eduservice.service.EduCourseService;
import com.caq.eduservice.service.EduTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/eduService/indexFront")
@CrossOrigin
public class IndexFrontController {

    @Autowired
    private EduCourseService courseService;

    @Autowired
    private EduTeacherService eduTeacherService;

    //查询前8条热门课程，查询前4条名师
    @GetMapping("index")
    public R index(){
        QueryWrapper<EduCourse> wrapper = new QueryWrapper<EduCourse>();
        wrapper.orderByDesc("id");
        wrapper.last("limit 8");
        List<EduCourse> eduList = courseService.list(wrapper);

        QueryWrapper<EduTeacher> wrapperTeacher = new QueryWrapper<EduTeacher>();
        wrapperTeacher.orderByDesc("id");
        wrapperTeacher.last("limit 4");
        List<EduTeacher> teacherList = eduTeacherService.list(wrapperTeacher);

        return R.ok().data("eduList",eduList).data("teacherList",teacherList);
    }



}
