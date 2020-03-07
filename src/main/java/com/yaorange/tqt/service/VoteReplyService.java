package com.yaorange.tqt.service;

import com.yaorange.tqt.pojo.VoteReply;

import java.util.List;

/**
 * @author:zjj
 * @date 2020/3/7 13:59
 * @description:
 */
public interface VoteReplyService {

    void addVoteReplies(Long voteTopicId, List<VoteReply> voteReplies);
}
