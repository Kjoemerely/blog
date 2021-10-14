package com.qk.blog.controller;

import com.qk.blog.common.BaseController;
import com.qk.blog.common.Result;
import com.qk.blog.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @author qk
 * @since 2021/10/14 15:33
 */
@Controller
@RequestMapping(("user"))
public class UserController extends BaseController {

    @Resource
    private UserService userService;

    @RequestMapping("login")
    public Result login(String username, String password) {
        Result result = getResult();
        try {
            result = userService.login(getResult(), username, password);
        } catch (Exception e) {
            error(result, e);
        }
        return result;
    }

}
