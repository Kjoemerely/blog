package com.qk.blog.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qk.blog.annotation.IgnoreSecurity;
import com.qk.blog.common.BaseController;
import com.qk.blog.common.Result;
import com.qk.blog.service.ArticleService;
import com.qk.blog.service.TokenService;
import com.qk.blog.service.UserService;
import com.qk.blog.vo.ArticlePageVo;
import com.qk.blog.vo.ArticleSearchCmd;
import com.qk.blog.vo.LoginUserVo;
import com.qk.blog.vo.UserVo;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author qk
 * @since 2021/10/14 15:33
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @Resource
    private UserService userService;
    @Resource
    private ArticleService articleService;
    @Resource
    private TokenService tokenService;

    @IgnoreSecurity
    @GetMapping(value = "/toLogin")
    public String toLogin() {
        return "user/login";
    }

    @IgnoreSecurity
    @GetMapping(value = "/login")
    public String login(Model model, HttpSession session, @RequestParam("username") String username, @RequestParam("password") String password) {
        Result result = getResult();
        try {
            result = userService.login(result, username, password);
            if (Result.RESULT_SUCCESS.equals(result.getCode())) {
                LoginUserVo loginUserVo = (LoginUserVo) result.getData();
                // 放到redis上
                tokenService.createToken(loginUserVo);
                // 把token放到header
                session.setAttribute("header", loginUserVo.getToken());
                ArticleSearchCmd cmd = new ArticleSearchCmd();
                cmd.setCreateUserId(loginUserVo.getId());
                IPage<ArticlePageVo> page = articleService.getArticlePage(cmd);
                model.addAttribute("page", page);
                model.addAttribute("cmd", cmd);
                return "index";
            }
        } catch (Exception e) {
            error(result, e);
        }
        return "user/login";
    }

    @IgnoreSecurity
    @GetMapping(value = "/register")
    public String toRegister() {
        return "user/register";
    }


    @RequestMapping("/register")
    @RequestBody
    public Result register(@RequestBody UserVo userVo) {
        Result result = getResult();
        try {
            result = userService.register(result, userVo);
        } catch (Exception e) {
            error(result, e);
        }
        return result;
    }

    @RequestMapping("/edit")
    @RequestBody
    public Result edit(@RequestBody LoginUserVo userVo) {
        Result result = getResult();
        try {
            result = userService.edit(result, userVo);
        } catch (Exception e) {
            error(result, e);
        }
        return result;
    }

}
