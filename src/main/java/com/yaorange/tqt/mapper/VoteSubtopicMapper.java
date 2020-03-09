package com.yaorange.tqt.mapper;

import com.yaorange.tqt.pojo.Votesubtopic;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author:zjj
 * @date 2020/3/6 18:37
 * @description:
 */
public interface VoteSubtopicMapper extends Mapper<Votesubtopic> {
    @Select("select * from votesubtopic where parent_id = #{parentId}")
    List<Votesubtopic> selectByParentId(@Param("parentId") String parentId);
}
