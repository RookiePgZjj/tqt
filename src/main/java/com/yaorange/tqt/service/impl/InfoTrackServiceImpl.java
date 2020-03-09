package com.yaorange.tqt.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yaorange.tqt.mapper.InfoTrackMapper;
import com.yaorange.tqt.mapper.UserInfoMapper;
import com.yaorange.tqt.pojo.TeaInfoTrack;
import com.yaorange.tqt.pojo.UserInfo;
import com.yaorange.tqt.service.InfoTrackService;
import com.yaorange.tqt.utils.PageResultNew;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Transactional
@Service
public class InfoTrackServiceImpl implements InfoTrackService {
    @Resource
    private InfoTrackMapper infoTrackMapper;
    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public PageResultNew<TeaInfoTrack> findAllByPage(Integer pageNo, Integer pageSize, String keyWord,Long classId,Long userId) {
       PageHelper.startPage(pageNo,pageSize);
//        Example example = new Example(TeaInfoTrack.class);
//        if (StringUtils.isNotBlank(keyWord)){
//            example.createCriteria().andLike("name",keyWord);
//        }
   //     List<TeaInfoTrack> teaInfoTracks = infoTrackMapper.selectByExample(example);
        System.out.println(userId);
        List<TeaInfoTrack> teaInfoTracks = infoTrackMapper.selectall(userId);
//        List<TeaInfoTrack> teaInfoTracks = infoTrackMapper.selectAll();
        for (TeaInfoTrack teaInfoTrack:teaInfoTracks) {
            //System.out.println(teaInfoTrack.getDescription());

            Long userId1 = teaInfoTrack.getUserId();
            UserInfo userInfo = userInfoMapper.selectByUserId(userId1);
            teaInfoTrack.setUserInfo(userInfo);
            //System.out.println(teaInfoTrack.getUserInfo().getName());
        }
        Page<TeaInfoTrack> page=(Page<TeaInfoTrack>)teaInfoTracks;
        PageResultNew<TeaInfoTrack> resultNew = new PageResultNew<>();
        resultNew.setContent(teaInfoTracks);
        resultNew.setTotalElements(Long.valueOf(page.getTotal()));
        resultNew.setNumber(page.getPageNum());
        return resultNew;
    }

    @Override
    public void add(TeaInfoTrack teaInfoTrack) {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        format.format(date);
        teaInfoTrack.setUpdateTime(date);
        infoTrackMapper.insertSelective(teaInfoTrack);
    }

    @Override
    public void update(TeaInfoTrack teaInfoTrack) {
        infoTrackMapper.updateByPrimaryKey(teaInfoTrack);
    }

    @Override
    public void delete(List<Long> ids) {
        infoTrackMapper.deleteByIdList(ids);
    }
}
