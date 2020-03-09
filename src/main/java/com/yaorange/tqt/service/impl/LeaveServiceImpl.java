package com.yaorange.tqt.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yaorange.tqt.mapper.LeaveMapper;
import com.yaorange.tqt.mapper.TaskMapper;
import com.yaorange.tqt.pojo.ComLeave;
import com.yaorange.tqt.pojo.Comment;
import com.yaorange.tqt.pojo.Task;
import com.yaorange.tqt.service.LeaveService;
import com.yaorange.tqt.utils.PageResultNew;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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

    @Autowired
    private ObjectMapper objectMapper;
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
        comLeave.setCreateBy("模拟用户");
        String taskId = UUID.randomUUID().toString().replaceAll("-", "");
        comLeave.setTaskId(taskId);
        leaveMapper.insert(comLeave);
        Task task = new Task();
        task.setId(taskId);
        task.setAssignee(comLeave.getReviewer());
        task.setComments(comLeave.getReason());
        task.setName("模拟用户");
        task.setUserId(199L);
        taskMapper.insertSelective(task);
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

    @Override
    public List<Comment> getCommentsByTaskId(String id) {
        Example example = new Example(ComLeave.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("taskId",id);
        ComLeave comLeave = leaveMapper.selectOneByExample(example);
        return jsonToCommentList(comLeave);

    }


    @Override
    public ComLeave findLeaveByTaskId(String taskId) {
        Example example = new Example(ComLeave.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("taskId",taskId);
        return leaveMapper.selectOneByExample(example);
    }

    @Override
    public void updateTask(ComLeave comLeave) {
        List<Comment> commentList = jsonToCommentList(comLeave);
        String commentJson = comLeave.getNewComment();
        Comment comment = new Comment();
        comment.setFullMessage(commentJson);
        commentList.add(comment);
        String json = commentListToJson(commentList);
        comLeave.setComments(json);
        leaveMapper.updateByPrimaryKeySelective(comLeave);
    }


    /**
     * 将List<Comment>转换为json
     * @param comLeave
     * @return
     */
    private List<Comment> jsonToCommentList(ComLeave comLeave){
        try {
            JavaType javaType = objectMapper.getTypeFactory().constructParametricType(ArrayList.class, Comment.class);
            List<Comment> comments = objectMapper.readValue(comLeave.getComments(), javaType);
            return comments;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            log.info("json转换到List<Comment>错误");
            return null;
        }
    }

    /**
     * 将json转换为Comment
     * @param comments
     * @return
     */
    private String commentListToJson(List<Comment> comments){
        try {
            return objectMapper.writeValueAsString(comments);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            log.info("List<Comment>转换到json错误");
            return null;
        }
    }
}
