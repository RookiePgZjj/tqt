package com.yaorange.tqt.mapper;

import com.yaorange.tqt.pojo.User;
import com.yaorange.tqt.pojo.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import javax.persistence.Column;
import java.util.List;

/**
 * @author:zjj
 * @date 2020/3/6 10:38
 * @description:
 */
public interface UserInfoMapper extends Mapper<UserInfo> {
    @Select("select name,id from sys_user_info where user_id=#{userId}")
    UserInfo selectByUserId(@Param("userId") Long userId);
    @Select("select * from sys_user_info where name=#{stuName}")
    UserInfo selectByUserName(@Param("stuName") String stuName);
    @Select("<script>"+
            "select * from sys_user_info s where s.user_id not in (select t.user_id from tea_face_back t where 1=1 "+
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
            "</if>)"+
            "</script>")
    List<UserInfo> selectUnCommitedList(@Param("classId") Object classId, @Param("userId") Object userId, @Param("courseId") Object courseId, @Param("dayNum") Object dayNum);
}
