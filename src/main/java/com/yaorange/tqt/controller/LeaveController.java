package com.yaorange.tqt.controller;

import com.yaorange.tqt.pojo.ComLeave;
import com.yaorange.tqt.pojo.Task;
import com.yaorange.tqt.service.impl.LeaveServiceImpl;
import com.yaorange.tqt.utils.PageResultNew;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author:zjj
 * @date 2020/3/6 9:53
 * @description:
 */
@RestController
@RequestMapping("/api/leave")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class LeaveController {

    @Autowired
    private LeaveServiceImpl leaveService;


    /**
     * 分页查询请假申请
     */
    @GetMapping
    public PageResultNew<ComLeave> QueryAllByPage(@RequestParam("pageNo") Integer pageNo,
                                                  @RequestParam("pageSize") Integer pageSize,
                                                  @RequestParam("keyWord") String keyWord){
        return leaveService.findByPage(pageNo,pageSize,keyWord);
    }


    /**
     * 新增请假申请
     */
    @PostMapping
    public ResponseEntity<Void> addLeave(@RequestBody ComLeave comLeave){
        leaveService.addLeave(comLeave);
        return ResponseEntity.ok().build();
    }


    /**
     * 删除请假申请
     * @param ids
     * @return
     */
    @DeleteMapping
    public ResponseEntity<Void> deleteLeave(@RequestBody List<Long> ids){
        leaveService.deleteById(ids);
        return ResponseEntity.ok().build();
    }


    /**
     * 查询所有任务
     * @param pageNo
     * @param pageSize
     * @param keyWord todo
     * @return
     */
    @GetMapping("/myTaskList")
    public PageResultNew<Task> QueryAllTaskByPage(@RequestParam("pageNo") Integer pageNo,
                                                  @RequestParam("pageSize") Integer pageSize,
                                                  @RequestParam("keyWord") String keyWord) {
       return leaveService.findAllTask(pageNo,pageSize);
    }


    }

