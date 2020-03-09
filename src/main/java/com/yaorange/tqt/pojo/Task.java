package com.yaorange.tqt.pojo;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Description  
 * @Author
 * @Date 2020-03-06 
 */

@Entity
@Table ( name ="task" )
public class Task  implements Serializable {

	private static final long serialVersionUID =  6498764403102763394L;

	@Id
   	@Column(name = "id" )
	private String id;

	/**
	 * 名字
	 */
   	@Column(name = "name" )
	private String name;

	/**
	 * 审核人
	 */
   	@Column(name = "assignee" )
	private String assignee;

   	@Column(name = "comments" )
	private String comments;


	@Column(name = "user_id" )
	private Long userId;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAssignee() {
		return this.assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}
