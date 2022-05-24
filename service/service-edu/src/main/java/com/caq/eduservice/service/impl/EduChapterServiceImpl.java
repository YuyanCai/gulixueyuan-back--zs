package com.caq.eduservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.caq.eduservice.entity.chapter.EduChapter;
import com.caq.eduservice.entity.chapter.EduVideo;
import com.caq.eduservice.entity.vo.chapter.ChapterVo;
import com.caq.eduservice.entity.vo.chapter.VideoVo;
import com.caq.eduservice.mapper.EduChapterMapper;
import com.caq.eduservice.service.EduChapterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.caq.eduservice.service.EduVideoService;
import com.caq.servicebase.exceptionhandle.Guliexception;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2022-04-18
 */
@Service
public class EduChapterServiceImpl extends ServiceImpl<EduChapterMapper, EduChapter> implements EduChapterService {

    @Autowired
    private EduVideoService videoService;//注入小节service

    @Override
    public List<ChapterVo> getChapterVideoByCourseId(String courseId) {

        //根据课程id查询课程里面所有章节
        QueryWrapper<EduChapter> eduChapterQueryWrapper = new QueryWrapper<EduChapter>();
        eduChapterQueryWrapper.eq("course_id", courseId);
        List<EduChapter> eduChapterList = baseMapper.selectList(eduChapterQueryWrapper);

        //根据课程id查询课程里面所有的小节
        QueryWrapper<EduVideo> eduVideoQueryWrapper = new QueryWrapper<>();
        eduVideoQueryWrapper.eq("course_id", courseId);
        List<EduVideo> eduVideoList = videoService.list(eduVideoQueryWrapper);

        List<ChapterVo> finalList = new ArrayList<>();

        //遍历查询章节list集合进行封装
        for (int i = 0; i < eduChapterList.size(); i++) {
            //每个章节
            ChapterVo chapterVo = new ChapterVo();
            EduChapter eduChapter = eduChapterList.get(i);
            BeanUtils.copyProperties(eduChapter, chapterVo);
            //创建集合，用于封装章节的小节
            List<VideoVo> videoList = new ArrayList<>();
            for (int j = 0; j < eduVideoList.size(); j++) {
                EduVideo eduVideo = eduVideoList.get(j);
                //判断 小节里面的chapterid和章节里面的id是否一样
                if (eduVideo.getChapterId().equals(eduChapter.getId())) {
                    //进行封装
                    VideoVo videoVo = new VideoVo();
                    BeanUtils.copyProperties(eduVideo, videoVo);
                    //放到封装到小节集合
                    videoList.add(videoVo);
                }
            }
            chapterVo.setChildren(videoList);
            finalList.add(chapterVo);

        }
        //遍历查询小结list集合进行封装
        return finalList;
    }

    @Override
    public boolean deleteChapter(String chapterId) {
        //根据chapterid章节id 查询小节表，如果查询数据，不进行删除
        QueryWrapper<EduVideo> wrapper = new QueryWrapper<>();
        wrapper.eq("chapter_id",chapterId);
        //根据 Wrapper 条件，查询总记录数
        int count = videoService.count(wrapper);
        //判断
        if(count >0) {//查询出小节，不进行删除
            throw new Guliexception(20001,"不能删除");
        } else { //不能查询数据，进行删除
            //删除章节
            int result = baseMapper.deleteById(chapterId);
            //成功  1>0   0>0
            return result>0;
        }
    }

    //根据课程id删除章节
    @Override
    public void removeChapterByCourseId(String courseId) {
        QueryWrapper<EduChapter> wrapper = new QueryWrapper<>();
        wrapper.eq("course_id",courseId);
        baseMapper.delete(wrapper);
    }
}
