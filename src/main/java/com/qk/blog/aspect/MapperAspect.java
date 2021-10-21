package com.qk.blog.aspect;

import com.qk.blog.annotation.IgnoreLoginUser;
import com.qk.blog.common.BaseModel;
import com.qk.blog.enums.StatusEnum;
import com.qk.blog.model.SysLogModel;
import com.qk.blog.model.UserModel;
import com.qk.blog.service.UserService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author admin
 *
 * mapper切面，更新公共字段
 */
@Aspect
@Component
public class MapperAspect {

    @Resource
    private UserService userService;

    @Before("execution(* com.qk.blog.dao.*.*(..))")
    public void beforeMethod(JoinPoint joinPoint) throws Exception {
        // 从切点上获取目标方法
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        //获取方法名
        String methodName = methodSignature.getName();
        //方法类
        Method method = methodSignature.getMethod();

        //处理新增、删除、修改方法
        if (methodName.startsWith("insert")
                || methodName.startsWith("add")
                || methodName.startsWith("update")
                || methodName.startsWith("save")
                || methodName.startsWith("remove")
                || methodName.startsWith("delete")
                || methodName.startsWith("change")
                || methodName.startsWith("reset")) {

            //获取方法参数
            Object[] args = joinPoint.getArgs();
            for (Object arg : args) {
                this.setModel(arg, methodName, method);
                if (arg instanceof List) {
                    for (Object obj : (List) arg) {
                        this.setModel(obj, methodName, method);
                    }
                }
            }
        }
    }

    /**
     * 是否是日志相关操作（日志相关操作不需要）
     *
     * @param method
     * @return
     */
    private boolean isLogUpdate(Method method) {
        return method.getParameterTypes().length > 0 && method.getParameterTypes()[0].getName().contains(SysLogModel.class.getName());
    }

    /**
     * 设置操作用户
     *
     * @param arg
     * @param methodName
     */
    private void setModel(Object arg, String methodName, Method method) throws Exception {
        if (arg instanceof BaseModel) {
            UserModel userModel = null;

            //设置处理人信息
            BaseModel baseModel = (BaseModel) arg;
            LocalDateTime now = LocalDateTime.now();
            //新增设置创建人id和创建时间
            if (methodName.startsWith("insert") || methodName.startsWith("add") || methodName.startsWith("save")) {
                baseModel.setStatus(StatusEnum.NORMAL.getCode());
                if (baseModel.getCreateUserId() == null || baseModel.getCreateUserName() == null) {
                    userModel = getUserModel(method);
                    baseModel.setCreateUserId(userModel.getId());
                    baseModel.setCreateUserName(userModel.getUserName());
                }
                if (baseModel.getCreateTime() == null) {
                    baseModel.setCreateTime(now);
                }
            }
            if (baseModel.getUpdateUserId() == null || baseModel.getUpdateUserName() == null) {
                if (userModel == null) {
                    userModel = getUserModel(method);
                }
                baseModel.setUpdateUserId(userModel.getId());
                baseModel.setUpdateUserName(userModel.getUserName());
            }
            if (baseModel.getUpdateTime() == null) {
                baseModel.setUpdateTime(now);
            }
        }

    }

    private UserModel getUserModel(Method method) throws Exception {
        UserModel userModel;
        if (!method.isAnnotationPresent(IgnoreLoginUser.class) && !isLogUpdate(method)) {
            //获取登录用户信息
            userModel = userService.getLoginUser();
        } else {
            userModel = new UserModel();
            userModel.setId(-1L);
            userModel.setUserName("系统");
        }
        return userModel;
    }
}