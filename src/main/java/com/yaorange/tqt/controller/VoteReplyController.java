package com.yaorange.tqt.controller;

import com.yaorange.tqt.pojo.VoteReply;
import com.yaorange.tqt.service.impl.VoteReplyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author:zjj
 * @date 2020/3/7 13:58
 * @description:
 */
@RestController
@RequestMapping("/api/voteReply")
public class VoteReplyController {

    @Autowired
    private VoteReplyServiceImpl voteReplyService;

    /**
     * 保存问卷调查结果
     * @param voteTopicId
     * @param voteReplies
     * @return
     */
    @PostMapping
    public ResponseEntity<Void> addVoteReplies(@RequestParam("voteTopicId")Long voteTopicId,
                                             @RequestBody List<VoteReply> voteReplies){
        voteReplyService.addVoteReplies(voteTopicId,voteReplies);
        return ResponseEntity.ok().build();
    }

}
