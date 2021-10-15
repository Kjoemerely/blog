package com.qk.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.qk.blog.vo.LoginUserVo;
import com.qk.blog.common.Result;
import com.qk.blog.enums.ErrorResultEnum;
import com.qk.blog.enums.StatusEnum;
import com.qk.blog.exception.ResultException;
import com.qk.blog.model.UserModel;
import com.qk.blog.service.TokenService;
import com.qk.blog.utils.Md5Util;
import com.qk.blog.utils.RedisUtil;
import com.qk.blog.utils.TokenUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qk.blog.dao.UserMapper;
import com.qk.blog.service.UserService;

import javax.annotation.Resource;

/**
 * @author qk
 * @since 2021/10/14 14:41
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserModel> implements UserService {

    @Resource
    private TokenService tokenService;
    @Resource
    private UserMapper userMapper;
    @Resource
    private RedisUtil redisUtil;

    @Override
    public int updateBatch(List<UserModel> list) {
        return baseMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<UserModel> list) {
        return baseMapper.batchInsert(list);
    }

    /**
     * 获取登录用户信息
     *
     * @return 登录用户信息
     */
    @Override
    public LoginUserVo getLoginUser() throws ResultException {
        //通过token获取用户信息
        String token = TokenUtil.getToken();
        LoginUserVo userInfo = tokenService.getLoginInfo(token);

        //判断用户是否失效
        if(userInfo == null){
            throw new ResultException(ErrorResultEnum.USER_LOGIN_TIME_EXPIRED);
        }
        String redisToken = (String)redisUtil.get("userId:" + userInfo.getId());
        if(StringUtils.isEmpty(redisToken)){
            throw new ResultException(ErrorResultEnum.USER_LOGIN_TIME_EXPIRED);
        }else if(!token.equals(redisToken)){
            redisUtil.del("token:" + token);
            throw new ResultException(ErrorResultEnum.USER_LOGIN_REMOTE_ERROR);
        }
        return userInfo;
    }

    /**
     * 用户登录
     *
     * @param result   通用返回结果
     * @param username 用户名
     * @param password 密码
     * @return 通用返回结果
     * @throws Exception 异常信息
     */
    @Override
    public Result login(Result result, String username, String password) throws Exception {
        LambdaQueryWrapper<UserModel> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(username), UserModel::getUserName, username);
        wrapper.eq(StringUtils.isNotBlank(password), UserModel::getPassword, Md5Util.md5Encode(password));
        wrapper.eq(UserModel::getStatus, StatusEnum.NORMAL.getCode());
        UserModel userModel = userMapper.selectOne(wrapper);
        if (userModel == null) {
            result.setCode(Result.RESULT_ERROR);
            result.setMessage("登录失败！");
        }
        result.setData(userModel);
        return result;
    }

    /**
     * 用户信息修改
     *
     * @param result 通用返回结果
     * @param userVo 用户信息
     * @return 通用返回结果
     * @throws Exception 异常信息
     */
    @Override
    public Result edit(Result result, LoginUserVo userVo) throws Exception {
        userMapper.updateById(userVo);
        return result;
    }
}