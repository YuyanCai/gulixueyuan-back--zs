package com.caq.eduservice.entity.teacher;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 讲师
 * </p>
 *
 * @author ${author}
 * @since 2022-04-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class EduTeacher implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "讲师ID")
    /**
     * 分布式应用时，我们需要生成分布式ID，可以选择使用@TableId(type=IdType.ID_WORKER)，数据库中的主键为：
     * IdType包括以下几类：
     * AUTO : 数据库主键自增
     * INPUT: 用户自行输入
     * ID_WORKER: 分布式全局唯一ID， 长整型
     * UUID: 32位UUID字符串
     * NONE: 无状态
     * ID_WORKER_STR: 分布式全局唯一ID 字符串类型
     */
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    @ApiModelProperty(value = "讲师姓名")
    private String name;

    @ApiModelProperty(value = "讲师简介")
    private String intro;

    @ApiModelProperty(value = "讲师资历，一句话说明讲师")
    private String career;

    @ApiModelProperty(value = "头衔：1高级讲师，2首席讲师")
    private Integer level;

    @ApiModelProperty(value = "讲师头像")
    private String avatar;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "0（false）未删除，1（true）已删除")
    @TableLogic
    private Boolean isDeleted;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill= FieldFill.INSERT)
    private Date gmtCreate;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill=FieldFill.INSERT_UPDATE)
    private Date gmtModified;

}
