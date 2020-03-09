package com.yaorange.tqt.service;

import com.yaorange.tqt.pojo.VoteReply;
import com.yaorange.tqt.vo.VoteRecordVO;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * @author:zjj
 * @date 2020/3/7 13:59
 * @description:
 */
public interface VoteReplyService {

    void addVoteReplies(String voteTopicId, List<VoteReply> voteReplies);

    List<VoteRecordVO> selectVoteRecord(String voteTopicId);
}
