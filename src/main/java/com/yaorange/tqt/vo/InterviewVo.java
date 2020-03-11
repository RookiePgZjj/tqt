package com.yaorange.tqt.vo;

import lombok.Data;

import java.util.List;
@Data
public class InterviewVo {
    private List<InterviewQuestionVo> interviewQuestionList;
    private String company;
}
