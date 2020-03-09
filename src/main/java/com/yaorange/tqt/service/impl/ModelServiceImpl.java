package com.yaorange.tqt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yaorange.tqt.mapper.ModelMapper;
import com.yaorange.tqt.pojo.Model;
import com.yaorange.tqt.mapper.RoleModelMapper;
import com.yaorange.tqt.pojo.RoleModel;
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

    @Resource
    private RoleModelMapper roleModelMapper;


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
    @Override
    public List<Model> getParent(Integer parentId) {
        Model model = new Model();
        model.setParentId(parentId);
        List<Model> parentModels = modelMapper.select(model);
        return parentModels;
    }

    @Override
    public void addModel(Model model) {
        if(model.getParentId()==null){
            model.setParentId(0);
        }
        modelMapper.insert(model);
    }

    @Override
    public void updateModel(Model model) {
        modelMapper.updateByPrimaryKey(model);
    }

    @Override
    public void deleteModel(Integer[] mids) {
        for(Integer mid:mids){
            //查询模块
            Model model = modelMapper.selectByPrimaryKey(mid);
            if(model != null){
                //父模块
                //删除中间表以及子模块
                //删子模块
                if(model.getParentId()==0){
                    Model model1= new Model();
                    model1.setParentId(mid);
                    List<Model> childModels = modelMapper.select(model1);
                    //删子模块
                    for(Model childModel:childModels){
                    //删中间表
                    RoleModel roleModel = new RoleModel();
                    roleModel.setModelId(childModel.getId());
                    roleModelMapper.delete(roleModel);
                    //删当前模块
                    modelMapper.delete(childModel);
                }
            }
                //删当前模块
                //1.删中间表
                RoleModel roleModel = new RoleModel();
                roleModel.setModelId(mid);
                roleModelMapper.delete(roleModel);
                //2.删当前模块
                modelMapper.delete(model);
            }
        }
    }
}
