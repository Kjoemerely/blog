package com.qk.blog.controller;

import com.qk.blog.common.BaseController;
import com.qk.blog.common.Result;
import com.qk.blog.enums.StatusEnum;
import com.qk.blog.service.ArticleService;
import com.qk.blog.service.CategoryService;
import com.qk.blog.utils.EnumUtil;
import com.qk.blog.vo.ArticleSearchCmd;
import com.qk.blog.vo.ArticleVo;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.LinkedHashMap;

/**
 * @author qk
 * @since 2021/10/15 16:10
 */
@Controller
@RequestMapping("/article")
public class ArticleController extends BaseController {

    @Resource
    private ArticleService articleService;
    @Resource
    private CategoryService categoryService;

    private final LinkedHashMap<String, String> statusEnumMap = EnumUtil.enumToMap(StatusEnum.class);

    @RequestMapping("/toArticleList")
    public String toArticleList() {
        return "article/articleList";
    }

    @RequestMapping("/articleList")
    @ResponseBody
    public Result getArticleList(@RequestBody ArticleSearchCmd cmd) {
        Result result = getResult();
        try {
            result = articleService.getArticleList(result, cmd);
        } catch (Exception e) {
            error(result, e);
        }
        return result;
    }

    @GetMapping("/edit")
    public String edit(Model model) {
        model.addAttribute("categories", categoryService.getAllCategorys());
        return "article/articleEdit";
    }

    @GetMapping("/edit/{blogId}")
    public String edit(Model model, @PathVariable("blogId") String blogId) {
        ArticleVo articleVo = new ArticleVo();
        try {
            articleVo = articleService.getById(Long.valueOf(blogId));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (articleVo == null) {
            return "error/error_400";
        }
        model.addAttribute("blog", articleVo);
        model.addAttribute("categories", categoryService.getAllCategorys());
        return "article/articleEdit";
    }

    @PostMapping("/save")
    @ResponseBody
    public Result save(Result result, @RequestBody ArticleVo vo) {
        try {
            result = articleService.saveArticle(result, vo);
        } catch (Exception e) {
            error(result, e, "保存文章失败！");
        }
        return result;
    }

    @RequestMapping("/update")
    @ResponseBody
    public Result update(Result result, @RequestBody ArticleVo vo) {
        try {
            result = articleService.updateArticle(result, vo);
        } catch (Exception e) {
            error(result, e, "修改文章失败！");
        }
        return result;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Result delete(Result result, @RequestParam Long id) {
        try {
            result = articleService.deleteArticle(result, id);
        } catch (Exception e) {
            error(result, e, "删除文章失败！");
        }
        return result;
    }

}