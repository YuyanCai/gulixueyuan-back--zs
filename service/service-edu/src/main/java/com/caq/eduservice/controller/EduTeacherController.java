package com.caq.eduservice.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.caq.commonutils.R;
import com.caq.eduservice.entity.teacher.EduTeacher;
import com.caq.eduservice.entity.vo.TeacherQuery;
import com.caq.eduservice.service.EduTeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2022-04-09
 */
@Api(tags ="讲师管理")
@RestController
@RequestMapping("/eduService/teacher")
//@CrossOrigin
public class EduTeacherController {

    //把service注入
    @Autowired
    private EduTeacherService teacherService;

    //1、查询讲师所有数据
    //rest风格
//    get请求，post请求
    @GetMapping("findAll")
    @ApiOperation("所有讲师管理")
    public R findAllTeacher() {
        //调用service的方法，实现查询所有的方法
        List<EduTeacher> list = teacherService.list(null);
        return R.ok().data("items", list);
    }

    //2、逻辑删除讲师

    /**
     * {id}代表id值需要通过路径传id值
     *
     * @param id
     * @return
     * @Pathvariable 代表得到路径中的id值
     */
    @ApiOperation("逻辑删除讲师")
    @DeleteMapping("{id}")
    public R deleteTeacherById(@ApiParam(name = "id", value = "讲师ID", required = true) @PathVariable String id) {
        boolean flag = teacherService.removeById(id);
        if (flag) {
            return R.ok();
        } else {
            return R.error();
        }
    }

    /**
     * 3、分页查询讲师功能
     * current  当前页
     * limit    每页记录数
     *
     * @param current
     * @param limit
     * @return
     */
    @ApiOperation("分页查询讲师功能")
    @GetMapping("pageTeacher/{current}/{limit}")
    public R pageTeacher(@PathVariable long current,
                         @PathVariable long limit) {

        //创建page对象
        Page<EduTeacher> pageTeacher = new Page<>(current, limit);
        //调用方法实现分页
        //调用方法的时候，底层封装，把分页所有数据封装到pageTeacher对象里面
        teacherService.page(pageTeacher, null);

//        模拟一个异常
//        try {
//            int i = 10/0;
//        } catch (Exception e) {
//            /**执行自定义异常
//             * 传入的参数是自己写的异常类的构造方法的参数，这样能让代码更通用
//             */
//            throw new Guliexception(20001,"执行了自定义异常处理.....");
//        }

        long total = pageTeacher.getTotal();
        List<EduTeacher> records = pageTeacher.getRecords();

        Map<String, Object> map = new HashMap();
        map.put("total", total);
        map.put("rows", records);
        return R.ok().data(map);
//        两种方式都可以
//        return R.ok().data("total",total).data("rows",records);
    }

    //4、条件查询加分页查询

    /**
     * @param current
     * @param limit
     * @param teacherQuery
     * @return
     * @requestbody注解的作用是使用json传递数据，并把json封装到对应对象里面
     */
    @ApiOperation("分页查询和多条件查询")
    @PostMapping("pageTeacherCondition/{current}/{limit}")
    public R pageTeacherCondition(@PathVariable long current,
                                  @PathVariable long limit,
                                  @RequestBody(required = false) TeacherQuery teacherQuery) {
        Page<EduTeacher> pageTeacher = new Page<>(current, limit);
        //构建条件
        QueryWrapper<EduTeacher> wrapper = new QueryWrapper<>();
//        多条件组合查询
        Integer level = teacherQuery.getLevel();
        String name = teacherQuery.getName();
        String begin = teacherQuery.getBegin();
        String end = teacherQuery.getEnd();
        //判断条件值是否为空，如果不为空拼接条件
        if (!StringUtils.isEmpty(name)) {
            //构建条件
            wrapper.like("name", name);
        }
        if (!StringUtils.isEmpty(level)) {
            wrapper.eq("level", level);
        }
        if (!StringUtils.isEmpty(begin)) {
            wrapper.ge("gmt_create", begin);
        }
        if (!StringUtils.isEmpty(end)) {
            wrapper.eq("gmt_modified", end);
        }

        //排序，新创建的在后面
        wrapper.orderByDesc("gmt_create");

//        调用方法实现条件查询分页
        teacherService.page(pageTeacher, wrapper);
        long total = pageTeacher.getTotal();
        List<EduTeacher> records = pageTeacher.getRecords();
        return R.ok().data("total", total).data("rows", records);
    }

    /**添加讲师接口的方法
     * 添加讲师接口的意思就是添加一个映射
     * @return
     */
    @ApiOperation("增加讲师功能")
    @PostMapping("addTeacher")
    public R addTeacher(@RequestBody EduTeacher eduTeacher){
        boolean save = teacherService.save(eduTeacher);
        if (save){
            return R.ok();
        }else {
            return R.error();
        }
    }


    @ApiOperation("获得某个讲师")
    @GetMapping("getTeacher/{id}")
    public R getTeacher(@PathVariable String id){
        EduTeacher eduTeacher = teacherService.getById(id);
        return R.ok().data("teacher",eduTeacher);
    }


    //讲师修改功能
    @ApiOperation("修改讲师")
    @PostMapping("updateTeacher")
    public R updateTeacher(@RequestBody EduTeacher eduTeacher){
        boolean flag = teacherService.updateById(eduTeacher);
        if (flag){
            return R.ok();
        }else {
            return R.error();
        }
    }

}

