package com.caq.eduorder.client;

import com.caq.commonutils.ordervo.CourseWebVoOrder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Component
@FeignClient(name = "service-edu")
public interface EduClient {

    //根据课程id查询课程信息
    @PostMapping("/eduService/courseFront/getCourseInfoOrder/{courseId}")
    public CourseWebVoOrder getCourseInfoOrder(@PathVariable("courseId") String courseId);

}
