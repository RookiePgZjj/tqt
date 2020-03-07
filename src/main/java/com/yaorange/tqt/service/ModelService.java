package com.yaorange.tqt.service;

import com.yaorange.tqt.pojo.Model;
import com.yaorange.tqt.utils.PageResult;

import java.util.List;

public interface ModelService {
    List<Model> findAll();

    List<Model> findModelByRoleId(Integer roleId);

    PageResult<Model> pageRole(Integer pageNo, Integer pageSize, String roleName);

}
