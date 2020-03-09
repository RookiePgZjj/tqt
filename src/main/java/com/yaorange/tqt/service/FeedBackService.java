package com.yaorange.tqt.service;


import com.yaorange.tqt.pojo.TeaFaceBack;
import com.yaorange.tqt.utils.PageResultNew;
import com.yaorange.tqt.vo.FeedBackTeachingVo;
import com.yaorange.tqt.vo.FeedBackVo;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

/**
 * @author:zjj
 * @date 2020/3/6 14:36
 * @description:
 */
public interface FeedBackService {
    PageResultNew<FeedBackVo> findAllByPage(Integer pageNo, Integer pageSize, String keyWord);

    void updateFeedBack(TeaFaceBack teaFaceBack);

    void addFeedBack(TeaFaceBack teaFaceBack);

    void deleteByIds(List<Long> ids);

    FeedBackTeachingVo findTeachingByPage(Integer pageNo, Integer pageSize, Map<String,Long> map);
}
