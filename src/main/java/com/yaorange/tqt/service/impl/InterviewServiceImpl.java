package com.yaorange.tqt.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yaorange.tqt.mapper.InterviewMapper;
import com.yaorange.tqt.mapper.UserInfoMapper;
import com.yaorange.tqt.mapper.UserMapper;
import com.yaorange.tqt.pojo.Interview;
import com.yaorange.tqt.pojo.User;
import com.yaorange.tqt.pojo.UserInfo;
import com.yaorange.tqt.service.InterviewService;
import com.yaorange.tqt.utils.PageResultNew;
import com.yaorange.tqt.vo.SerachFormVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author:zjj
 * @date 2020/3/7 14:35
 * @description:
 */

@Slf4j
@Service
@Transactional
public class InterviewServiceImpl implements InterviewService {

    @Autowired
    private InterviewMapper interviewMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    /**
     * @param pageNo
     * @param pageSize
     * @param keyword  暂时未作处理
     * @return
     */
    @Override
    public PageResultNew<Interview> findByPage(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        Page<Interview> interviews = (Page<Interview>) interviewMapper.selectAll();
        PageResultNew<Interview> pageResult = new PageResultNew<>();
        pageResult.setContent(interviews);
        pageResult.setNumber(interviews.getPageNum());
        pageResult.setSize(interviews.getPageSize());
        pageResult.setTotalElements(interviews.getTotal());
        return pageResult;
    }

    @Override
    public PageResultNew<Interview> findByVO(Integer pageNo, Integer pageSize, SerachFormVO serachFormVO) {
        Long classId = serachFormVO.getClassId();
        String stuName = serachFormVO.getStuName();
        String companyName = serachFormVO.getCompanyName();
        Example example = new Example(Interview.class);
        Example.Criteria criteria = example.createCriteria();

        if (classId != null) {
            criteria.andLike("class_id", classId.toString());
        }

        if (!"".equals(stuName)) {
            criteria.andLike("stu_name", stuName);
        }

        if (!"".equals(companyName)) {
            criteria.andLike("companyName", companyName);
        }
        PageHelper.startPage(pageNo, pageSize);
        Page<Interview> interviews = (Page<Interview>) interviewMapper.selectByExample(example);
        return getPageResult(interviews);
    }

    @Override
    public void addInterview(Interview interview) {
        //模拟用户
        Long currentUserId = 11L;
        User user = userMapper.selectByPrimaryKey(currentUserId);
        UserInfo userInfo = userInfoMapper.selectByUserId(user.getUserId());
        interview.setUserId(currentUserId);
        interview.setStuName(userInfo.getName());
        interview.setClassId(user.getClassId());
        interviewMapper.insert(interview);
    }


    @Override
    public void deleteByIds(List<Long> ids) {
        //模拟用户
        Long currentUserId = 11L;
        for (Long id : ids
                ) {
            interviewMapper.deleteByPrimaryKey(id);
        }
    }


    @Override
    public Boolean updateInterview(Interview interview) {

        interviewMapper.updateByPrimaryKey(interview);
        return true;
    }

    @Override
    public PageResultNew<Interview> findCurrentByPage(Integer pageNo, Integer pageSize ,SerachFormVO serachFormVO) {

        //模拟用户
        Long currentUserId = 11L;

        Example example = new Example(Interview.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userId",currentUserId);
        if (serachFormVO == null){
            PageHelper.startPage(pageNo,pageSize);
            Page<Interview> interviews = (Page<Interview>) interviewMapper.selectByExample(example);
            return getPageResult(interviews);
        }else {
            Long classId = serachFormVO.getClassId();
            String stuName = serachFormVO.getStuName();
            String companyName = serachFormVO.getCompanyName();
            if (classId != null) {
                criteria.andLike("classId", classId.toString());
            }
            if (!"".equals(stuName)) {
                criteria.andLike("stuName", stuName);
            }
            if (!"".equals(companyName)) {
                criteria.andLike("companyName", companyName);
            }
            PageHelper.startPage(pageNo,pageSize);
            Page<Interview> interviews = (Page<Interview>) interviewMapper.selectByExample(example);
            return getPageResult(interviews);
        }
    }


    public PageResultNew<Interview> getPageResult(Page<Interview> interviews){
        PageResultNew<Interview> pageResult = new PageResultNew<>();
        pageResult.setContent(interviews);
        pageResult.setNumber(interviews.getPageNum());
        pageResult.setSize(interviews.getPageSize());
        pageResult.setTotalElements(interviews.getTotal());
        return pageResult;
    }
}
