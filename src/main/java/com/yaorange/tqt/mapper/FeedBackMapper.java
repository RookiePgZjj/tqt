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
    @Select("<script>"+
            "select * from tea_face_back t where 1=1 "+
            "<if test='classId!=null'>"+
            "and t.class_id=#{classId}"+
            "</if>"+
            "<if test='courseId!=null'>"+
            "and t.course_id=#{courseId}"+
            "</if>"+
            "<if test='dayNum!=null'>"+
            "and t.date_number=#{dayNum}"+
            "</if>"+
            "<if test='userId!=null'>"+
            "and t.user_id=#{userId}"+
            "</if>"+
            "</script>")
    //@Select("<script>" +
        //            "select o.* from tb_order o left join tb_order_status os on o.order_id = os.order_id where 1=1"+
        //            "<if test='status!=null'>"+
        //            "and os.status = #{status} "+
        //            "</if>"+
        //            "</script>")
    List<TeaFaceBack> selectAllByKeyWord(@Param("classId") Object classId,@Param("userId") Object userId,@Param("courseId") Object courseId,@Param("dayNum") Object dayNum);
}
