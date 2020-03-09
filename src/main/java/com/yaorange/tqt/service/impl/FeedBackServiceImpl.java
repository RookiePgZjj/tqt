package com.yaorange.tqt.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yaorange.tqt.mapper.CourseMapper;
import com.yaorange.tqt.mapper.FeedBackMapper;
import com.yaorange.tqt.mapper.UserInfoMapper;
import com.yaorange.tqt.pojo.TeaCourse;
import com.yaorange.tqt.pojo.TeaFaceBack;
import com.yaorange.tqt.pojo.UserInfo;
import com.yaorange.tqt.service.FeedBackService;

import com.yaorange.tqt.utils.PageResultNew;
import com.yaorange.tqt.vo.FeedBackVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author:zjj
 * @date 2020/3/6 14:36
 * @description:
 */

@Service
@Slf4j
@Transactional
public class FeedBackServiceImpl implements FeedBackService {

    @Autowired
    private FeedBackMapper feedBackMapper;


    @Autowired
    private CourseMapper courseMapper;


    @Autowired
    private UserInfoMapper userInfoMapper;


    @Override
    public PageResultNew<FeedBackVo> findAllByPage(Integer pageNo, Integer pageSize, String keyWord) {

        //todo 权限判断
        Example example = new Example(TeaFaceBack.class);
        Example.Criteria criteria = example.createCriteria();
        //模拟用户
        criteria.andEqualTo("userId",5L);

        if (!"".equals(keyWord)){
            Example userInfoExample = new Example(UserInfo.class);
            Example.Criteria userInfoExampleCriteria = userInfoExample.createCriteria();
            userInfoExampleCriteria.andLike("name","%"+keyWord+"%");
            List<UserInfo> userInfos = userInfoMapper.selectByExample(userInfoExample);
            userInfos.forEach(userInfo -> {
                Long userId = userInfo.getUserId();
                criteria.andEqualTo("userId",userId);
                example.or(criteria);
            });
        }
        PageHelper.startPage(pageNo, pageSize);
        List<TeaFaceBack> backs = feedBackMapper.selectByExample(example);

        List<FeedBackVo> feedBackVos = backs.stream().map(back -> {
            FeedBackVo feedBackVo = new FeedBackVo();
            TeaCourse coursesById = courseMapper.selectById(back.getCourseId());
            back.setCourse((coursesById));
            BeanUtils.copyProperties(back, feedBackVo);
            String name = userInfoMapper.selectByUserId(5L).getName();
            feedBackVo.setStuName(name);
            return feedBackVo;
        }).collect(Collectors.toList());

        Page<TeaFaceBack> pages = (Page<TeaFaceBack>) backs;
        PageResultNew<FeedBackVo> pageResult = new PageResultNew<>();
        pageResult.setContent(feedBackVos);
        pageResult.setNumber(pages.getPageNum());
        pageResult.setTotalElements(pages.getTotal());
        pageResult.setSize(pages.getPageSize());
        return pageResult;
    }

    @Override
    public void updateFeedBack(TeaFaceBack teaFaceBack) {

        int update = feedBackMapper.update(teaFaceBack);
        log.info(update + "");
    }

    @Override
    public void addFeedBack(TeaFaceBack teaFaceBack) {
        teaFaceBack.setCourseId(teaFaceBack.getCourse().getCourseId());
        //模拟用户
        teaFaceBack.setUserId(5L);
        feedBackMapper.insertSelective(teaFaceBack);
    }

    @Override
    public void deleteByIds(List<Long> ids) {
        ids.forEach(id -> {
            feedBackMapper.deleteByPrimaryKey(id);
        });
    }
}
