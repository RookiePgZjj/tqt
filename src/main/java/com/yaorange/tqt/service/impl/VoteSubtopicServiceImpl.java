package com.yaorange.tqt.service.impl;

import com.yaorange.tqt.mapper.VoteSubtopicMapper;
import com.yaorange.tqt.pojo.Votesubtopic;
import com.yaorange.tqt.service.VoteSubtopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author:zjj
 * @date 2020/3/6 18:36
 * @description:
 */
@Service
@Transactional
public class VoteSubtopicServiceImpl implements VoteSubtopicService {

    @Autowired
    private VoteSubtopicMapper voteSubtopicMapper;

    @Override
    public List<Votesubtopic> findByParentId(Long parentId) {
        List<Votesubtopic> votesubtopics = voteSubtopicMapper.selectByParentId(parentId);
        return votesubtopics;
    }
}
