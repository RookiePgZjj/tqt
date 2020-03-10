package com.yaorange.tqt.vo;

import java.util.List;

//用于前端渲染吸收情况百分比
public class AbsorptionData {
    private List<String> titles;
    private List<Integer> values;

    public List<String> getTitles() {
        return titles;
    }

    public void setTitles(List<String> titles) {
        this.titles = titles;
    }

    public List<Integer> getValues() {
        return values;
    }

    public void setValues(List<Integer> values) {
        this.values = values;
    }
}
