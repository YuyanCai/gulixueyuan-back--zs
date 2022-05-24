package com.caq.eduservice.entity.vo.chapter;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "小结信息")
@Data
public class VideoVo {
    private String id;
    private String title;
    private String videoSourceId;
}

