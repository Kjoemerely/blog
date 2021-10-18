package com.qk.blog.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qk.blog.enums.StatusEnum;
import com.qk.blog.service.ArticleService;
import com.qk.blog.utils.EnumUtil;
import com.qk.blog.vo.ArticlePageVo;
import com.qk.blog.vo.ArticleSearchCmd;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
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

    private final LinkedHashMap<String, String> statusEnumMap = EnumUtil.enumToMap(StatusEnum.class);

    @RequestMapping("/getArticlePage")
    public String getArticlePage(Model model, @RequestBody ArticleSearchCmd cmd) {
        IPage<ArticlePageVo> page = articleService.getArticlePage(cmd);
        model.addAttribute("page", page);
        model.addAttribute("cmd", cmd);
        model.addAttribute("statusList", statusEnumMap);
        return "article/articleList";
    }

    @GetMapping("getById")
    public String get(Model model, Long id) {
        ArticlePageVo vo = articleService.getById(id);
        model.addAttribute("vo", vo);
        model.addAttribute("statusList", statusEnumMap);
        return "article/articleDetail";
    }

}
