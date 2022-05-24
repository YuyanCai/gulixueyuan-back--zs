package com.caq.eduservice.service;

import com.caq.eduservice.entity.chapter.EduChapter;
import com.baomidou.mybatisplus.extension.service.IService;
import com.caq.eduservice.entity.vo.chapter.ChapterVo;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author testjava
 * @since 2022-04-18
 */
public interface EduChapterService extends IService<EduChapter> {
    List<ChapterVo> getChapterVideoByCourseId(String courseId);

    //删除章节的方法
    boolean deleteChapter(String chapterId);

    void removeChapterByCourseId(String courseId);
}
