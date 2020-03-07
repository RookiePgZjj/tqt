package com.yaorange.tqt.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yaorange.tqt.mapper.CourseMapper;
import com.yaorange.tqt.pojo.TeaCourse;
import com.yaorange.tqt.service.CourseService;
import com.yaorange.tqt.utils.PageResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author:zjj
 * @date 2020/3/7 11:31
 * @description:
 */
@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    @Resource
    private CourseMapper courseMapper;
    @Override
    @Transactional(readOnly = true)
    public PageResult<TeaCourse> getPage(Integer pageNo, Integer pageSize, String keyWord) {
        PageHelper.startPage(pageNo, pageSize);
        Example example = new Example(TeaCourse.class);
        if(StringUtils.isNotBlank(keyWord)){
            example.createCriteria().andLike("name",keyWord);
        }
        Page<TeaCourse> page = (Page<TeaCourse>)courseMapper.selectByExample(example);
        PageResult<TeaCourse> pageResult = new PageResult<>();
        pageResult.setItems(page.getResult());
        pageResult.setTotal(page.getTotal());
        pageResult.setTotalPage(Long.valueOf(page.getPages()));

        return pageResult;
    }
    @Override
    public int addCourse(TeaCourse teaCourse) {
        int i = courseMapper.insertSelective(teaCourse);
        return i;
    }
    @Override
    public int updateCourse(TeaCourse teaCourse) {
        int i = courseMapper.updateByPrimaryKey(teaCourse);
        return i;
    }

    @Override
    public int deleteCourseByIds(List<Long> courseIds) {
        if (courseIds.size()==1){
            int i = courseMapper.deleteByPrimaryKey(courseIds.get(0));
            return i;
        }else {
            int i = courseMapper.deleteByIdList(courseIds);
            return i;
        }
    }

    @Override
    public TeaCourse findCoursesById(Long courseId) {
        TeaCourse teaCourse = courseMapper.selectById(courseId);
        return teaCourse;
    }

    @Override
    public List<TeaCourse> findAll() {
        List<TeaCourse> courseList = courseMapper.selectAll();
        return courseList;
    }
}
