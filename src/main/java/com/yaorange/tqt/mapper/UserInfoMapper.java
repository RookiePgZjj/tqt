package com.yaorange.tqt.mapper;

import com.yaorange.tqt.pojo.User;
import com.yaorange.tqt.pojo.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author:zjj
 * @date 2020/3/6 10:38
 * @description:
 */
public interface UserInfoMapper extends Mapper<UserInfo> {
    @Select("select name,id from sys_user_info where user_id=#{userId}")
    UserInfo selectByUserId(@Param("userId") Long userId);

}
