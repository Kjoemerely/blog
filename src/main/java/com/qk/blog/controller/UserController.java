package com.qk.blog.controller;

import com.qk.blog.annotation.IgnoreSecurity;
import com.qk.blog.common.BaseController;
import com.qk.blog.common.Result;
import com.qk.blog.service.*;
import com.qk.blog.vo.LoginUserVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author qk
 * @since 2021/10/14 15:33
 */
@Controller
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

    @GetMapping({"/", "/index"})
    public String index(HttpServletRequest request) {
        request.setAttribute("path", "index");
        request.setAttribute("categoryCount", categoryService.getCategoryCount());
        request.setAttribute("blogCount", articleService.getArticleCount());
        request.setAttribute("tagCount", tagService.getTagCount());
        request.setAttribute("commentCount", commentService.getCommentCount());
        return "index";
    }

    @IgnoreSecurity
    @PostMapping(value = "/login")
    public String login(HttpSession session, @RequestParam("username") String username, @RequestParam("password") String password) {
        Result result = getResult();
        try {
            result = userService.login(result, username, password);
        } catch (Exception e) {
            error(result, e);
        }
        return Result.RESULT_SUCCESS.equals(result.getCode()) ? "index" : "user/login";
    }

    @RequestMapping("/user/edit")
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
