package com.yaorange.tqt.service;

import com.yaorange.tqt.pojo.TeaFaceBack;
import com.yaorange.tqt.vo.AbsorptionVo;

import java.util.List;

public interface ReportService {
    List<TeaFaceBack> findAbs(AbsorptionVo absorptionVo);
}
