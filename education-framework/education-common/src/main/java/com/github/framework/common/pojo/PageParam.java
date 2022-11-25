package com.github.framework.common.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;
import java.io.Serializable;

/**
 * 分页参数
 *
 * @author jackwu
 */
@ApiModel("分页参数")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageParam implements Serializable {

    /**
     * 默认情况下查询第几页
     */
    private static final Integer DEFAULT_PAGE = 1;

    /**
     * 默认情况下每页的大小
     */
    private static final Integer DEFAULT_SIZE = 10;

    @ApiModelProperty(value = "页码，从 1 开始", example = "1")
    @Min(value = 1, message = "页码最小值为 1")
    private Integer page = DEFAULT_PAGE;

    @ApiModelProperty(value = "每页条数，最大值为 100", example = "10")
    @Range(min = 10, max = 100, message = "每页条数在 10-100 之间")
    private Integer size = DEFAULT_SIZE;
}
