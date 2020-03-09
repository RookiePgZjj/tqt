package com.yaorange.tqt.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yaorange.tqt.mapper.CourseMapper;
import com.yaorange.tqt.mapper.KnowledgeMapper;
import com.yaorange.tqt.pojo.TeaCourse;
import com.yaorange.tqt.pojo.TeaKnowledge;
import com.yaorange.tqt.service.KnowledgeService;
import com.yaorange.tqt.utils.PageResult;
import com.yaorange.tqt.vo.KnowledgeVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class KnowledgeServiceImpl implements KnowledgeService {
    @Resource
    private KnowledgeMapper knowledgeMapper;
    @Resource
    private CourseMapper courseMapper;
    @Override
    public PageResult<KnowledgeVo> getPage(Integer pageNo, Integer pageSize, String keyWord) {
        PageHelper.startPage(pageNo,pageSize);
        Example example = new Example(TeaKnowledge.class);
        if(StringUtils.isNotBlank(keyWord)){
            example.createCriteria().andLike("name",keyWord);
        }
        Page<TeaKnowledge>page=(Page<TeaKnowledge>) knowledgeMapper.selectByExample(example);
        PageResult<KnowledgeVo> pageResult = new PageResult<>();
        List<TeaKnowledge> result = page.getResult();
        List<KnowledgeVo> boList = new ArrayList<>();

        for (TeaKnowledge knowledge :result) {
            //   System.out.println(knowledge);
            Long courseId = knowledge.getCourseId();
            TeaCourse teaCourse = courseMapper.selectByPrimaryKey(courseId);
            KnowledgeVo knowledgeBo = new KnowledgeVo();
            knowledgeBo.setCourseName(teaCourse.getName());
            knowledgeBo.setName(knowledge.getName());
            knowledgeBo.setCourseId(knowledge.getCourseId());
            knowledgeBo.setKnowledgeId(knowledge.getKnowledgeId());
            boList.add(knowledgeBo);
        }

        pageResult.setItems(boList);
        pageResult.setTotal(page.getTotal());
        pageResult.setTotalPage(Long.valueOf(page.getPages()));
        return pageResult;
    }

    @Override
    public int addCourse(TeaKnowledge teaKnowledge) {
        String knowledgeName = teaKnowledge.getName();
        Long courseId = teaKnowledge.getCourseId();
        String[] split = knowledgeName.split("，");
        int c=0;
        for(int i=0;i<split.length;i++){
            String name = split[i];
            TeaKnowledge teaKnowledge1 = new TeaKnowledge();
            teaKnowledge1.setCourseId(courseId);
            teaKnowledge1.setName(name);
            int b = knowledgeMapper.insertSelective(teaKnowledge1);
            if(b>0){
                c++;
            }
        }
        if(c==split.length) {
            return c;
        }else{
            return 0;
        }
    }

    @Override
    public int update(TeaKnowledge teaKnowledge) {
        int i = knowledgeMapper.updateByPrimaryKeySelective(teaKnowledge);
        return i;
    }

    @Override
    public int delete(List<Long> ids) {
        int i = knowledgeMapper.deleteByIdList(ids);
        return 1;
    }

    @Override
    public List<TeaKnowledge> findAllCourseId(Long courseId) {
        return  knowledgeMapper.selectByCourseId(courseId);
    }
}
