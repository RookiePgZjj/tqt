package com.yaorange.tqt.service.impl;

import com.yaorange.tqt.mapper.RoleMapper;
import com.yaorange.tqt.pojo.Role;
import com.yaorange.tqt.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleMapper roleMapper;
    @Override
    public List<Role> findAll() {
        List<Role> roles = roleMapper.selectAll();
        return roles;
    }
}
