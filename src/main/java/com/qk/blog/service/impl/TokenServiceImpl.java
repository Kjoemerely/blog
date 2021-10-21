package com.qk.blog.service.impl;

import com.qk.blog.common.Result;
import com.qk.blog.exception.ResultException;
import com.qk.blog.service.TokenService;
import com.qk.blog.service.UserService;
import com.qk.blog.utils.RedisUtil;
import com.qk.blog.utils.UuidUtil;
import com.qk.blog.vo.LoginUserVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author qk
 * @since 2021/10/14 15:12
 */
@Service
public class TokenServiceImpl implements TokenService {

    @Resource
    private RedisUtil redisUtil;
    @Resource
    private UserService userService;

    /**
     * 时效时间
     */
    private final int EXPIRES_TIME = 15 * 60;

    /**
     * 利用UUID创建Token(用户登录时，创建Token)
     *
     * @param loginUserVo 用户信息
     * @return token
     */
    @Override
    public String createToken(LoginUserVo loginUserVo) {
        String token = UuidUtil.getUuid();
        redisUtil.set("token:" + token, loginUserVo);
        redisUtil.set("userId:" + loginUserVo.getId(), token, EXPIRES_TIME);
        return token;
    }

    /**
     * 重置用户信息
     *
     * @param loginUserVo 用户信息
     */
    @Override
    public void resetToken(String token, LoginUserVo loginUserVo) {
        redisUtil.set("token:" + token, loginUserVo);
    }

    /**
     * 刷新token时间
     *
     * @param token token
     */
    @Override
    public void refreshTokenTime(String token) {
        LoginUserVo loginUserVo = (LoginUserVo) redisUtil.get("token:" + token);
        if (loginUserVo != null) {
            redisUtil.expire("userId:" + loginUserVo.getId(), EXPIRES_TIME);
        }
    }

    /**
     * token获取id值
     *
     * @param token token
     * @return
     */
    @Override
    public LoginUserVo getLoginInfo(String token) {
        return (LoginUserVo) redisUtil.get("token:" + token);
    }

    @Override
    public void deleteToken(String token) {
        redisUtil.del("token:" + token);
    }


    /**
     * 验证登录用户信息
     *
     * @param token 令牌
     * @return 通用返回信息
     */
    @Override
    public Result checkLoginUser(String token) {
        Result result = new Result();
        LoginUserVo loginUserVo;
        try {
            loginUserVo = userService.getLoginUser();
            // 检查 token 有效性
            if (loginUserVo != null) {
                // 重置redis登陆时间
                this.refreshTokenTime(token);
                result.setData(loginUserVo);
            }
        } catch (Exception e) {
            ResultException exception = (ResultException) e;
            result.setCode(exception.getCode());
            result.setMessage(exception.getMessage());
        }
        return result;
    }

}
