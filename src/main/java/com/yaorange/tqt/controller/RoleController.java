package com.yaorange.tqt.controller;


import com.yaorange.tqt.pojo.Role;
import com.yaorange.tqt.service.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("api/role")
public class RoleController {

    @Resource
    private RoleService roleService;

    @GetMapping("all")
    public ResponseEntity<List<Role>> findAll(){
        List<Role> result = roleService.findAll();
        return ResponseEntity.ok(result);
    }
}
