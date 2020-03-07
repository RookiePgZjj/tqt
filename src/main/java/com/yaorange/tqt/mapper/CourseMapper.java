package com.yaorange.tqt.mapper;

import com.yaorange.tqt.pojo.TeaCourse;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.additional.idlist.DeleteByIdListMapper;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author:zjj
 * @date 2020/3/6 14:50
 * @description:
 */
public interface CourseMapper extends Mapper<TeaCourse>,DeleteByIdListMapper<TeaCourse,Long> {
    @Select("select * from tea_course where course_id = #{courseId}")
    TeaCourse selectById(@Param("courseId") Long courseId);
}
