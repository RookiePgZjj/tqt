package com.yaorange.tqt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yaorange.tqt.mapper.ModelMapper;
import com.yaorange.tqt.pojo.Model;
import com.yaorange.tqt.service.ModelService;
import com.yaorange.tqt.utils.PageResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
public class ModelServiceImpl implements ModelService {

    @Resource
    private ModelMapper modelMapper;

    @Override
    public List<Model> findAll() {
        return modelMapper.selectAll();
    }

    @Override
    public List<Model> findModelByRoleId(Integer roleId) {
        return  modelMapper.selectModelByRoleId(roleId);
    }

    @Override
    public PageResult<Model> pageRole(Integer pageNo, Integer pageSize, String modelName) {
        if(pageSize == null){
            pageSize=10;
        }
        PageHelper.startPage(pageNo, pageSize);
        List<Model> models = new ArrayList<>();
        if(modelName.equals("")){
            //不做搜索
            models = modelMapper.selectAll();
        }else{
            //根据模块名搜索（模糊查询）
            Example example = new Example(Model.class);
            example.createCriteria().andLike("name","%"+modelName+"%");
            models = modelMapper.selectByExample(example);
        }
        PageResult<Model> result = new PageResult<>();
        PageInfo<Model> pageInfo = new PageInfo<>(models);
        result.setNumber(Long.valueOf(pageInfo.getPageNum()));
        result.setItems(pageInfo.getList());
        result.setTotalPage(Long.valueOf(pageInfo.getPages()));
        result.setTotal(pageInfo.getTotal());
        return result;
    }
}
