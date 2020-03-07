package com.yaorange.tqt.pojo;
import javax.persistence.*;
import java.io.Serializable;

/**
 * @Description  
 * @Author
 * @Date 2020-03-06 
 */

@Entity
@Table ( name ="sys_user" )
public class User implements Serializable {

	private static final long serialVersionUID =  4300715037170048423L;

	/**
	 * 用户id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   	@Column(name = "user_id" )
	private Long userId;

	/**
	 * 用户名
	 */
   	@Column(name = "user_name" )
	private String userName;

   	@Column(name = "password" )
	private String password;

   	@Column(name = "role_id" )
	private Long roleId;

   	@Column(name = "status" )
	private Long status;

   	@Column(name = "class_id" )
	private Long classId;

   	@Transient
	private UserInfo userInfo;



	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getStatus() {
		return this.status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public Long getClassId() {
		return this.classId;
	}

	public void setClassId(Long classId) {
		this.classId = classId;
	}

}
