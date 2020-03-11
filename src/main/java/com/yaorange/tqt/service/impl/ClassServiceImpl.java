package com.yaorange.tqt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yaorange.tqt.mapper.ClassMapper;
import com.yaorange.tqt.mapper.FeedBackMapper;
import com.yaorange.tqt.mapper.UserMapper;
import com.yaorange.tqt.mapper.VoteTopicMapper;
import com.yaorange.tqt.pojo.Class;
import com.yaorange.tqt.pojo.TeaFaceBack;
import com.yaorange.tqt.pojo.User;
import com.yaorange.tqt.pojo.Votetopic;
import com.yaorange.tqt.service.ClassService;
import com.yaorange.tqt.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ClassServiceImpl implements ClassService {
    @Resource
    private ClassMapper classMapper;

    @Resource
    private UserMapper userMapper;

    @Autowired
    private FeedBackMapper feedBackMapper;

    @Autowired
    private VoteTopicMapper voteTopicMapper;

    @Override
    public List<Class> findAll() {
        List<Class> roles = classMapper.selectAll();
        return roles;
    }

    @Override
    public PageResult<Class> pageClas(Integer pageNo, Integer pageSize, String keyWord) {
        if (pageSize == null) {
            pageSize = 10;
        }
        PageHelper.startPage(pageNo, pageSize);
        List<Class> classes = new ArrayList<>();
        if (keyWord.equals("")) {
            //不做搜索
            classes = classMapper.selectAll();
        } else {
            //根据模块名搜索（模糊查询）
            Example example = new Example(Class.class);
            example.createCriteria().andLike("name", "%" + keyWord + "%");
            classes = classMapper.selectByExample(example);
        }
        PageResult<Class> result = new PageResult<>();
        PageInfo<Class> pageInfo = new PageInfo<>(classes);
        result.setNumber(Long.valueOf(pageInfo.getPageNum()));
        result.setItems(pageInfo.getList());
        result.setTotalPage(Long.valueOf(pageInfo.getPages()));
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public void addClass(Class cls) {
        classMapper.insert(cls);
    }

    @Override
    public void updateClass(Class cls) {
        classMapper.updateByPrimaryKey(cls);
    }

    @Override
    public void deleteClass(Integer[] cids) {
        for (Integer cid : cids) {
            //所有与课程相关的用户的课程Id设置为空
            //用户
            User user = new User();
            user.setClassId(Long.valueOf(cid));
            List<User> users = userMapper.select(user);
            for (User us : users) {
                us.setClassId(null);
                userMapper.updateByPrimaryKey(us);
            }
            //反馈
            TeaFaceBack teaFaceBack = new TeaFaceBack();
            teaFaceBack.setClassId(Long.valueOf(cid));
            List<TeaFaceBack> teaFaceBacks = feedBackMapper.select(teaFaceBack);
            for (TeaFaceBack tfb : teaFaceBacks) {
                tfb.setClassId(null);
                feedBackMapper.updateByPrimaryKey(tfb);
            }
            //voteTopic
            Votetopic votetopic = new Votetopic();
            votetopic.setClassId(Long.valueOf(cid));
            List<Votetopic> votetopics = voteTopicMapper.select(votetopic);
            for (Votetopic vt : votetopics) {
                vt.setClassId(null);
                voteTopicMapper.updateByPrimaryKey(vt);
            }
            Class a = classMapper.selectByPrimaryKey(cid);
            classMapper.delete(a);
        }
    }
}
