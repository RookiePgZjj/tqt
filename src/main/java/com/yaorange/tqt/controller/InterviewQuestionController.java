package com.yaorange.tqt.controller;

import com.yaorange.tqt.pojo.Offer;
import com.yaorange.tqt.pojo.TeaInterview;
import com.yaorange.tqt.service.impl.InterviewQuestionServiceImpl;
import com.yaorange.tqt.utils.PageResultNew;
import com.yaorange.tqt.vo.InterviewQuestionVo;
import com.yaorange.tqt.vo.InterviewVo;
import com.yaorange.tqt.vo.TextVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/interviewQuestion")
public class InterviewQuestionController {
    @Resource
    private InterviewQuestionServiceImpl interviewQuestionService;

    /**
     * 分页查询
     * pageNo, pageSize,keyWord
     * @return
     */
    @PostMapping("/search")
    public PageResultNew<TeaInterview> search(
            @RequestParam("pageNo") Integer pageNo,
            @RequestParam("pageSize") Integer pageSize,
            @RequestParam(value = "keyWord",required = false)String keyWord,
            @RequestBody Map<String, Object> map){
        return interviewQuestionService.page(pageNo,pageSize,keyWord,map);
    }

    /**
     * 新增
     * @param interviewQuestionVo
     */
    @PostMapping
    public void add(@RequestBody InterviewQuestionVo interviewQuestionVo){
        interviewQuestionService.add(interviewQuestionVo);
    }
    /**
     * 修改
     */
    @PutMapping
    public void update(@RequestBody InterviewQuestionVo interviewQuestionVo){
        interviewQuestionService.update(interviewQuestionVo);
    }

    /**
     * 删除
     */
    @DeleteMapping
    public int delete(@RequestBody List<Long> ids){
        int i=interviewQuestionService.delete(ids);
        if (i>0){
            return 1;
        }else {
            return 0;
        }
    }

    @PostMapping("/wordToTable")
    public List<InterviewQuestionVo> change(@RequestBody TextVo text){
        return interviewQuestionService.changeText(text);
    }
    @PostMapping("/batchImport")
    public void addMore(@RequestBody InterviewVo interviewVo){
        List<InterviewQuestionVo> list = interviewVo.getInterviewQuestionList();
        interviewQuestionService.addMore(list);

    }}
