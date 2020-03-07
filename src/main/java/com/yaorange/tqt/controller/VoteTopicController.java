package com.yaorange.tqt.controller;

import com.yaorange.tqt.pojo.Votetopic;
import com.yaorange.tqt.service.impl.VoteTopicServiceImpl;
import com.yaorange.tqt.utils.PageResultNew;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author:zjj
 * @date 2020/3/6 16:54
 * @description:
 */

@RestController
@RequestMapping("/api/voteTopic")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class VoteTopicController {

    @Autowired
    private VoteTopicServiceImpl voteTopicService;

    @GetMapping("/mine")
    public PageResultNew<Votetopic> queryAllVoteTopic(
            @RequestParam("pageNo") Integer pageNo,
            @RequestParam("pageSize") Integer pageSize,
            @RequestParam("keyWord") String keyWord
    ){
        return voteTopicService.findAllByPage(pageNo,pageSize);
    }
}
