package com.yaorange.tqt.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yaorange.tqt.mapper.*;
import com.yaorange.tqt.pojo.*;
import com.yaorange.tqt.pojo.Class;
import com.yaorange.tqt.service.VoteTopicService;
import com.yaorange.tqt.utils.PageResultNew;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * @author:zjj
 * @date 2020/3/6 16:55
 * @description:
 */
@Service
@Transactional
public class VoteTopicServiceImpl implements VoteTopicService {

    @Autowired
    private VoteTopicMapper voteTopicMapper;

    @Autowired
    private ClassMapper classMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private VoteSubtopicMapper voteSubtopicMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;
    @Override
    public PageResultNew<Votetopic> findAllByPage(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        Page<Votetopic> votetopics = (Page<Votetopic>) voteTopicMapper.selectAll();

        votetopics.forEach(votetopic -> {
            Class aClass = classMapper.selectByPrimaryKey(votetopic.getClassId());
            votetopic.setClasses(aClass);
            User user = userMapper.selectByPrimaryKey(votetopic.getUserId());
            votetopic.setTeacher(user);
            String name = userInfoMapper.selectByUserId(user.getUserId()).getName();
            if (name != null){
                votetopic.setTeacherName(name);
            }else {
                votetopic.setTeacherName(user.getUserName());
            }
        });

        PageResultNew<Votetopic> pageResult = new PageResultNew<>();
        pageResult.setContent(votetopics);
        pageResult.setSize(votetopics.getPageSize());
        pageResult.setTotalElements(votetopics.getTotal());
        pageResult.setNumber(votetopics.getPageNum());
        return pageResult;
    }


    @Override
    public void addVoteTopic(Votetopic votetopic) {

        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        votetopic.setId(uuid);

        Long userId = votetopic.getTeacher().getUserId();
        UserInfo userInfo = userInfoMapper.selectByUserId(userId);
        votetopic.setTeacherName(userInfo.getName());
        votetopic.setUserId(userId);
        votetopic.setClassId(Long.valueOf(votetopic.getClasses().getClassId()));

        voteTopicMapper.insertSelective(votetopic);
        List<Votesubtopic> votesubtopicList = votetopic.getVoteSubtopicList();
        votesubtopicList.forEach(votesubtopic -> {
            votesubtopic.setParentId(uuid);
            voteSubtopicMapper.insertSelective(votesubtopic);
        });
    }
}
