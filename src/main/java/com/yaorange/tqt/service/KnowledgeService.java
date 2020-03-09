package com.yaorange.tqt.service;

import com.yaorange.tqt.pojo.TeaKnowledge;
import com.yaorange.tqt.utils.PageResult;
import com.yaorange.tqt.vo.KnowledgeVo;

import java.util.List;

public interface KnowledgeService {
    PageResult<KnowledgeVo> getPage(Integer pageNo, Integer pageSize, String keyWord);

    int addCourse(TeaKnowledge teaKnowledge);

    int update(TeaKnowledge teaKnowledge);

    int delete(List<Long> ids);

    List<TeaKnowledge> findAllCourseId(Long courseId);
}
