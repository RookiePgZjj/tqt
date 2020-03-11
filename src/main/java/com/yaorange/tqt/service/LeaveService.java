package com.yaorange.tqt.service;

import com.yaorange.tqt.pojo.ComLeave;
import com.yaorange.tqt.pojo.Comment;
import com.yaorange.tqt.pojo.Task;
import com.yaorange.tqt.utils.PageResultNew;

import java.util.List;

/**
 * @author:zjj
 * @date 2020/3/6 10:35
 * @description:
 */
public interface LeaveService {

    PageResultNew<ComLeave> findByPage(Integer pageNo, Integer pageNo1, String keyWord);

    void addLeave(ComLeave comLeave);

    void deleteById(List<Long> ids);

    PageResultNew<Task> findAllTask(Integer pageNo, Integer pageSize);

    List<Comment> getCommentsByTaskId(String id);

    ComLeave findLeaveByTaskId(String taskId);

    void updateTask(ComLeave comLeave);

    void deleteTaskById(List<String> ids);
}
