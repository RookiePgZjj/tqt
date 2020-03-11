package com.yaorange.tqt.service.impl;

import com.yaorange.tqt.mapper.*;
import com.yaorange.tqt.pojo.*;
import com.yaorange.tqt.service.VoteReplyService;
import com.yaorange.tqt.vo.VoteRecordVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:zjj
 * @date 2020/3/7 13:59
 * @description:
 */
@Service
@Transactional
public class VoteReplyServiceImpl implements VoteReplyService {

    @Autowired
    private VoteReplyMapper voteReplyMapper;

    @Autowired
    private VoteTopicMapper voteTopicMapper;

    @Autowired
    private VoteSubtopicMapper voteSubtopicMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private UserMapper userMapper;


    @Override
    public void addVoteReplies(String voteTopicId, List<VoteReply> voteReplies) {

        //模拟用户
        Long currentUser = 3L;
        Integer count = 0;
        Votetopic votetopic = voteTopicMapper.selectByPrimaryKey(voteTopicId);
        for (VoteReply voteReply:voteReplies
             ) {
            voteReply.setUserId(currentUser);
            VoteReply voteReplyOld = voteReplyMapper.selectByUserIdAndSubtopicId(currentUser, voteReply.getSubtopicId());
            if (voteReplyOld != null){
                count += 1;
                voteReplyMapper.delete(voteReplyOld);
            }
            voteReplyMapper.insert(voteReply);
        }
        if (count == 0){
            votetopic.setTotalCount(votetopic.getTotalCount()+1);
        }
        voteTopicMapper.updateByPrimaryKeySelective(votetopic);
    }


    @Override
    public List<VoteRecordVO> selectVoteRecord(String voteTopicId) {
        Example example = new Example(Votesubtopic.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("parentId",voteTopicId);
//        查询该调查的所有子项
        List<Votesubtopic> votesubtopics = voteSubtopicMapper.selectByExample(example);
        List<VoteRecordVO> stus= new ArrayList<>();
//        查询所有学生的id
        List<Long> stuIds =  userMapper.selectAllStuId();
        for (Long stuId:stuIds
             ) {
            List<VoteReply> voteReplyList = new ArrayList<>();
            UserInfo userInfo = userInfoMapper.selectByUserId(stuId);
            for (Votesubtopic vs:votesubtopics
                 ) {
//                根据调查项id和学生id查询reply
                VoteReply voteReply = voteReplyMapper.selectByUserIdAndSubtopicId(stuId, vs.getId());
                voteReplyList.add(voteReply);
            }
            VoteRecordVO voteRecordVO = new VoteRecordVO(userInfo.getName(), voteReplyList);
            stus.add(voteRecordVO);
        }
        return stus;
    }
}
