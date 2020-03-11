package com.yaorange.tqt.controller;

import com.yaorange.tqt.pojo.Votetopic;
import com.yaorange.tqt.service.impl.VoteTopicServiceImpl;
import com.yaorange.tqt.utils.PageResultNew;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    /**
     * 查询当前学生的问卷
     * @param pageNo
     * @param pageSize
     * @param keyWord
     * @return
     */
    @GetMapping("/mine")
    public PageResultNew<Votetopic> queryAllVoteTopic(
            @RequestParam("pageNo") Integer pageNo,
            @RequestParam("pageSize") Integer pageSize,
            @RequestParam("keyWord") String keyWord
    ){
        return voteTopicService.findCurrentVoteTopic(pageNo,pageSize);
    }

    /**
     * 查询所有问卷
     * @param pageNo
     * @param pageSize
     * @param keyWord
     * @return
     */
    @GetMapping
    public PageResultNew<Votetopic> queryVoteTopic(
            @RequestParam("pageNo") Integer pageNo,
            @RequestParam("pageSize") Integer pageSize,
            @RequestParam("keyWord") String keyWord
    ){
        return voteTopicService.findAllByPage(pageNo,pageSize,keyWord);
    }

    /**
     * 新增调查问卷
     * @param votetopic
     * @return
     */
    @PostMapping
    public ResponseEntity<Void> addVoteTopic(@RequestBody Votetopic votetopic){
        voteTopicService.addVoteTopic(votetopic);
        return ResponseEntity.ok().build();
    }

    /**
     * 删除
     * @param ids
     * @return
     */
    @DeleteMapping ResponseEntity<Void> deleteVoteTopic(@RequestBody List<String> ids){
        voteTopicService.deleteVoteTopic(ids);
        return ResponseEntity.ok().build();
    }
}
