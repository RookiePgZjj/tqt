package com.yaorange.tqt.service;

import com.yaorange.tqt.pojo.TeaInterview;
import com.yaorange.tqt.utils.PageResultNew;
import com.yaorange.tqt.vo.InterviewQuestionVo;
import com.yaorange.tqt.vo.TextVo;

import java.util.List;
import java.util.Map;

public interface InterviewQuestionService {
    PageResultNew<TeaInterview> page(Integer pageNo, Integer pageSize, String keyWord, Map<String, Object> map);

    void add(InterviewQuestionVo interviewQuestionVo);

    void update(InterviewQuestionVo interviewQuestionVo);

    int delete(List<Long> ids);

    List<InterviewQuestionVo> changeText(TextVo text);

    void addMore(List<InterviewQuestionVo> list);
}
