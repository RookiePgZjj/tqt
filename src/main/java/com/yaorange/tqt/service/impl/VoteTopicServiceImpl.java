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
import tk.mybatis.mapper.entity.Example;

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

    @Autowired
    private VoteReplyMapper voteReplyMapper;
    @Override
    public PageResultNew<Votetopic> findAllByPage(Integer pageNo, Integer pageSize,String keyword) {
        PageHelper.startPage(pageNo,pageSize);
        Page<Votetopic> votetopics = null;
        if (!"".equals(keyword)){
            Example example = new Example(Votetopic.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andLike("title","%"+keyword+"%");
             votetopics = (Page<Votetopic>) voteTopicMapper.selectByExample(example);
        }else {
             votetopics = (Page<Votetopic>) voteTopicMapper.selectAll();
        }
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
        votetopic.setTotalCount(0);
        voteTopicMapper.insertSelective(votetopic);
        List<Votesubtopic> votesubtopicList = votetopic.getVoteSubtopicList();
        votesubtopicList.forEach(votesubtopic -> {
            votesubtopic.setParentId(uuid);
            voteSubtopicMapper.insertSelective(votesubtopic);
        });
    }


    @Override
    public PageResultNew<Votetopic> findCurrentVoteTopic(Integer pageNo, Integer pageSize) {
        //模拟用户
        Long currentUser = 3L;

        User user = userMapper.selectByPrimaryKey(currentUser);
        Class aClass = classMapper.selectByPrimaryKey(user.getClassId());
        Example example = new Example(Votetopic.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("classId",user.getClassId());
        PageHelper.startPage(pageNo,pageSize);
        Page<Votetopic> votetopics = (Page<Votetopic>) voteTopicMapper.selectByExample(example);
        votetopics.forEach(votetopic -> {
            votetopic.setClasses(aClass);
            User teacher = userMapper.selectByPrimaryKey(votetopic.getUserId());
            votetopic.setTeacher(teacher);
            String name = userInfoMapper.selectByUserId(teacher.getUserId()).getName();
            if (name != null){
                votetopic.setTeacherName(name);
            }else {
                votetopic.setTeacherName(teacher.getUserName());
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
    public void deleteVoteTopic(List<String> ids) {
        ids.forEach(id ->{
            Example example = new Example(Votesubtopic.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("parentId",id);
            List<Votesubtopic> votesubtopics = voteSubtopicMapper.selectByExample(example);
            votesubtopics.forEach(votesubtopic -> {
                Example reply = new Example(VoteReply.class);
                Example.Criteria criteria1 = reply.createCriteria();
                criteria1.andEqualTo("subtopicId",votesubtopic.getId());
                voteReplyMapper.deleteByExample(reply);
            });
            voteSubtopicMapper.deleteByExample(example);
            voteTopicMapper.deleteByPrimaryKey(id);
        });
    }

}
