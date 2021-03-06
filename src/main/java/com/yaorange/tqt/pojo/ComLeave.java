package com.yaorange.tqt.pojo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Description  
 * @Author
 * @Date 2020-03-06 
 */

@Entity
@Table ( name ="com_leave" )

public class ComLeave  implements Serializable {

	private static final long serialVersionUID =  3708336146865381393L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   	@Column(name = "id" )
	private Long id;

	/**
	 * 开始时间
	 */
   	@Column(name = "start_date" )
	private Date startDate;

	/**
	 * 批假人姓名
	 */
   	@Column(name = "reviewer" )
	private String reviewer;

	/**
	 * 总天数
	 */
   	@Column(name = "total_day" )
	private Long totalDay;

	/**
	 * 原因
	 */
   	@Column(name = "reason" )
	private String reason;

	/**
	 * taskId
	 */
   	@Column(name = "taskId" )
	private String taskId;

	/**
	 * 结束时间
	 */
   	@Column(name = "end_date" )
	private Date endDate;

	/**
	 * 请假人id
	 */
   	@Column(name = "userId" )
	private Long userId;

   	@Column(name = "create_by")
	private String createBy;


	/**
	 * 持久化的comments
	 */
	@Column(name = "comments")
	private String comments;

	/**
	 * 接收前端新传的comment
	 */
   	@Transient
	private String newComment;

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getNewComment() {
		return newComment;
	}

	public void setNewComment(String newComment) {
		this.newComment = newComment;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getReviewer() {
		return reviewer;
	}

	public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
	}

	public Long getTotalDay() {
		return this.totalDay;
	}

	public void setTotalDay(Long totalDay) {
		this.totalDay = totalDay;
	}

	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getTaskId() {
		return this.taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
