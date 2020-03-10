package com.yaorange.tqt.controller;


import com.yaorange.tqt.pojo.Class;
import com.yaorange.tqt.service.ClassService;
import com.yaorange.tqt.utils.PageResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    /**
     *分页查询
     * */
    @GetMapping
    public ResponseEntity<PageResult<Class>> pageRole(@RequestParam(value = "pageNo",required = false) Integer pageNo,
                                                      @RequestParam(value = "pageSize",required = false) Integer pageSize,
                                                      @RequestParam(value = "keyWord" ,required = false) String roleName){
        PageResult<Class> result =  classService.pageClas(pageNo,pageSize,roleName);
        return ResponseEntity.ok(result);
    }
    /****
     *新增班级
     */
    @PostMapping
    public ResponseEntity<Void> addClass(@RequestBody Class cls){
        classService.addClass(cls);
        return ResponseEntity.ok().build();
    }
    /***
     * 修改班级
     */
    @PutMapping
    public ResponseEntity<Void> updateClass(@RequestBody Class cls){
        classService.updateClass(cls);
        return ResponseEntity.ok().build();
    }

    /***
     * 删除班级
     */
    @DeleteMapping
    public ResponseEntity<String> udeleteClass(@RequestBody Integer[] cids){
        if(cids.length!=0){
            classService.deleteClass(cids);
            return ResponseEntity.ok("1");
        }
        return ResponseEntity.ok("0");
    }
}
