package com.yaorange.tqt.service;

import com.yaorange.tqt.pojo.Votesubtopic;

import java.util.List;

/**
 * @author:zjj
 * @date 2020/3/6 18:36
 * @description:
 */
public interface VoteSubtopicService {
    List<Votesubtopic> findByParentId(Long parentId);
}
