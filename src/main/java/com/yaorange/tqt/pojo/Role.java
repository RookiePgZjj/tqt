package com.yaorange.tqt.pojo;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "sys_role")
public class Role {
  @Id
  private Integer roleId;
  private String roleName;
  private String remark;
  private Integer sortNumber;


  public Integer getRoleId() {
    return roleId;
  }

  public void setRoleId(Integer roleId) {
    this.roleId = roleId;
  }

  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public Integer getSortNumber() {
    return sortNumber;
  }

  public void setSortNumber(Integer sortNumber) {
    this.sortNumber = sortNumber;
  }
}
