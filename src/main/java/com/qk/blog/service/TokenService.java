package com.qk.blog.service;

import com.qk.blog.vo.LoginUserVo;
import com.qk.blog.common.Result;

/**
 * @author qk
 * @since 2021/10/14 15:12
 */
public interface TokenService {

    String createToken(LoginUserVo userInfo);

    void resetToken(String token,LoginUserVo userVo);

    void refreshTokenTime(String token);

    LoginUserVo getLoginInfo(String token);

    void deleteToken(String token);

    /**
     * 验证登录用户信息
     * @return
     */
    Result checkLoginUser(String token);

}
