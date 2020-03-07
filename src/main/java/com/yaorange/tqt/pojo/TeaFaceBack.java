package com.yaorange.tqt.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Description  
 * @Author
 * @Date 2020-03-06 
 */

@Entity
@Table ( name ="tea_face_back" )
public class TeaFaceBack  implements Serializable {

	private static final long serialVersionUID =  8140561235148226589L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   	@Column(name = "id" )
	private Long id;

	/**
	 * 学员名
	 */
   	@Column(name = "user_id" )
	private Long userId;

	/**
	 * 课程
	 */
   	@Column(name = "course_id" )
	private Long courseId;

	/**
	 * 第几天
	 */
   	@Column(name = "date_number" )
	private Long dateNumber;

	/**
	 * 吸收情况
	 */
   	@Column(name = "absorption" )
	private String absorption;

	/**
	 * 不清楚的地方
	 */
   	@Column(name = "probleam" )
	private String probleam;

	/**
	 * 提交日期
	 */
   	@Column(name = "sub_date" )
	private Date subDate;

	/**
	 * 明日目标
	 */
   	@Column(name = "goal" )
	private String goal;

	/**
	 * 方案
	 */
   	@Column(name = "programme" )
	private String programme;

	/**
	 * 自我觉察
	 */
   	@Column(name = "detect" )
	private String detect;

	/**
	 * 调整方案
	 */
   	@Column(name = "adjustment" )
	private String adjustment;


   	@Transient
	private TeaCourse course;


	public TeaCourse getCourse() {
		return course;
	}

	public void setCourse(TeaCourse course) {
		this.course = course;
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

	public Long getCourseId() {
		return this.courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public Long getDateNumber() {
		return this.dateNumber;
	}

	public void setDateNumber(Long dateNumber) {
		this.dateNumber = dateNumber;
	}

	public String getAbsorption() {
		return this.absorption;
	}

	public void setAbsorption(String absorption) {
		this.absorption = absorption;
	}

	public String getProbleam() {
		return this.probleam;
	}

	public void setProbleam(String probleam) {
		this.probleam = probleam;
	}

	public Date getSubDate() {
		return this.subDate;
	}

	public void setSubDate(Date subDate) {
		this.subDate = subDate;
	}

	public String getGoal() {
		return this.goal;
	}

	public void setGoal(String goal) {
		this.goal = goal;
	}

	public String getProgramme() {
		return this.programme;
	}

	public void setProgramme(String programme) {
		this.programme = programme;
	}

	public String getDetect() {
		return this.detect;
	}

	public void setDetect(String detect) {
		this.detect = detect;
	}

	public String getAdjustment() {
		return this.adjustment;
	}

	public void setAdjustment(String adjustment) {
		this.adjustment = adjustment;
	}

}
