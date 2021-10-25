package com.qk.blog.controller;

import com.qk.blog.common.BaseController;
import com.qk.blog.service.ArticleService;
import com.qk.blog.service.CategoryService;
import com.qk.blog.service.CommentService;
import com.qk.blog.service.TagService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

/**
 * 默认启动页
 *
 * @author qk
 * @since 2021/10/22 15:42
 */
@Controller
public class IndexController extends BaseController {

    @Resource
    private ArticleService articleService;
    @Resource
    private CategoryService categoryService;
    @Resource
    private TagService tagService;
    @Resource
    private CommentService commentService;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.POST)
    public String index(Model model) {
        model.addAttribute("categoryCount", categoryService.getCategoryCount());
        model.addAttribute("blogCount", articleService.getArticleCount());
        model.addAttribute("tagCount", tagService.getTagCount());
        model.addAttribute("commentCount", commentService.getCommentCount());
        return "index";
    }

}
