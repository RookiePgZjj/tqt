package com.yaorange.tqt.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Description  
 * @Author
 * @Date 2020-03-07 
 */

@Entity
@Table ( name ="interview" )
public class Interview  implements Serializable {

	private static final long serialVersionUID =  1961625960040918351L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   	@Column(name = "id" )
	private Long id;

	/**
	 * 学生id
	 */
   	@Column(name = "user_id" )
	private Long userId;

	/**
	 * 面试公司
	 */
   	@Column(name = "companyName" )
	private String companyName;

	/**
	 * 公司地址
	 */
   	@Column(name = "companyAddr" )
	private String companyAddr;

	/**
	 * 公司电话
	 */
   	@Column(name = "companyTel" )
	private String companyTel;

	/**
	 * 面试时间
	 */
   	@Column(name = "interviewTime" )
	private Date interviewTime;

	/**
	 * 笔试情况
	 */
   	@Column(name = "bsInfo" )
	private Long bsInfo;

	/**
	 * 面试情况
	 */
   	@Column(name = "msInfo" )
	private String msInfo;

	/**
	 * 附件
	 */
   	@Column(name = "appendixs" )
	private String appendixs;

	/**
	 * 录音
	 */
   	@Column(name = "soundRecording" )
	private String soundRecording;

	/**
	 * 经验
	 */
   	@Column(name = "experience" )
	private String experience;


   	@Column(name = "class_id")
   	private Long classId;

   	@Column(name = "stu_name")
	private String stuName;

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public Long getClassId() {
		return classId;
	}

	public void setClassId(Long classId) {
		this.classId = classId;
	}

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

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyAddr() {
		return this.companyAddr;
	}

	public void setCompanyAddr(String companyAddr) {
		this.companyAddr = companyAddr;
	}

	public String getCompanyTel() {
		return this.companyTel;
	}

	public void setCompanyTel(String companyTel) {
		this.companyTel = companyTel;
	}

	public Date getInterviewTime() {
		return this.interviewTime;
	}

	public void setInterviewTime(Date interviewTime) {
		this.interviewTime = interviewTime;
	}

	public Long getBsInfo() {
		return this.bsInfo;
	}

	public void setBsInfo(Long bsInfo) {
		this.bsInfo = bsInfo;
	}

	public String getMsInfo() {
		return this.msInfo;
	}

	public void setMsInfo(String msInfo) {
		this.msInfo = msInfo;
	}

	public String getAppendixs() {
		return this.appendixs;
	}

	public void setAppendixs(String appendixs) {
		this.appendixs = appendixs;
	}

	public String getSoundRecording() {
		return this.soundRecording;
	}

	public void setSoundRecording(String soundRecording) {
		this.soundRecording = soundRecording;
	}

	public String getExperience() {
		return this.experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

}
