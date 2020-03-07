package com.yaorange.tqt.controller;

import com.yaorange.tqt.pojo.Votesubtopic;
import com.yaorange.tqt.service.impl.VoteSubtopicServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author:zjj
 * @date 2020/3/6 18:33
 * @description:
 */

@RestController
@RequestMapping("/api/voteSubtopic")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class VoteSubtopicController {

    @Autowired
    private VoteSubtopicServiceImpl voteSubtopicService;

    @GetMapping("/{parentId}")
    public List<Votesubtopic> queryByParentId(@PathVariable("parentId")Long parentId){
        return voteSubtopicService.findByParentId(parentId);
    }
}
