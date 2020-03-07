package com.yaorange.tqt.service.impl;

import com.yaorange.tqt.mapper.ClassMapper;
import com.yaorange.tqt.pojo.Class;
import com.yaorange.tqt.service.ClassService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class ClassServiceImpl implements ClassService {
    @Resource
    private ClassMapper classMapper;
    @Override
    public List<Class> findAll() {
        List<Class> roles = classMapper.selectAll();
        return roles;
    }
}
