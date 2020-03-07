package com.yaorange.tqt.pojo;


import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "sys_model")
public class Model {
  @Id
  private Integer id;
  private String name;
  private Integer status;
  private String explain1;
  private Integer parentId;
  private String cpermission;


    public String getCpermission() {
        return cpermission;
    }

    public void setCpermission(String cpermission) {
        this.cpermission = cpermission;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getExplain1() {
        return explain1;
    }

    public void setExplain1(String explain1) {
        this.explain1 = explain1;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}
