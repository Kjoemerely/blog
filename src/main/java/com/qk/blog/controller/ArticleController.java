package com.qk.blog.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qk.blog.annotation.IgnoreSecurity;
import com.qk.blog.common.PageQueryCmd;
import com.qk.blog.enums.StatusEnum;
import com.qk.blog.service.ArticleService;
import com.qk.blog.utils.EnumUtil;
import com.qk.blog.vo.ArticlePageVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @author qk
 * @since 2021/10/15 16:10
 */
@Controller
@RequestMapping("article")
public class ArticleController {

    @Resource
    private ArticleService articleService;

    @IgnoreSecurity
    @GetMapping("getArticlePage")
    public String getArticlePage(Model model, @ModelAttribute(value = "cmd") PageQueryCmd cmd) {
        IPage<ArticlePageVo> page = articleService.getArticlePage(cmd);
        model.addAttribute("page", page);
        model.addAttribute("cmd", cmd);
        model.addAttribute("statusList", EnumUtil.enumToMap(StatusEnum.class));
        return "article";
    }
}
