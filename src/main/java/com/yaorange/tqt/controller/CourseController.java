package com.yaorange.tqt.controller;

import com.yaorange.tqt.pojo.TeaCourse;

import com.yaorange.tqt.service.impl.CourseServiceImpl;
import com.yaorange.tqt.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course")
public class CourseController {
    @Autowired
    private CourseServiceImpl courseService;

    @GetMapping
    public ResponseEntity<PageResult<TeaCourse>> getPage(
            @RequestParam("pageNo") Integer pageNo,
            @RequestParam("pageSize") Integer pageSize,
            @RequestParam(value = "keyWord",required = false) String keyWord,
            @RequestParam(value = "access_token",required = false)String access_token){
        PageResult<TeaCourse> pageResult=courseService.getPage(pageNo,pageSize,keyWord);
        return ResponseEntity.ok(pageResult);
    }
    @PostMapping
    public void addCourse(@RequestBody TeaCourse teaCourse){
       int n= courseService.addCourse(teaCourse);
    }

    @PutMapping
    public void updateCourse(@RequestBody TeaCourse teaCourse){
        int n=courseService.updateCourse(teaCourse);
    }

    @DeleteMapping
    public int deleteCourse(@RequestBody List<Long> courseIds){
        int n=courseService.deleteCourseByIds(courseIds);
        if(n>0) {
            return 1;
        }
        return 0;
    }
    @GetMapping("/all")
    public List<TeaCourse> findAll() {
        List<TeaCourse> courseList = courseService.findAll();
        return courseList;
    }
}
