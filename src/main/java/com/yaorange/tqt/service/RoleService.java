package com.yaorange.tqt.service;

import com.yaorange.tqt.pojo.Role;
import com.yaorange.tqt.utils.PageResult;
import com.yaorange.tqt.vo.MIdsRole;

import java.util.List;

public interface RoleService {
    List<Role> findAll();

    PageResult<Role> pageRole(Integer pageNo, Integer pageSize, String roleName);

    void addRole(Role role);

    void updateRole(MIdsRole mIdsRole);

    void deleteRole(String[] roleIds);
}
