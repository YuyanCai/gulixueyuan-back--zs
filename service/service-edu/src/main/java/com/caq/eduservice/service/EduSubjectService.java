package com.caq.eduservice.service;

import com.caq.eduservice.entity.subject.EduSubject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.caq.eduservice.entity.subject.OneSubject;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author testjava
 * @since 2022-04-17
 */
public interface EduSubjectService extends IService<EduSubject> {

    void saveSubject(MultipartFile file,EduSubjectService subjectService);

    List<OneSubject> getAllOneTwoSubject();

}
