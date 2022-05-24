package com.caq.eduservice.entity.vo.chapter;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "章节信息")
public class ChapterVo {
    private String id;
    private String title;
    //小结
    private List<VideoVo> children = new ArrayList<>();
}
