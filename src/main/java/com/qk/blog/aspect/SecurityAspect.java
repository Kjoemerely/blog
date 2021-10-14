package com.qk.blog.aspect;

import com.qk.blog.annotation.IgnoreSecurity;
import com.qk.blog.common.BaseController;
import com.qk.blog.common.Result;
import com.qk.blog.service.TokenService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Method;

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
        //通过token获取用户信息
        String token = "GetTokenUtil.getToken()";
        // 从切点上获取目标方法
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        log.debug("methodSignature : " + methodSignature);
        Method method = methodSignature.getMethod();
        log.debug("Method : " + method.getName() + " : " + method.isAnnotationPresent(IgnoreSecurity.class));
        // 若目标方法忽略了安全性检查,则直接调用目标方法
        if (method.isAnnotationPresent(IgnoreSecurity.class)) {
            return pjp.proceed();
        }

        Result result = tokenService.checkLoginUser(token);
        if (result != null && !Result.RESULT_SUCCESS.equals(result.getCode())) {
            return result;
        }

        // 调用目标方法
        return pjp.proceed();
    }
}
