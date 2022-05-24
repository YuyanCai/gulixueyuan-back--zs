package com.caq.eduservice.service;

import com.caq.eduservice.entity.chapter.EduVideo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 课程视频 服务类
 * </p>
 *
 * @author testjava
 * @since 2022-04-18
 */
public interface EduVideoService extends IService<EduVideo> {

    void removeVideoByCourseId(String courseId);

}
