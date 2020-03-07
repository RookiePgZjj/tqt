package com.yaorange.tqt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yaorange.tqt.mapper.RoleMapper;
import com.yaorange.tqt.mapper.RoleModelMapper;
import com.yaorange.tqt.pojo.Role;
import com.yaorange.tqt.pojo.RoleModel;
import com.yaorange.tqt.service.RoleService;
import com.yaorange.tqt.utils.PageResult;
import com.yaorange.tqt.vo.MIdsRole;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleMapper roleMapper;

    @Resource
    private RoleModelMapper roleModelMapper;
    @Override
    public List<Role> findAll() {
        List<Role> roles = roleMapper.selectAll();
        return roles;
    }

    @Override
    public PageResult<Role> pageRole(Integer pageNo, Integer pageSize, String roleName) {
        if(pageSize == null){
            pageSize=10;
        }
        PageHelper.startPage(pageNo, pageSize);
        List<Role> roles = new ArrayList<>();
        if(roleName.equals("")){
            //不做搜索
            roles = roleMapper.selectAll();
        }else{
            //根据角色名搜索（模糊查询）
            Example example = new Example(Role.class);
            example.createCriteria().andLike("roleName","%"+roleName+"%");
            roles = roleMapper.selectByExample(example);
        }
        PageResult<Role> result = new PageResult<>();
        PageInfo<Role> pageInfo = new PageInfo<>(roles);
        result.setNumber(Long.valueOf(pageInfo.getPageNum()));
        result.setItems(pageInfo.getList());
        result.setTotalPage(Long.valueOf(pageInfo.getPages()));
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public void addRole(Role role) {
        roleMapper.insert(role);
    }

    @Override
    public void updateRole(MIdsRole mIdsRole) {
        roleMapper.updateByPrimaryKey(mIdsRole);
        for(String mids:mIdsRole.getModuleIds()){
            RoleModel roleModel = new RoleModel();
            roleModel.setRoleId(mIdsRole.getRoleId());
            roleModel.setModelId(Integer.valueOf(mids));
            roleModelMapper.insert(roleModel);
        }
    }

    @Override
    public void deleteRole(String[] roleIds) {
        for(String roleId:roleIds){
            Integer id = Integer.valueOf(roleId);
            //角色管理模块，先删中间表的信息
            RoleModel roleModel = new RoleModel();
            roleModel.setRoleId(id);
            List<RoleModel> rms = roleModelMapper.select(roleModel);
            for(RoleModel rm : rms){
                roleModelMapper.delete(rm);
            }
            //删角色
            roleMapper.deleteByPrimaryKey(roleId);
        }
    }
}
