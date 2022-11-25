package com.github.education.framework.swagger.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;

/**
 * Swagger 配置属性
 *
 * @author jackwu
 */
@Data
@Validated
@ConfigurationProperties("education.swagger")
public class SwaggerProperties {

    /**
     * 标题
     */
    @NotEmpty(message = "标题不能为空")
    private String title;

    /**
     * 描述
     */
    @NotEmpty(message = "描述不能为空")
    private String description;

    /**
     * 作者
     */
    @NotEmpty(message = "作者不能为空")
    private String author;

    /**
     * 版本
     */
    @NotEmpty(message = "版本不能为空")
    private String version;
}
