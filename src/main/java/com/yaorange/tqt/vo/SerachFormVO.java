package com.yaorange.tqt.vo;

import lombok.Data;

/**
 * @author:zjj
 * @date 2020/3/7 14:37
 * @description: 用于面试查询的查询对象
 */

@Data
public class SerachFormVO {

    private Long classId;
    private String stuName;
    private String companyName;
}
