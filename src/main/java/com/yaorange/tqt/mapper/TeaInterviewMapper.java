package com.yaorange.tqt.mapper;

import com.yaorange.tqt.pojo.TeaInterview;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.additional.idlist.DeleteByIdListMapper;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TeaInterviewMapper extends Mapper<TeaInterview> , DeleteByIdListMapper<TeaInterview,Long>{
    @Select("<script>"+
            "select * from tea_interview t where 1=1"+
            "<if test='courseId!=null'>"+
            "and t.course_id=#{courseId}"+
            "</if>"+
            "<if test='knowledgePointId!=null'>"+
            "and t.knowledge_id=#{courseId}"+
            "</if>"+
            "<if test='title!=null'>"+
            "and t.title=#{title}"+
            "</if>"+
            "</script>")
    List<TeaInterview> selectall(@Param("courseId") Object courseId1,@Param("knowledgePointId") Object knowledgePointId, @Param("title") Object title);
}
