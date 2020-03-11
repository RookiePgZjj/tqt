package com.yaorange.tqt.mapper;

import com.yaorange.tqt.pojo.VoteReply;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author:zjj
 * @date 2020/3/7 14:00
 * @description:
 */
public interface VoteReplyMapper extends Mapper<VoteReply> {
    @Select("select * from vote_reply where user_id =#{userId} and subtopicId = #{subtopicId}")
    VoteReply selectByUserIdAndSubtopicId(@Param("userId") Long userId, @Param("subtopicId") Long subtopicId);

    @Select("select user_id from vote_reply group by user_id")
    List<Long> selectAllStuId();
}
