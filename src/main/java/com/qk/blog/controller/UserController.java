package com.qk.blog.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qk.blog.annotation.IgnoreSecurity;
import com.qk.blog.common.BaseController;
import com.qk.blog.common.PageQueryCmd;
import com.qk.blog.common.Result;
import com.qk.blog.model.UserModel;
import com.qk.blog.service.ArticleService;
import com.qk.blog.service.UserService;
import com.qk.blog.vo.ArticlePageVo;
import com.qk.blog.vo.LoginUserVo;
import com.sun.deploy.ui.AppInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author qk
 * @since 2021/10/14 15:33
 */
@Controller
@RequestMapping("user")
public class UserController extends BaseController {

    @Resource
    private UserService userService;
    @Resource
    private ArticleService articleService;

    @IgnoreSecurity
    @GetMapping(value = "/toLogin")
    public String toLogin() {
        return "login";
    }

    @IgnoreSecurity
    @GetMapping(value = "/login")
    public String login(Model model, @RequestParam("username") String username, @RequestParam("password")String password) {
        Result result = getResult();
        try {
            result = userService.login(result, username, password);
            if (Result.RESULT_SUCCESS.equals(result.getCode())) {
                UserModel userVo = (UserModel)result.getData();
                IPage<ArticlePageVo> page = articleService.getArticlePage(new PageQueryCmd());
                model.addAttribute("page", page);
                model.addAttribute("cmd", "");
                return "index";
            }
        } catch (Exception e) {
            error(result, e);
        }
        return "login";
    }

    @RequestMapping("/edit")
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
