package com.yaorange.tqt.mapper;

import com.yaorange.tqt.pojo.Model;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


public interface ModelMapper extends Mapper<Model> {

    @Select("SELECT m.id,m.`name`,m.`status`,m.explain1,m.parent_id from sys_model m,sys_role r,role_model rm where rm.model_id=m.id and rm.role_id = r.role_id  and rm.role_id = #{roleId}")
    List<Model> selectModelByRoleId(@Param("roleId") Integer roleId);
}
