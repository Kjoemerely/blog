package com.qk.blog.vo;

import com.qk.blog.common.PageQueryCmd;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author qk
 * @since 2021/10/18 11:23
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ArticleSearchCmd extends PageQueryCmd {

    private Long createUserId;

}
