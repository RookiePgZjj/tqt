package com.yaorange.tqt.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yaorange.tqt.mapper.LeaveMapper;
import com.yaorange.tqt.mapper.TaskMapper;
import com.yaorange.tqt.pojo.ComLeave;
import com.yaorange.tqt.pojo.Task;
import com.yaorange.tqt.service.LeaveService;
import com.yaorange.tqt.utils.PageResultNew;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author:zjj
 * @date 2020/3/6 10:36
 * @description:
 */
@Service
@Transactional
@Slf4j
public class LeaveServiceImpl implements LeaveService {

    @Autowired
    private LeaveMapper leaveMapper;

    @Autowired
    private TaskMapper taskMapper;


    @Override
    public PageResultNew<ComLeave> findByPage(Integer pageNo, Integer pageSize, String keyWord) {
        PageResultNew<ComLeave> pageResult  = new PageResultNew<>();
        if ("".equals(keyWord)){
            PageHelper.startPage(pageNo,pageSize);
            Page<ComLeave> page = (Page<ComLeave>) leaveMapper.selectAll();

            pageResult.setContent(page.getResult());
            pageResult.setNumber(page.getPageNum());
            pageResult.setSize(page.getPageSize());
            pageResult.setTotalElements(page.getTotal());
            return pageResult;
        }else {
            log.info("有关键字");
            return null;
        }
    }

    @Override
    public void addLeave(ComLeave comLeave) {
        //模拟用户
        comLeave.setUserId(199L);

        leaveMapper.insert(comLeave);
    }

    @Override
    public void deleteById(List<Long> ids) {
        ids.forEach(id ->{
            leaveMapper.deleteByPrimaryKey(id);
        });
    }

    @Override
    public PageResultNew<Task> findAllTask(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        PageResultNew<Task> pageResult = new PageResultNew<>();
        Page<Task> tasks = (Page<Task>) taskMapper.selectByUserId(199L);
        pageResult.setContent(tasks);
        pageResult.setSize(tasks.getPageSize());
        pageResult.setTotalElements(tasks.getTotal());
        pageResult.setNumber(tasks.getPageNum());
        return pageResult;
    }

}
