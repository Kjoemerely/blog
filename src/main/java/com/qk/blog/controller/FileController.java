package com.qk.blog.controller;

import com.qk.blog.common.Result;
import com.qk.blog.enums.CommonConstant;
import com.qk.blog.utils.NetworkUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 文件上传控制器
 *
 * @author qk
 * @since 2021/10/20 14:28
 */
@Controller
public class FileController {

    @PostMapping({"/upload/file"})
    @ResponseBody
    public Result upload(HttpServletRequest httpServletRequest, @RequestParam("file") MultipartFile file) throws URISyntaxException {
        Result result = new Result();
        // 获取文件原名
        String fileName = file.getOriginalFilename();
        // 生成新的文件名
        String newFileName = createNewFileName(fileName);
        // 上传文件的新文件夹
        File fileDirectory = new File(CommonConstant.FILE_UPLOAD_DIC);
        File destFile = new File(CommonConstant.FILE_UPLOAD_DIC + newFileName);
        try {
            if (!fileDirectory.exists()) {
                if (!fileDirectory.mkdir()) {
                    throw new IOException("文件夹创建失败,路径为：" + fileDirectory);
                }
            }
            file.transferTo(destFile);
            result.setData(NetworkUtil.getHost(new URI(httpServletRequest.getRequestURL() + "")) + "/upload/" + newFileName);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            result.setCode(Result.RESULT_ERROR);
            result.setMessage("文件上传失败");
            return result;
        }
    }

    /**
     * 按照当前日期生成新文件名
     *
     * @param oldFileName 原文件名
     * @return 新文件名
     */
    String createNewFileName(String oldFileName) {
        // 取出文件后缀
        String suffixName = "";
        if (null != oldFileName) {
            suffixName = oldFileName.substring(oldFileName.lastIndexOf("."));
        }
        // 按照当前日期生成新文件名
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        Random r = new Random();
        return sdf.format(new Date()) + r.nextInt(100) + suffixName;
    }

}
