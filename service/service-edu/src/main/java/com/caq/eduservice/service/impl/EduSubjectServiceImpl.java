package com.caq.eduservice.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.caq.eduservice.entity.subject.EduSubject;
import com.caq.eduservice.entity.subject.OneSubject;
import com.caq.eduservice.entity.subject.TwoSubject;
import com.caq.eduservice.entity.excel.SubjectData;
import com.caq.eduservice.listener.SubjectExcelListener;
import com.caq.eduservice.mapper.EduSubjectMapper;
import com.caq.eduservice.service.EduSubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2022-04-17
 */
@Service
public class EduSubjectServiceImpl extends ServiceImpl<EduSubjectMapper, EduSubject> implements EduSubjectService {

    //添加课程分类
    @Override
    public void saveSubject(MultipartFile file, EduSubjectService subjectService) {

        try {
            //文件输入流
            InputStream in = file.getInputStream();

            //调用方法进行读取
            EasyExcel.read(in, SubjectData.class, new SubjectExcelListener(subjectService)).sheet().doRead();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<OneSubject> getAllOneTwoSubject() {
        //查询所有一级分类 parentid=0
        QueryWrapper<EduSubject> wrapperOne = new QueryWrapper<>();
        wrapperOne.eq("parent_id", "0");
        List<EduSubject> oneSubjectList = baseMapper.selectList(wrapperOne);
//        this.list()也可以通过这种方式调用查询。


        //查询所有二级分类 parentid!=0
        QueryWrapper<EduSubject> wrapperTwo = new QueryWrapper<>();
        wrapperOne.ne("parent_id", "0");
        List<EduSubject> twoSubjectList = baseMapper.selectList(wrapperTwo);


        //创建list集合，用于存放最终封装的数据
        List<OneSubject> finalSubjectList = new ArrayList<>();
        //封装一级分类
        //查询出来所有的一级分类list集合遍历，得到每一级分类对象，获得每个一级分类对象值
        //封装到要求的list集合里面
        for (int i = 0; i < oneSubjectList.size(); i++) {
            EduSubject eduSubject = oneSubjectList.get(i);
            OneSubject oneSubject = new OneSubject();
//            oneSubject.setId(eduSubject.getId());
//            oneSubject.setTitle(eduSubject.getTitle());
            //把eduSubject值复制到对应的oneSubject对象里面，两个对象里面的属性相同对应的的自动赋值
            BeanUtils.copyProperties(eduSubject, oneSubject);

            //在一级分类循环遍历查询所有的二级分类
            //创建list集合封装每个一级分类的二级分类
            List<TwoSubject> twoFinalSubjectList = new ArrayList<>();
            //遍历二级分类list集合
            for (int j = 0; j < twoSubjectList.size(); j++) {
                EduSubject tSubject = twoSubjectList.get(j);
                //如果二级分类的parentid和一级分类的id一样，就把它加入到一级分类
                if (tSubject.getParentId().equals(eduSubject.getId())) {
                    TwoSubject twoSubject = new TwoSubject();
                    BeanUtils.copyProperties(tSubject, twoSubject);
                    twoFinalSubjectList.add(twoSubject);
                }
            }
            //把一级下面所有的二级分类放到一级分类里面
            oneSubject.setChildren(twoFinalSubjectList);
            finalSubjectList.add(oneSubject);
        }
        return finalSubjectList;
    }


}
