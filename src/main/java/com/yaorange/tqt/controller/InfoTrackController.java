package com.yaorange.tqt.controller;

import com.yaorange.tqt.pojo.TeaInfoTrack;
import com.yaorange.tqt.service.impl.InfoTrackServiceImpl;
import com.yaorange.tqt.utils.PageResultNew;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.common.Mapper;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/track")
public class InfoTrackController {
    @Resource
    private InfoTrackServiceImpl infoTrackService;
    /**
     * 分页
     */

    @PostMapping("/search")
    public PageResultNew<TeaInfoTrack> queryAllByPage(
            @RequestParam("pageNo") Integer pageNo,
            @RequestParam("pageSize") Integer pageSize,
            @RequestParam(value = "keyWord",required = false) String keyWord,
            @RequestBody(required = false) Map<String,Long> map
            ) {
        Long classId = map.get("classId");
        Long userId = map.get("userId");
        return infoTrackService.findAllByPage(pageNo,pageSize,keyWord,classId,userId);
    }
    /**
     * 新增
     */

    @PostMapping
    public void add(@RequestBody TeaInfoTrack teaInfoTrack){
        infoTrackService.add(teaInfoTrack);
    }
    /**
     * 修改
     */
    @PutMapping
    public void update(@RequestBody TeaInfoTrack teaInfoTrack){
        infoTrackService.update(teaInfoTrack);
    }
    /**
     * 删除
     */
    @DeleteMapping
    public void delete(@RequestBody List<Long> ids){
        infoTrackService.delete(ids);

    }
}
