package com.yaorange.tqt.controller;
import com.yaorange.tqt.pojo.TeaFaceBack;
import com.yaorange.tqt.service.impl.FeedBackServiceImpl;
import com.yaorange.tqt.utils.PageResultNew;
import com.yaorange.tqt.vo.FeedBackVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author:zjj
 * @date 2020/3/6 14:35
 * @description:
 */
@RestController
@RequestMapping("/api/feedback")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FeedBackController {

    @Autowired
    private FeedBackServiceImpl feedBackService;

    /**
     * 分页查询
     * @param pageNo
     * @param pageSize
     * @param keyWord
     * @return
     */
    @GetMapping
    public PageResultNew<FeedBackVo> queryAllByPage(
            @RequestParam("pageNo") Integer pageNo,
            @RequestParam("pageSize") Integer pageSize,
            @RequestParam("keyWord") String keyWord
            ) {

       return feedBackService.findAllByPage(pageNo,pageSize,keyWord);
    }

    /**
     * 修改
     * @param teaFaceBack
     * @return
     */
    @PutMapping
    public ResponseEntity<Void> updateFeedBack(@RequestBody TeaFaceBack teaFaceBack){
        feedBackService.updateFeedBack(teaFaceBack);
        return ResponseEntity.ok().build();
    }


    /**
     * 新增
     * @param teaFaceBack
     * @return
     */
    @PostMapping
    public ResponseEntity<Void> addFeedBack(@RequestBody TeaFaceBack teaFaceBack){
        feedBackService.addFeedBack(teaFaceBack);
        return ResponseEntity.ok().build();
    }


    /**
     * 删除
     */
    @DeleteMapping
    public ResponseEntity<Void> deleteFeedBack(@RequestBody List<Long> ids){
        feedBackService.deleteByIds(ids);
        return ResponseEntity.ok().build();
    }
}
