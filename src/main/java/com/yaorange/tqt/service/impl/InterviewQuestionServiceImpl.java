package com.yaorange.tqt.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yaorange.tqt.config.Replace;
import com.yaorange.tqt.mapper.CourseMapper;
import com.yaorange.tqt.mapper.KnowledgeMapper;
import com.yaorange.tqt.mapper.TeaInterviewMapper;
import com.yaorange.tqt.pojo.TeaCourse;
import com.yaorange.tqt.pojo.TeaInterview;
import com.yaorange.tqt.pojo.TeaKnowledge;
import com.yaorange.tqt.service.InterviewQuestionService;
import com.yaorange.tqt.utils.PageResultNew;
import com.yaorange.tqt.vo.InterviewQuestionVo;
import com.yaorange.tqt.vo.TextVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class InterviewQuestionServiceImpl implements InterviewQuestionService {
    @Resource
    private TeaInterviewMapper teaInterviewMapper;
    @Resource
    private CourseMapper courseMapper;
    @Resource
    private KnowledgeMapper knowledgeMapper;
    @Override
    public PageResultNew<TeaInterview> page(Integer pageNo, Integer pageSize, String keyWord, Map<String, Object> map) {
        PageHelper.startPage(pageNo,pageSize);
        Object courseId1 = map.get("courseId");
        Object knowledgePointId = map.get("knowledgePointId");
        Object title = map.get("title");
        if (courseId1.equals("")){
            courseId1=null;
        }
        if (knowledgePointId.equals("")){
            knowledgePointId=null;
        }
        if(title.equals("")){
            title=null;
        }
        List<TeaInterview> teaInterviews = teaInterviewMapper.selectall(courseId1,knowledgePointId,title);
        for (TeaInterview teaInterview :teaInterviews) {
            Long courseId = teaInterview.getCourseId();
            Long knowledgeId = teaInterview.getKnowledgeId();
            TeaCourse teaCourse = courseMapper.selectById(courseId);
            TeaKnowledge teaKnowledge = knowledgeMapper.selectByPrimaryKey(knowledgeId);
            teaInterview.setCourse(teaCourse);
            teaInterview.setKnowledgePoint(teaKnowledge);
        }
        Page<TeaInterview> page= (Page<TeaInterview>) teaInterviews;
        PageResultNew<TeaInterview> pageResultNew = new PageResultNew<>();
        pageResultNew.setContent(teaInterviews);
        pageResultNew.setSize(page.getPageSize());
        pageResultNew.setTotalElements(page.getTotal());
        pageResultNew.setNumber(page.getPageNum());
        return pageResultNew;
    }

    @Override
    public void add(InterviewQuestionVo interviewQuestionVo) {
        TeaInterview teaInterview = new TeaInterview();
        String answer = interviewQuestionVo.getAnswer();
        Long courseId = interviewQuestionVo.getCourse().getCourseId();
        Long knowledgeId = interviewQuestionVo.getKnowledgePoint().getKnowledgeId();
        String title = interviewQuestionVo.getTitle();
        teaInterview.setTitle(title);
        teaInterview.setAnswer(answer);
        teaInterview.setCourseId(courseId);
        teaInterview.setKnowledgeId(knowledgeId);
        teaInterviewMapper.insertSelective(teaInterview);
    }

    @Override
    public void update(InterviewQuestionVo interviewQuestionVo) {
        TeaInterview teaInterview = new TeaInterview();
        Long id = interviewQuestionVo.getId();
        String answer = interviewQuestionVo.getAnswer();
        Long courseId = interviewQuestionVo.getCourse().getCourseId();
        Long knowledgeId = interviewQuestionVo.getKnowledgePoint().getKnowledgeId();
        String title = interviewQuestionVo.getTitle();
        teaInterview.setTitle(title);
        teaInterview.setAnswer(answer);
        teaInterview.setCourseId(courseId);
        teaInterview.setKnowledgeId(knowledgeId);
        teaInterview.setId(id);
        System.out.println(teaInterview);
        teaInterviewMapper.updateByPrimaryKeySelective(teaInterview);
    }

    @Override
    public int delete(List<Long> ids) {
        return teaInterviewMapper.deleteByIdList(ids);
    }

    @Override
    public List<InterviewQuestionVo> changeText(TextVo text) {
        String text1 = text.getText();
        String tagfilter = Replace.tagfilter(text1);
        String[] split = tagfilter.split("-");
        List<InterviewQuestionVo> list = new ArrayList<>();
        TeaCourse teaCourse = new TeaCourse();
        TeaKnowledge teaKnowledge = new TeaKnowledge();
        for(int x=0;x<(split.length)/2;x++) {
            InterviewQuestionVo interviewQuestionVo = new InterviewQuestionVo();
            for(int i=0;i<2;i++){
                if(i%2==0) {
                    String substring = split[i + x+x].substring(split[i].indexOf("：") + 1);
                    interviewQuestionVo.setTitle(substring);
                }else {
                    String substring = split[i + x+x].substring(split[i].indexOf("：") + 1);
                    interviewQuestionVo.setAnswer(substring);
                }
                interviewQuestionVo.setCourse(teaCourse);
                interviewQuestionVo.setKnowledgePoint(teaKnowledge);
            }
            list.add(interviewQuestionVo);
        }
        return list;
    }

    @Override
    public void addMore(List<InterviewQuestionVo> list) {
        for (int i=0;i<list.size();i++){
            InterviewQuestionVo interviewQuestionVo = list.get(i);

            add(interviewQuestionVo);
        }
    }
}
