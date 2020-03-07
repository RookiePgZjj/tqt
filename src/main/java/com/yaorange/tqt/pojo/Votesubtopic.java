package com.yaorange.tqt.pojo;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Description  
 * @Author
 * @Date 2020-03-06 
 */

@Entity
@Table ( name ="votesubtopic" )
public class Votesubtopic  implements Serializable {

	private static final long serialVersionUID =  3298151881068181718L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   	@Column(name = "id" )
	private Long id;

	/**
	 * 问卷调查标题
	 */
   	@Column(name = "title" )
	private String title;

	/**
	 * 副标题类型
	 */
   	@Column(name = "subtopic_type" )
	private Long subtopicType;

	/**
	 * 排序号
	 */
   	@Column(name = "priority" )
	private Long priority;

	/**
	 * 父id
	 */
   	@Column(name = "parent_id" )
	private Long parentId;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getSubtopicType() {
		return this.subtopicType;
	}

	public void setSubtopicType(Long subtopicType) {
		this.subtopicType = subtopicType;
	}

	public Long getPriority() {
		return this.priority;
	}

	public void setPriority(Long priority) {
		this.priority = priority;
	}

	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
}
