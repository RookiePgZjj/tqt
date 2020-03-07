package com.yaorange.tqt.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yaorange.tqt.mapper.VoteTopicMapper;
import com.yaorange.tqt.pojo.Votetopic;
import com.yaorange.tqt.service.VoteTopicService;
import com.yaorange.tqt.utils.PageResultNew;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author:zjj
 * @date 2020/3/6 16:55
 * @description:
 */
@Service
@Transactional
public class VoteTopicServiceImpl implements VoteTopicService {

    @Autowired
    private VoteTopicMapper voteTopicMapper;

    @Override
    public PageResultNew<Votetopic> findAllByPage(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        Page<Votetopic> votetopics = (Page<Votetopic>) voteTopicMapper.selectAll();
        PageResultNew<Votetopic> pageResult = new PageResultNew<>();
        pageResult.setContent(votetopics);
        pageResult.setSize(votetopics.getPageSize());
        pageResult.setTotalElements(votetopics.getTotal());
        pageResult.setNumber(votetopics.getPageNum());
        return pageResult;
    }
}
