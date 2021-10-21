package com.qk.blog.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qk.blog.common.BaseController;
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
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
        IPage<ArticlePageVo> page = articleService.getArticlePage(cmd);
        result.setData(page);
        return result;
    }

    @GetMapping("/edit")
    public String edit(HttpServletRequest request, Model model) {
//        request.setAttribute("path", "edit");
//        request.setAttribute("categories", categoryService.getAllCategorys());
        model.addAttribute("categories", categoryService.getAllCategorys());
        return "article/articleEdit";
    }

    @GetMapping("/edit/{blogId}")
    public String edit(Model model, @PathVariable("blogId") Long blogId) {
//        model.setAttribute("path", "edit");
        ArticleModel article = articleService.getById(blogId);
        if (article == null) {
            return "error/error_400";
        }
        model.addAttribute("blog", article);
        model.addAttribute("categories", categoryService.getAllCategorys());
        return "article/articleEdit";
    }

    @PostMapping("/save")
    @ResponseBody
    public Result save(Result result, @RequestBody ArticleVo vo) {
        try {
            result = articleService.saveArticle(result, vo);
        } catch (Exception e) {
            e.printStackTrace();
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
