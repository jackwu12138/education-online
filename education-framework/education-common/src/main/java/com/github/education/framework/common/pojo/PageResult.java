package com.github.education.framework.common.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 分页结果
 *
 * @param <T>
 * @author jackwu
 */
@ApiModel("分页结果")
@Data
@NoArgsConstructor
@AllArgsConstructor
public final class PageResult<T> implements Serializable {

    private static final long serialVersionUID = 9056411043515781783L;

    /**
     * 数据总条数
     */
    @ApiModelProperty(value = "数据总条数")
    private Long total;

    /**
     * 当前是第几页
     */
    @ApiModelProperty(value = "当前是第几页")
    private Long current;

    /**
     * 每页大小
     */
    @ApiModelProperty(value = "每页大小")
    private Long size;

    /**
     * 总页数
     */
    @ApiModelProperty(value = "总页数")
    private Long pages;

    /**
     * 数据列表
     */
    @ApiModelProperty(value = "数据列表")
    private List<T> data;
}
