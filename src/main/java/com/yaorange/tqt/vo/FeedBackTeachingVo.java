package com.yaorange.tqt.vo;

import com.yaorange.tqt.pojo.TeaFaceBack;
import com.yaorange.tqt.pojo.UserInfo;
import lombok.Data;

import java.util.List;

/**
 *教学反馈vo
 */
@Data
public class FeedBackTeachingVo {
    private List<TeaFaceBack> teaFaceBackList;
    private List<UserInfo> unCommitedList;
    private Long total;
    private Long totalPage;
}
