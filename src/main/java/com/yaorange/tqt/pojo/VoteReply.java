package com.yaorange.tqt.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Description  
 * @Author
 * @Date 2020-03-07 
 */

@Entity
@Table ( name ="vote_reply" )
public class VoteReply  implements Serializable {

	private static final long serialVersionUID =  364275426676581210L;

	/**
	 * 问卷调查id
	 */
   	@Column(name = "subtopicId" )
	private Long subtopicId;

	/**
	 * 问卷调查得分
	 */
   	@Column(name = "reply" )
	private Long reply;

   	@Column(name = "id" )
	private Long id;

   	@Column(name = "teacher_id" )
	private Long teacherId;

	public Long getSubtopicId() {
		return this.subtopicId;
	}

	public void setSubtopicId(Long subtopicId) {
		this.subtopicId = subtopicId;
	}

	public Long getReply() {
		return this.reply;
	}

	public void setReply(Long reply) {
		this.reply = reply;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTeacherId() {
		return this.teacherId;
	}

	public void setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
	}

}
