package com.yaorange.tqt.service.impl;

import com.yaorange.tqt.mapper.VoteReplyMapper;
import com.yaorange.tqt.mapper.VoteTopicMapper;
import com.yaorange.tqt.pojo.VoteReply;
import com.yaorange.tqt.pojo.Votetopic;
import com.yaorange.tqt.service.VoteReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author:zjj
 * @date 2020/3/7 13:59
 * @description:
 */
@Service
@Transactional
public class VoteReplyServiceImpl implements VoteReplyService {

    @Autowired
    private VoteReplyMapper voteReplyMapper;

    @Autowired
    private VoteTopicMapper voteTopicMapper;

    @Override
    public void addVoteReplies(Long voteTopicId, List<VoteReply> voteReplies) {

        Votetopic votetopic = voteTopicMapper.selectByPrimaryKey(voteTopicId);
        voteReplies.forEach(voteReply -> {
            voteReply.setTeacherId(votetopic.getUserId());
            voteReplyMapper.insert(voteReply);
        });
    }
}
