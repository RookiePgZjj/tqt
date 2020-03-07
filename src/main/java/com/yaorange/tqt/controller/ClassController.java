package com.yaorange.tqt.controller;


import com.yaorange.tqt.pojo.Class;
import com.yaorange.tqt.service.ClassService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("api/classes")
public class ClassController {

    @Resource
    private ClassService classService;

    @GetMapping("all")
    public ResponseEntity<List<Class>> findAll(){
        List<Class> result = classService.findAll();
        return ResponseEntity.ok(result);
    }
}
