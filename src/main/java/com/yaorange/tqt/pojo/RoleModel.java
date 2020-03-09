package com.yaorange.tqt.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Table( name ="role_model" )
public class RoleModel  implements Serializable {

	private static final long serialVersionUID =  5976322549276114089L;

   	@Column(name = "role_id" )
	private Integer roleId;

   	@Column(name = "model_id" )
	private Integer modelId;

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getModelId() {
		return this.modelId;
	}

	public void setModelId(Integer modelId) {
		this.modelId = modelId;
	}

}
