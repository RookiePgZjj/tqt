package com.yaorange.tqt.service;

import com.yaorange.tqt.pojo.Votetopic;
import com.yaorange.tqt.utils.PageResultNew;

/**
 * @author:zjj
 * @date 2020/3/6 16:55
 * @description:
 */
public interface VoteTopicService {
    PageResultNew<Votetopic> findAllByPage(Integer pageNo, Integer pageSize);
}
