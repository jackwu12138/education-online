package com.github.framework.common.exception;

import com.github.framework.common.util.exception.ServiceExceptionUtil;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 全局错误码, 由五位组成
 * <p>
 * 第一位:
 * A: 代表用户端错误 B: 代表当前服务异常 C: 代表第三方服务异常
 * <p>
 * 若无法确认错误信息, 请选择宏观错误
 * <p>
 * 各大类之间预留 100 的步长距离
 * <p>
 * 当遇到需要动态展示的信息时, 请使用'{}'作为占位符,
 * 并调用{@link ServiceExceptionUtil#exception(ErrorCode, Object...)}方法,
 * 将需要动态显示的参数作为 param 传递进去
 *
 * @author jackwu
 */
@Data
@AllArgsConstructor
public class ErrorCode {

    /**
     * 错误码
     */
    private final String code;

    /**
     * 错误提示
     */
    private final String msg;
}
