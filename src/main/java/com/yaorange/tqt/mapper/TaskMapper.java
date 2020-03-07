package com.yaorange.tqt.mapper;

import com.yaorange.tqt.pojo.Task;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author:zjj
 * @date 2020/3/6 14:06
 * @description:
 */
public interface TaskMapper extends Mapper<Task> {

    @Select("select * from task where user_id = #{userId}")
    List<Task> selectByUserId(@Param("userId") long userId);
}
