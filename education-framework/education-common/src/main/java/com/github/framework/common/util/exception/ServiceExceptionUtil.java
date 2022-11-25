package com.github.framework.common.util.exception;

import cn.hutool.core.util.StrUtil;
import com.github.framework.common.exception.ErrorCode;
import com.github.framework.common.exception.ServiceException;

/**
 * {@link ServiceException} 工具类
 *
 * @author jackwu
 */
public class ServiceExceptionUtil {

    public static ServiceException exception(ErrorCode errorCode) {
        return exception0(errorCode.getCode(), errorCode.getMsg());
    }

    public static ServiceException exception(ErrorCode errorCode, Object... params) {
        return exception0(errorCode.getCode(), errorCode.getMsg(), params);
    }

    private static ServiceException exception0(String code, String messagePattern, Object... params) {
        String message = StrUtil.format(messagePattern, params);
        return new ServiceException(code, message);
    }
}
