package com.yaorange.tqt.mapper;

import com.yaorange.tqt.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author:zjj
 * @date 2020/3/6 10:38
 * @description:
 */
public interface UserMapper extends Mapper<User> {

    @Select("select * from sys_user where role_id = 5 ")
    List<User> selectTeachers();

    @Select("select * from sys_user where class_id=#{classId}")
    List<User> selectByClassId(@Param("classId") Long classId);


    @Select("select user_id from sys_user where role_id =3")
    List<Long> selectAllStuId();

}
