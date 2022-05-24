package com.caq.eduservice.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.caq.eduservice.entity.subject.EduSubject;
import com.caq.eduservice.entity.excel.SubjectData;
import com.caq.eduservice.service.EduSubjectService;
import com.caq.servicebase.exceptionhandle.Guliexception;

import java.util.Map;

public class SubjectExcelListener extends AnalysisEventListener<SubjectData> {
    //因为SubjectExcelLinster不能交给spring管理，需要自己new出来，不能注入其他对象
    //不能实现数据库操作
    //解决方案就是手动把EduSubjectService注入，这样就可以调用数据库了
    public EduSubjectService eduSubjectService;
    public SubjectExcelListener() {}
    public SubjectExcelListener(EduSubjectService eduSubjectService) {
        this.eduSubjectService = eduSubjectService;
    }


    //一行一行读取excel表格内容
    public void invoke(SubjectData subjectData, AnalysisContext analysisContext) {
        if (subjectData==null){
            throw new Guliexception(20001,"文件数据为空");
        }

        //一行一行读取，每次读取有2个值，第一个一级分类，第二个二级分类
        //判断一级分类是否重复
        EduSubject existOneSubject = this.existOneSubject(eduSubjectService, subjectData.getOneSubjectName());
        if (existOneSubject==null){ //没有相同一级目录进行添加
            existOneSubject = new EduSubject();
            existOneSubject.setParentId("0");
            existOneSubject.setTitle(subjectData.getOneSubjectName());
            eduSubjectService.save(existOneSubject);
        }

        //判断二级分类是否重复
        String pid= existOneSubject.getId();//获取一级分类id的值
        EduSubject existTwoSubject = this.existTwoSubject(eduSubjectService, subjectData.getTwoSubjectName(), pid);
        if (existTwoSubject==null){
            existTwoSubject = new EduSubject();
            existTwoSubject.setParentId(pid);
            existTwoSubject.setTitle(subjectData.getTwoSubjectName());
            eduSubjectService.save(existTwoSubject);
        }

    }

    //判断一级分类不能重复添加
    private EduSubject existOneSubject(EduSubjectService eduSubjectService,String name){
        LambdaQueryWrapper<EduSubject> queryWrapper = new LambdaQueryWrapper<EduSubject>();
        queryWrapper.eq(EduSubject::getTitle,name)
                .eq(EduSubject::getParentId,"0");
        EduSubject one = eduSubjectService.getOne(queryWrapper);
        return one;
    }

    //判断二级分类不能重复添加
    private EduSubject existTwoSubject(EduSubjectService eduSubjectService,String name,String pid){
        LambdaQueryWrapper<EduSubject> queryWrapper = new LambdaQueryWrapper<EduSubject>();
        queryWrapper.eq(EduSubject::getTitle,name)
                .eq(EduSubject::getParentId,pid);
        EduSubject two = eduSubjectService.getOne(queryWrapper);
        return two;

    }

    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
    }
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }

}
