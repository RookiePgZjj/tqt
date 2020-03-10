package com.yaorange.tqt.service.impl;

import com.yaorange.tqt.mapper.ReportMapper;
import com.yaorange.tqt.mapper.UserInfoMapper;
import com.yaorange.tqt.pojo.TeaFaceBack;
import com.yaorange.tqt.pojo.UserInfo;
import com.yaorange.tqt.service.ReportService;
import com.yaorange.tqt.vo.AbsorptionVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
public class ReportServiceImpl implements ReportService {
    @Resource
    private ReportMapper reportMapper;
    @Resource
    private UserInfoMapper userInfoMapper;
    @Override
    public List<TeaFaceBack> findAbs(AbsorptionVo absorptionVo) {
        List<TeaFaceBack> teaFaceBacks = new ArrayList<>();
        //如果为空，则返回所有
        if("".equals(absorptionVo.getStuName())
                && absorptionVo.getClassId() == null
                && absorptionVo.getCourseId() == null
                && absorptionVo.getDateNumber() == null
        ){
            teaFaceBacks = reportMapper.selectAll();
        }else {
            Example example = new Example(TeaFaceBack.class);
            Example.Criteria criteria = example.createCriteria();
            if(absorptionVo.getClassId() != null){
                criteria.andEqualTo("classId",absorptionVo.getClassId());
            }
            if(absorptionVo.getCourseId() != null){
                criteria.andEqualTo("courseId",absorptionVo.getCourseId());
            }
            if(absorptionVo.getDateNumber() != null){
                criteria.andEqualTo("dateNumber",absorptionVo.getDateNumber());
            }
            //根据姓名查找用户ID
            if(!"" .equals(absorptionVo.getStuName())){
                //用户名存在
                UserInfo userInfo = new UserInfo();
                Example userInfoExample = new Example(UserInfo.class);
                userInfoExample.createCriteria().andLike("name","%"+absorptionVo.getStuName()+"%");
                List<UserInfo> userInfos = userInfoMapper.selectByExample(userInfoExample);
                for(UserInfo userInfo1:userInfos){
                    criteria.andEqualTo("userId",userInfo1.getUserId());
                    TeaFaceBack teaFaceBack = reportMapper.selectOneByExample(example);
                    teaFaceBacks.add(teaFaceBack);
                }
            }else{
                teaFaceBacks = reportMapper.selectByExample(example);
            }
        }
        return teaFaceBacks;
    }
}
