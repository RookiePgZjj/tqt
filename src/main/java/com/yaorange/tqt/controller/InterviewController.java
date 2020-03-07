package com.yaorange.tqt.controller;

import com.yaorange.tqt.pojo.Interview;
import com.yaorange.tqt.service.impl.InterviewServiceImpl;
import com.yaorange.tqt.utils.PageResultNew;
import com.yaorange.tqt.vo.SerachFormVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author:zjj
 * @date 2020/3/7 14:34
 * @description:
 */

@RestController
@RequestMapping("/api/interview")
public class InterviewController {

    @Autowired
    private InterviewServiceImpl interviewService;

    /**
     * 查询面试情况
     * @param status
     * @param pageNo
     * @param pageSize
     * @param keyword
     * @param serachFormVO
     * @return
     */
    @PostMapping("/search/{status}")
    public PageResultNew<Interview> findByPage(@PathVariable("status")Boolean status,
                                               @RequestParam("pageNo")Integer pageNo,
                                               @RequestParam("pageSize")Integer pageSize,
                                               @RequestParam(value = "keyword",required = false)String keyword,
                                               @RequestBody SerachFormVO serachFormVO)
    {
        if (status){
            if (serachFormVO == null){
               return interviewService.findByPage(pageNo,pageSize);
            }else {
                return interviewService.findByVO(pageNo,pageSize,serachFormVO);
            }
        }else {
                return interviewService.findCurrentByPage(pageNo,pageSize,serachFormVO);
        }
    }


    /**
     * 添加面试
     * @param interview
     * @return
     */
    @PostMapping
    public ResponseEntity<Void> addInterView(@RequestBody Interview interview){
        interviewService.addInterview(interview);
        return ResponseEntity.ok().build();
    }

    /**
     * 删除面试
     * @param ids
     * @return
     */
    @DeleteMapping
    public ResponseEntity<Void> deleteInterView(@RequestBody List<Long> ids){
        interviewService.deleteByIds(ids);
        return ResponseEntity.ok().build();
    }

    /**
     * 修改面试
     * @param interview
     * @return
     */
    @PutMapping
    public ResponseEntity<Void> updateInterview(@RequestBody Interview interview){
        Boolean status = interviewService.updateInterview(interview);
        if (status){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }

}
