package com.yaorange.tqt.controller;

import com.yaorange.tqt.pojo.TeaKnowledge;
import com.yaorange.tqt.service.KnowledgeService;
import com.yaorange.tqt.service.impl.KnowledgeServiceImpl;
import com.yaorange.tqt.utils.PageResult;
import com.yaorange.tqt.vo.KnowledgeVo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/api/knowledgePoint")
public class KnowledgeController {
    @Resource
    private KnowledgeServiceImpl knowledgeService;

    @GetMapping
    public ResponseEntity<PageResult<KnowledgeVo>> getPage(
            @RequestParam("pageNo") Integer pageNo,
            @RequestParam("pageSize") Integer pageSize,
            @RequestParam(value = "keyWord",required = false) String keyWord
            //,@RequestParam(value = "access_token",required = false)String access_token
    ){
        PageResult<KnowledgeVo> pageResult=knowledgeService.getPage(pageNo,pageSize,keyWord);
        return ResponseEntity.ok(pageResult);
    }
    /*
    *新增知识点
    */
    @PostMapping
    public void addKnowledge(@RequestBody TeaKnowledge teaKnowledge){
        int n= knowledgeService.addCourse(teaKnowledge);
    }
    /*
    *跟新知识点
     */
    @PutMapping
    public void updateKnowledge(@RequestBody TeaKnowledge teaKnowledge){
        int n= knowledgeService.update(teaKnowledge);
    }
    /*
    * 删除知识点
    */
    @DeleteMapping
    public int delete(@RequestBody List<Long> ids){
        int n= knowledgeService.delete(ids);
        if (n>0){
            return 1;
        }
        return 0;
    }
    /**
     * 通过course_id查询所有知识点
     */
    @GetMapping("/all/{courseId}")
    public List<TeaKnowledge> findAllByCourseId(@PathVariable("courseId")Long courseId){
        List<TeaKnowledge> teaKnowledgeList = knowledgeService.findAllCourseId(courseId);
        return teaKnowledgeList;
    }
}
