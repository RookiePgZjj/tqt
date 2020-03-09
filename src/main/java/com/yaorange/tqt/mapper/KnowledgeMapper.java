package com.yaorange.tqt.mapper;

import com.yaorange.tqt.pojo.TeaKnowledge;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.additional.idlist.DeleteByIdListMapper;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface KnowledgeMapper extends Mapper<TeaKnowledge>, DeleteByIdListMapper<TeaKnowledge,Long> {

    @Select("select * from tea_knowledge t where t.course_id=#{courseId}")
    List<TeaKnowledge> selectByCourseId(@Param("courseId") Long courseId);
}

