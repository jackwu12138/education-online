package com.github.framework.common.pojo;

import com.github.framework.common.exception.ErrorCode;
import lombok.Data;

import java.io.Serializable;

import static com.github.framework.common.exception.constants.GlobalErrorCodeConstants.SUCCESS;

/**
 * @author jackwu
 */
@Data
public class CommonResult<T> implements Serializable {

    /**
     * 错误码
     *
     * @see ErrorCode#getCode()
     */
    private String code;

    /**
     * 错误提示，用户可阅读
     *
     * @see ErrorCode#getMsg()
     */
    private String msg;

    /**
     * 返回数据
     */
    private T data;

    public static <T> CommonResult<T> success() {
        CommonResult<T> result = new CommonResult<>();
        result.code = SUCCESS.getCode();
        result.msg = SUCCESS.getMsg();
        return result;
    }

    public static <T> CommonResult<T> success(T data) {
        CommonResult<T> result = new CommonResult<>();
        result.code = SUCCESS.getCode();
        result.data = data;
        result.msg = SUCCESS.getMsg();
        return result;
    }

    public static <T> CommonResult<T> error(String code, String message) {
        CommonResult<T> result = new CommonResult<>();
        result.code = code;
        result.msg = message;
        return result;
    }

    public static <T> CommonResult<T> error(ErrorCode errorCode) {
        return error(errorCode.getCode(), errorCode.getMsg());
    }
}
