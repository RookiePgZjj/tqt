package com.yaorange.tqt.controller;

import com.yaorange.tqt.pojo.TeaFaceBack;
import com.yaorange.tqt.service.ReportService;
import com.yaorange.tqt.vo.AbsorptionVo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("api/report")
public class ReportController {

    @Resource
    private ReportService reportService;
    /**
     * 查询学生的吸收状况
     * */
    @PostMapping("absorption")
    public ResponseEntity<List<TeaFaceBack>> findAbs(@RequestBody AbsorptionVo absorptionVo){
        List<TeaFaceBack> result = reportService.findAbs(absorptionVo);
        return ResponseEntity.ok(result);
    }
}
