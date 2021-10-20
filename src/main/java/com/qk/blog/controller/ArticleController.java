package com.qk.blog.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qk.blog.common.Result;
import com.qk.blog.enums.StatusEnum;
import com.qk.blog.model.ArticleModel;
import com.qk.blog.service.ArticleService;
import com.qk.blog.service.CategoryService;
import com.qk.blog.utils.EnumUtil;
import com.qk.blog.vo.ArticlePageVo;
import com.qk.blog.vo.ArticleSearchCmd;
import com.qk.blog.vo.ArticleVo;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;

/**
 * @author qk
 * @since 2021/10/15 16:10
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

    @Resource
    private ArticleService articleService;
    @Resource
    private CategoryService categoryService;

    private final LinkedHashMap<String, String> statusEnumMap = EnumUtil.enumToMap(StatusEnum.class);

    @RequestMapping("getArticlePage")
    public String getArticlePage(Model model, @RequestBody ArticleSearchCmd cmd) {
        IPage<ArticlePageVo> page = articleService.getArticlePage(cmd);
        model.addAttribute("page", page);
        model.addAttribute("cmd", cmd);
        model.addAttribute("statusList", statusEnumMap);
        return "article/articleList";
    }

    @GetMapping("/edit")
    public String edit(HttpServletRequest request) {
        request.setAttribute("path", "edit");
        request.setAttribute("categories", categoryService.getAllCategorys());
        return "article/articleEdit";
    }

    @GetMapping("/blogs/edit/{blogId}")
    public String edit(HttpServletRequest request, @PathVariable("blogId") Long blogId) {
        request.setAttribute("path", "edit");
        ArticleModel article = articleService.getById(blogId);
        if (article == null) {
            return "error/error_400";
        }
        request.setAttribute("blog", article);
        request.setAttribute("categories", categoryService.getCategoryCount());
        return "article/articleEdit";
    }

    @GetMapping("/save")
    @ResponseBody
    public Result save(Result result, @RequestBody ArticleVo vo) {
        try {
            result = articleService.saveArticle(result, vo);
        } catch (Exception e) {
            result.setCode(Result.RESULT_ERROR);
            result.setMessage("保存文章失败！");
        }
        return result;
    }

    @GetMapping("getById")
    public String get(Model model, Long id) {
        ArticlePageVo vo = articleService.getById(id);
        model.addAttribute("vo", vo);
        model.addAttribute("statusList", statusEnumMap);
        return "article/articleDetail";
    }

}
