package com.yaorange.tqt.mapper;

import com.yaorange.tqt.pojo.TeaFaceBack;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author:zjj
 * @date 2020/3/6 14:37
 * @description:
 */
public interface FeedBackMapper extends Mapper<TeaFaceBack> {

    @Select("select * from tea_face_back where user_id = #{userId}")
    List<TeaFaceBack> selectAllByUserId(@Param("userId") long userId);

    @Update("update tea_face_back " +
            "set user_id = #{userId}," +
            "course_id = #{courseId}," +
            "date_number = #{dateNumber}," +
            "absorption = #{absorption}," +
            "probleam = #{probleam}," +
            "sub_date = #{subDate}," +
            "goal = #{goal}," +
            "programme = #{programme}," +
            "detect = #{detect}," +
            "adjustment = #{adjustment}")
    int update(TeaFaceBack teaFaceBack);
}
