package com.yaorange.tqt.utils;

import lombok.Data;

import java.util.List;

/**
 * @author:zjj
 * @date 2020/3/6 10:28
 * @description:
 */
@Data
public class PageResultNew<T> {
    private List<T> content;
    private Long totalElements;
    private Integer size;
    private Integer number;
}
