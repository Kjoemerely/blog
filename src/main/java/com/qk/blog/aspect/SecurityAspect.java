package com.qk.blog.aspect;

import com.qk.blog.annotation.IgnoreSecurity;
import com.qk.blog.common.BaseController;
import com.qk.blog.common.Result;
import com.qk.blog.service.TokenService;
import com.qk.blog.utils.TokenUtil;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * 安全检查切面(是否登录检查)
 *
 * @author admin
 * @since 2021/10/14 15:14
 */
@Aspect
@Component
public class SecurityAspect extends BaseController {

    @Resource
    private TokenService tokenService;

    @Pointcut("execution(* com.qk.blog.controller..*.*(..))")
    public void pointCut() {
    }

    @Around("pointCut()")
    public Object execute(ProceedingJoinPoint pjp) throws Throwable {
        // 从切点上获取目标方法
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        log.debug("methodSignature : " + methodSignature);
        Method method = methodSignature.getMethod();
        log.debug("Method : " + method.getName() + " : " + method.isAnnotationPresent(IgnoreSecurity.class));
        // 若目标方法忽略了安全性检查,则直接调用目标方法
        if (method.isAnnotationPresent(IgnoreSecurity.class)) {
            return pjp.proceed();
        }
        //通过token获取用户信息
        String token = TokenUtil.getToken();
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        if (StringUtils.isBlank(token)) {
            // 跳转回登录页面，并返回错误信息
            request.getSession().setAttribute("errorMsg", "用户未登录");
            return "user/login";
        }
        // 校验用户登录情况
        Result result = tokenService.checkLoginUser(token);
        if (result != null && !Result.RESULT_SUCCESS.equals(result.getCode())) {
            // 跳转回登录页面，并返回错误信息
            request.getSession().setAttribute("errorMsg", result.getMessage());
            return "user/login";
        }
        // 调用目标方法
        return pjp.proceed();
    }

}
