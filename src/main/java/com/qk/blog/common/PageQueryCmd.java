package com.qk.blog.common;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author qk
 * @since 2021/10/15 13:34
 */
@Getter
@Setter
public class PageQueryCmd {

    private Integer page = 1;

    private Integer rows = 10;

    private String searchValue;

    private String status;

    private LocalDate startDate;

    private LocalDate endDate;
}
