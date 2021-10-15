package com.qk.blog.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qk.blog.vo.LoginUserVo;
import com.qk.blog.common.Result;
import com.qk.blog.exception.ResultException;
import com.qk.blog.model.UserModel;

/**
 * @author qk
 * @since 2021/10/14 14:41
 */
public interface UserService extends IService<UserModel> {


    int updateBatch(List<UserModel> list);

    int batchInsert(List<UserModel> list);

    /**
     * 获取登录用户信息
     *
     * @return 登录用户信息
     */
    LoginUserVo getLoginUser() throws ResultException;

    /**
     * 用户登录
     *
     * @param result   通用返回结果
     * @param username 用户名
     * @param password 密码
     * @return 通用返回结果
     * @throws Exception 异常信息
     */
    Result login(Result result, String username, String password) throws Exception;

    /**
     * 用户信息修改
     *
     * @param userVo 用户信息
     * @return 通用返回结果
     * @throws Exception 异常信息
     */
    Result edit(Result result, LoginUserVo userVo) throws Exception;
}