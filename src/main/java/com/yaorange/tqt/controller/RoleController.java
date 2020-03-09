package com.yaorange.tqt.controller;


import com.yaorange.tqt.pojo.Role;
import com.yaorange.tqt.service.RoleService;
import com.yaorange.tqt.utils.PageResult;
import com.yaorange.tqt.vo.MIdsRole;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("api/role")
public class RoleController {

    @Resource
    private RoleService roleService;
    /**
     *查询所有
     * */
    @GetMapping("all")
    public ResponseEntity<List<Role>> findAll(){
        List<Role> result = roleService.findAll();
        return ResponseEntity.ok(result);
    }
    /**
     *分页查询
     * */
    @GetMapping
    public ResponseEntity<PageResult<Role>> pageRole(@RequestParam(value = "pageNo",required = false) Integer pageNo,
                                                     @RequestParam(value = "pageSize",required = false) Integer pageSize,
                                                     @RequestParam(value = "name" ,required = false) String roleName){
        PageResult<Role> result =  roleService.pageRole(pageNo,pageSize,roleName);
        return ResponseEntity.ok(result);
    }
    /**
     *新增
     * */
    @PostMapping
    public ResponseEntity<String> addRole(@RequestBody Role role){
        roleService.addRole(role);
        return ResponseEntity.ok("1");
    }
    /**
     *修改
     * */
    @PutMapping
    public ResponseEntity<String> updateRole(@RequestBody MIdsRole mIdsRole){
        roleService.updateRole(mIdsRole);
        return ResponseEntity.ok("1");
    }

    /**
     *
     * **/
    @DeleteMapping
    public ResponseEntity<String> deleteRole(@RequestBody String[] roleIds){
        roleService.deleteRole(roleIds);
        return ResponseEntity.ok("1");
    }
}
