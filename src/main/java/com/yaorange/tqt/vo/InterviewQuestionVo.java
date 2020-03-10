package com.yaorange.tqt.vo;

import com.yaorange.tqt.pojo.TeaCourse;
import com.yaorange.tqt.pojo.TeaKnowledge;
import lombok.Data;

@Data
public class InterviewQuestionVo {
    private Long id;
    private String title;
    private TeaCourse course;
    private String answer;
    private TeaKnowledge knowledgePoint;
}
