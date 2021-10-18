package com.qk.blog.vo;

import com.qk.blog.model.UserModel;
import lombok.Data;

/**
 * @author qk
 * @since 2021/10/14 15:20
 */
@Data
public class LoginUserVo extends UserModel {

    private String token;

}
