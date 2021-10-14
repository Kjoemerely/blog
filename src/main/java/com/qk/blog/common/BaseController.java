package com.qk.blog.common;

import com.qk.blog.exception.ResultException;
import com.qk.blog.service.LogService;
import com.qk.blog.service.UserService;
import com.qk.blog.vo.LoginUserVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.annotation.Resource;

/**
 * 基础控制类
 *
 * @author qk
 * @since 2021/10/14 15:14
 */
public class BaseController {

    @Resource
    private UserService userService;
    @Resource
    private LogService logService;

    /**
     * Logger日志
     */
    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * 初始化Controller返回结果
     *
     * @return 通用返回结果，默认成功
     */
    protected Result getResult() {
        return new Result();
    }

    /**
     * 处理异常信息返回
     *
     * @param result 通用返回结果
     * @param e 异常信息
     * @return 通用返回结果
     */
    protected Result error(Result result, Exception e) {
        if (e instanceof ResultException) {
            ResultException exception = (ResultException) e;
            result.setCode(exception.getCode());
            result.setMessage(exception.getMessage());
        } else {
            result = new Result();
            result.setCode(Result.RESULT_ERROR);
            result.setMessage(Result.RESULT_ERROR_MSG);
        }
        log.error("系统异常!", e);
        return result;
    }

    /**
     * 处理异常信息，写入日志
     *
     * @param result 通用返回结果
     * @param e 异常信息
     * @param message 错误信息
     * @param objects 对象类
     * @return 通用返回结果
     */
    protected Result error(Result result, Exception e, String message, Object... objects) {
        log.error(message, objects);
        return this.error(result, e);
    }

    /**
     * 捕获接口参数异常信息
     * 继承BaseController类即可
     *
     * @param e 异常信息
     * @return 对象信息
     */
    @ExceptionHandler(Exception.class)
    public Object exceptionHandler(Exception e) {
        if (!(e instanceof ResultException)) {
            logService.addExceptionLog(e);
        }
        e.printStackTrace();
        log.error(getClass() + "异常:{}", e.getMessage());
        return null;
    }

//    public Result genSuccessResult(Result result) {
//        if (Result.RESULT_SUCCESS.equals(result.getCode())) {
//            return result;
//        }
//        if (Result.RESULT_ERROR.equals(result.getCode())) {
//            return result;
//        }
//    }

    /**
     * 获取登录用户信息
     *
     * @return 登录用户信息
     */
    protected LoginUserVo getLoginUserInfo() throws Exception {
        return userService.getLoginUser();
    }

}
