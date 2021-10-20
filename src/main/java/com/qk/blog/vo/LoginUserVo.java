package com.qk.blog.vo;

import com.qk.blog.model.UserModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author qk
 * @since 2021/10/14 15:20
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class LoginUserVo extends UserModel {

    private String token;

}
