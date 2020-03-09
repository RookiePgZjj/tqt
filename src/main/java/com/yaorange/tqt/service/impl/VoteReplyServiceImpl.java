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


    @Override
    public void addVoteReplies(String voteTopicId, List<VoteReply> voteReplies) {

        //模拟用户
        Long currentUser = 3L;

        Votetopic votetopic = voteTopicMapper.selectByPrimaryKey(voteTopicId);
        Integer totalCount = 0;
        for (VoteReply voteReply:voteReplies
             ) {
            voteReply.setUserId(currentUser);
            voteReplyMapper.insert(voteReply);
            Long reply = voteReply.getReply();
            totalCount += reply.intValue();
            Votesubtopic votesubtopic = voteSubtopicMapper.selectByPrimaryKey(voteReply.getSubtopicId());
            votesubtopic.setReply(reply);
            voteSubtopicMapper.updateByPrimaryKeySelective(votesubtopic);
        }
        votetopic.setTotalCount(totalCount);
        voteTopicMapper.updateByPrimaryKeySelective(votetopic);
    }


    @Override
    public List<VoteRecordVO> selectVoteRecord(String voteTopicId) {
        Votetopic votetopic = voteTopicMapper.selectByPrimaryKey(voteTopicId);
        Example example = new Example(Votesubtopic.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("parentId",voteTopicId);
        List<Votesubtopic> votesubtopics = voteSubtopicMapper.selectByExample(example);
        if (votesubtopics.size()>0){
            Votesubtopic votesubtopic = votesubtopics.get(0);
            Example recordExample = new Example(VoteReply.class);
            Example.Criteria recordCriteria = recordExample.createCriteria();
            recordCriteria.andEqualTo("subtopicId",votesubtopic.getId());
            List<VoteReply> voteReplies = voteReplyMapper.selectByExample(recordExample);
            List<VoteRecordVO> stus= new ArrayList<>();
            for (VoteReply v:voteReplies
                 ) {
                UserInfo userInfo = userInfoMapper.selectByUserId(v.getUserId());
                stus.add(new VoteRecordVO(userInfo.getName()));
            }
            return stus;
        }
        return null;
    }
}
