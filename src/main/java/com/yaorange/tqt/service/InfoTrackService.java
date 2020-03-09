package com.yaorange.tqt.service;

import com.yaorange.tqt.pojo.TeaInfoTrack;
import com.yaorange.tqt.utils.PageResultNew;

import java.util.List;

public interface InfoTrackService {
    PageResultNew<TeaInfoTrack> findAllByPage(Integer pageNo, Integer pageSize, String keyWord,Long classId,Long userId);

    void add(TeaInfoTrack teaInfoTrack);

    void update(TeaInfoTrack teaInfoTrack);

    void delete(List<Long> ids);
}
