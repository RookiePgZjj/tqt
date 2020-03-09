package com.yaorange.tqt.service.impl;

import com.yaorange.tqt.mapper.VoteReplyMapper;
import com.yaorange.tqt.mapper.VoteSubtopicMapper;
import com.yaorange.tqt.pojo.VoteReply;
import com.yaorange.tqt.pojo.Votesubtopic;
import com.yaorange.tqt.service.VoteSubtopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

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

    @Autowired
    private VoteReplyMapper voteReplyMapper;

    @Override
    public List<Votesubtopic> findByParentId(String parentId) {
        Example example = new Example(Votesubtopic.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("parentId",parentId);
        example.orderBy("priority").asc();
        List<Votesubtopic> votesubtopics = voteSubtopicMapper.selectByExample(example);
        for (Votesubtopic vs:votesubtopics
             ) {
            Example replyExample = new Example(VoteReply.class);
            Example.Criteria criteria1 = replyExample.createCriteria();
            criteria1.andEqualTo("subtopicId",vs.getId());
            List<VoteReply> voteReplies = voteReplyMapper.selectByExample(replyExample);
            vs.setVoteReplyList(voteReplies);
        }
        return votesubtopics;
    }
}
