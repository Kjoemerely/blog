package com.qk.blog.controller;

import com.qk.blog.annotation.IgnoreSecurity;
import com.qk.blog.common.BaseController;
import com.qk.blog.common.Result;
import com.qk.blog.service.*;
import com.qk.blog.utils.TokenUtil;
import com.qk.blog.vo.LoginUserVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 用户控制器
 *
 * @author qk
 * @since 2021/10/14 15:33
 */
@Controller
@RequestMapping(value = "/user")
public class UserController extends BaseController {

    @Resource
    private UserService userService;
    @Resource
    private ArticleService articleService;
    @Resource
    private CategoryService categoryService;
    @Resource
    private TagService tagService;
    @Resource
    private CommentService commentService;
    @Resource
    private TokenService tokenService;

    @IgnoreSecurity
    @RequestMapping(value = "toLogin")
    public String toLogin() {
        return "user/login";
    }

    @IgnoreSecurity
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(Model model, HttpServletRequest request,
                        @RequestParam("username") String username, @RequestParam("password") String password) {
        Result result = getResult();
        try {
            result = userService.login(result, username, password);
        } catch (Exception e) {
            error(result, e);
        }
        if (Result.RESULT_SUCCESS.equals(result.getCode())) {
            model.addAttribute("categoryCount", categoryService.getCategoryCount());
            model.addAttribute("blogCount", articleService.getArticleCount());
            model.addAttribute("tagCount", tagService.getTagCount());
            model.addAttribute("commentCount", commentService.getCommentCount());
            return "index";
        } else {
            request.getSession().setAttribute("errorMsg", "用户名或密码错误，请重试");
            return "user/login";
        }
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {
        Object token = TokenUtil.getToken();
        Object errorMsg = request.getSession().getAttribute("errorMsg");
        if (null != token) {
            // 删除session中的token
            request.getSession().removeAttribute("token");
            // 删除redis的token
            tokenService.deleteToken(token.toString());
        }
        if (null != errorMsg) {
            request.getSession().setAttribute("errorMsg", "安全退出成功");
        }
        return "user/login";
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    @ResponseBody
    public Result edit(LoginUserVo userVo) {
        Result result = getResult();
        try {
            result = userService.edit(result, userVo);
        } catch (Exception e) {
            error(result, e);
        }
        return result;
    }

}
