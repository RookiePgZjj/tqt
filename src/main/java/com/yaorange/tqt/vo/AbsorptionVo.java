package com.yaorange.tqt.vo;

public class AbsorptionVo {
    private Integer classId;//班级ID
    private Integer courseId;//课程ID
    private Integer dateNumber;//反馈的天数
    private String stuName;//学生姓名

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getDateNumber() {
        return dateNumber;
    }

    public void setDateNumber(Integer dateNumber) {
        this.dateNumber = dateNumber;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }
}
