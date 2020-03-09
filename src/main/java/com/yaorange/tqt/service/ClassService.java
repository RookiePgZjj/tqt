package com.yaorange.tqt.service;

import com.yaorange.tqt.pojo.Class;
import com.yaorange.tqt.utils.PageResult;

import java.util.List;

public interface ClassService {
    List<Class> findAll();

    PageResult<Class> pageClas(Integer pageNo, Integer pageSize, String roleName);

    void addClass(Class cls);

    void updateClass(Class cls);

    void deleteClass(Integer[] cids);
}
