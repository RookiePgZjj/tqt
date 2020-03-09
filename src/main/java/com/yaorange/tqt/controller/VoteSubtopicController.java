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

    /**
     * 根据父id查询问卷
     * @param parentId
     * @return
     */
    @GetMapping("/all/{parentId}")
    public List<Votesubtopic> queryByParentId(@PathVariable("parentId")String parentId){
        return voteSubtopicService.findByParentId(parentId);
    }
}
