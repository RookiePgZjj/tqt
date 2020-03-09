package com.yaorange.tqt.controller;

import com.yaorange.tqt.pojo.Model;
import com.yaorange.tqt.service.ModelService;
import com.yaorange.tqt.utils.PageResult;
import com.yaorange.tqt.vo.Ztree;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/module")
public class ModelController {
    @Resource
    private ModelService modelService;
    /**
     *zTree查找模块
     * */
    @GetMapping("all/{roleId}")
    public ResponseEntity<List<Ztree>> findModel(@PathVariable("roleId") Integer roleId){
        List<Model> allModule = modelService.findAll();//查询所有
        List<Model> findModule = modelService.findModelByRoleId(roleId);//根据角色Id查询
        ArrayList<String> modleIds = new ArrayList<>();
        for(int i=0;i<findModule.size();i++){
            modleIds.add(String.valueOf(findModule.get(i).getId()));
        }
        List<Ztree> list = new ArrayList<>(allModule.size());
        for (Model module : allModule){
            Ztree ztree = new Ztree();
            ztree.setId(String.valueOf(module.getId()));
            ztree.setpId(module.getParentId()==null?"0": String.valueOf(module.getParentId()));
            ztree.setName(module.getName());
            for(String id:modleIds){
                if(id.equals(String.valueOf(module.getId()))){
                    ztree.setChecked(true);
                    ztree.setOpen(true);
                }
            }
            list.add(ztree);
        }
        return ResponseEntity.ok(list);
    }
//    http://localhost:9999/api/module?pageNo=1&pageSize=20&access_token=test-toke
    /***
     * 分页查询
     * */
    @GetMapping
    public ResponseEntity<PageResult<Model>> pageRole(@RequestParam(value = "pageNo",required = false) Integer pageNo,
                                                      @RequestParam(value = "pageSize",required = false) Integer pageSize,
                                                      @RequestParam(value = "keyWord" ,required = false) String keyWord){
        PageResult<Model> result =  modelService.pageRole(pageNo,pageSize,keyWord);
        return ResponseEntity.ok(result);
    }
//    http://localhost:9999/api/module/getParent/0?access_token=test-token
    /**
     * 查询所有父模块
     * */
    @GetMapping("getParent/{parentId}")
    public ResponseEntity<List<Model>> getParent(@PathVariable("parentId")Integer parentId){
        List<Model> result = modelService.getParent(parentId);
        return ResponseEntity.ok(result);
    }
    /**
     * 新增模块
     * */
    @PostMapping
    public ResponseEntity<Void> addModel(@RequestBody Model model){
        modelService.addModel(model);
        return ResponseEntity.ok().build();
    }
    /***
     * 修改模块
     * */
    @PutMapping
    public ResponseEntity<Void> updateModel(@RequestBody Model model){
        modelService.updateModel(model);
        return ResponseEntity.ok().build();
    }

    /***
     * 删除
     * */
    @DeleteMapping
    public ResponseEntity<String> deleteModel(@RequestBody Integer[] mids){
        modelService.deleteModel(mids);
        return ResponseEntity.ok("1");
    }
}
