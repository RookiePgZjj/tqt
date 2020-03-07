package com.yaorange.tqt.service;

import com.yaorange.tqt.pojo.Interview;
import com.yaorange.tqt.utils.PageResultNew;
import com.yaorange.tqt.vo.SerachFormVO;

import java.util.List;

/**
 * @author:zjj
 * @date 2020/3/7 14:35
 * @description:
 */
public interface InterviewService {
    PageResultNew<Interview> findByPage(Integer pageNo, Integer pageSize);

    PageResultNew<Interview> findByVO(Integer pageNo,Integer pageSize, SerachFormVO serachFormVO);

    void addInterview(Interview interview);

    void deleteByIds(List<Long> ids);

    Boolean updateInterview(Interview interview);

    PageResultNew<Interview> findCurrentByPage(Integer pageNo, Integer pageSize,SerachFormVO serachFormVO);
}
