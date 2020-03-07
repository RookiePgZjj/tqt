package com.yaorange.tqt.mapper;

import com.yaorange.tqt.pojo.User;
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
}
