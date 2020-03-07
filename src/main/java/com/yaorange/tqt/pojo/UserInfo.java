package com.yaorange.tqt.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @Description  
 * @Author
 * @Date 2020-03-07 
 */

@Entity
@Table ( name ="sys_user_info" )
public class UserInfo implements Serializable {

	private static final long serialVersionUID =  4428862416774062511L;

   	@Column(name = "id" )
	private Long id;

	/**
	 * 用户id
	 */
   	@Column(name = "user_id" )
	private Long userId;

	/**
	 * 等级
	 */
   	@Column(name = "gender" )
	private String gender;

	/**
	 * 邮箱
	 */
   	@Column(name = "email" )
	private String email;

	/**
	 * 生日
	 */
   	@Column(name = "birthday_date" )
	private Date birthdayDate;

	/**
	 * 电话
	 */
   	@Column(name = "phone" )
	private String phone;

	/**
	 * 移动电话
	 */
   	@Column(name = "telephone" )
	private String telephone;

	/**
	 * 排序号
	 */
   	@Column(name = "sort_number" )
	private String sortNumber;

	/**
	 * 说明
	 */
   	@Column(name = "remake" )
	private String remake;

	/**
	 * 名字
	 */
   	@Column(name = "name" )
	private String name;

   	@Column(name = "school" )
	private String school;

	/**
	 * 专业
	 */
   	@Column(name = "major" )
	private String major;

	/**
	 * 毕业时间
	 */
   	@Column(name = "fraduation_date" )
	private Date fraduationDate;

	/**
	 * 笔记地址
	 */
   	@Column(name = "note_address" )
	private String noteAddress;

	/**
	 * 年龄
	 */
   	@Column(name = "age" )
	private Long age;

	/**
	 * 学历
	 */
   	@Column(name = "eduction" )
	private String eduction;

	/**
	 * 工资
	 */
   	@Column(name = "salary" )
	private Long salary;

	/**
	 * 入职日期
	 */
   	@Column(name = "jion_Date" )
	private Date jionDate;

	/**
	 * 等级
	 */
   	@Column(name = "degree" )
	private Long degree;

	/**
	 * 工作经历
	 */
   	@Column(name = "experience" )
	private String experience;

	/**
	 * 毕业时间
	 */
   	@Column(name = "graduation_Time" )
	private Date graduationTime;

	/**
	 * 说明
	 */
   	@Column(name = "order_No" )
	private String orderNo;

	/**
	 * 岗位
	 */
   	@Column(name = "station" )
	private String station;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthdayDate() {
		return this.birthdayDate;
	}

	public void setBirthdayDate(Date birthdayDate) {
		this.birthdayDate = birthdayDate;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getSortNumber() {
		return this.sortNumber;
	}

	public void setSortNumber(String sortNumber) {
		this.sortNumber = sortNumber;
	}

	public String getRemake() {
		return this.remake;
	}

	public void setRemake(String remake) {
		this.remake = remake;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSchool() {
		return this.school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getMajor() {
		return this.major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public Date getFraduationDate() {
		return this.fraduationDate;
	}

	public void setFraduationDate(Date fraduationDate) {
		this.fraduationDate = fraduationDate;
	}

	public String getNoteAddress() {
		return this.noteAddress;
	}

	public void setNoteAddress(String noteAddress) {
		this.noteAddress = noteAddress;
	}

	public Long getAge() {
		return this.age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public String getEduction() {
		return this.eduction;
	}

	public void setEduction(String eduction) {
		this.eduction = eduction;
	}

	public Long getSalary() {
		return this.salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	public Date getJionDate() {
		return this.jionDate;
	}

	public void setJionDate(Date jionDate) {
		this.jionDate = jionDate;
	}

	public Long getDegree() {
		return this.degree;
	}

	public void setDegree(Long degree) {
		this.degree = degree;
	}

	public String getExperience() {
		return this.experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public Date getGraduationTime() {
		return this.graduationTime;
	}

	public void setGraduationTime(Date graduationTime) {
		this.graduationTime = graduationTime;
	}

	public String getOrderNo() {
		return this.orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getStation() {
		return this.station;
	}

	public void setStation(String station) {
		this.station = station;
	}
}
