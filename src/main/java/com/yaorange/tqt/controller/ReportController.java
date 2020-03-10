package com.yaorange.tqt.controller;

import com.yaorange.tqt.pojo.TeaFaceBack;
import com.yaorange.tqt.service.ReportService;
import com.yaorange.tqt.vo.AbsorptionData;
import com.yaorange.tqt.vo.AbsorptionVo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/report")
public class ReportController {

    @Resource
    private ReportService reportService;
    /**
     * 查询学生的吸收状况
     * */
    @PostMapping("absorption")
    public ResponseEntity<AbsorptionData> findAbs(@RequestBody AbsorptionVo absorptionVo){
        List<TeaFaceBack> result = reportService.findAbs(absorptionVo);
        AbsorptionData absorptionData = new AbsorptionData();
        //百分比
        List<String> titles = new ArrayList<String>();
        titles.add("0-30");
        titles.add("30-50");
        titles.add("50-70");
        titles.add("70-90");
        titles.add("90以上");
        List<Integer> values = new ArrayList<>();
        values.add(0);
        values.add(0);
        values.add(0);
        values.add(0);
        values.add(0);
        if(result!=null){
            for(TeaFaceBack teaFaceBack :result){
                if(teaFaceBack!=null){
                    String absorption = teaFaceBack.getAbsorption();
                    for(int i=0;i<titles.size();i++){
                        if(absorption.equals(titles.get(i))){
                            Integer c = values.get(i)+1;
                            values.set(i,c);
                        }
                    }
                }
            }
        }
        absorptionData.setTitles(titles);
        absorptionData.setValues(values);
        return ResponseEntity.ok(absorptionData);
    }
}
