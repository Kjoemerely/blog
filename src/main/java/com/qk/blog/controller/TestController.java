package com.qk.blog.controller;

import com.qk.blog.utils.RedisUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author qk
 * @since 2021/10/14 11:38
 */
@RestController
@RequestMapping("/redis")
public class TestController {

    @Resource
    private RedisUtil redisUtil;

    @GetMapping("/set")
    public void test() {
        redisUtil.set("aa", "AA");
        redisUtil.set("bb", "BB");
        redisUtil.set("cc", "CC");
    }

    @GetMapping("/get")
    public String get() {
        return redisUtil.get("bb").toString();
    }

}