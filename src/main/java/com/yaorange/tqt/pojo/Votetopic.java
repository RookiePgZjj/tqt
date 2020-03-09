package com.yaorange.tqt.pojo;

import com.yaorange.tqt.vo.ItemVO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @Description  
 * @Author
 * @Date 2020-03-06 
 */

@Entity
@Table ( name ="votetopic" )
public class Votetopic  implements Serializable {

	private static final long serialVersionUID =  2329457485902278032L;

	@Id
   	@Column(name = "id" )
	private String id;

   	@Column(name = "title" )
	private String title;

	/**
	 * 描述
	 */
   	@Column(name = "description" )
	private String description;

	/**
	 * 班级id
	 */
   	@Column(name = "class_id" )
	private Long classId;

	/**
	 * 老师id
	 */
   	@Column(name = "user_id" )
	private Long userId;

	/**
	 * 总投票数
	 */
   	@Column(name = "total_count" )
	private Integer totalCount;


   	@Column(name = "items")
	private String item;

	/**
	 * 老师名字
	 */
	@Transient
	private String teacherName;

	@Transient
	private User teacher;

	@Transient
	private Class classes;

	@Transient
	private List<ItemVO> items;

	@Transient
	private List<Votesubtopic> voteSubtopicList;

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public List<ItemVO> getItems() {
		return items;
	}

	public void setItems(List<ItemVO> items) {
		this.items = items;
	}

	public List<Votesubtopic> getVoteSubtopicList() {
		return voteSubtopicList;
	}

	public void setVoteSubtopicList(List<Votesubtopic> voteSubtopicList) {
		this.voteSubtopicList = voteSubtopicList;
	}

	public User getTeacher() {
		return teacher;
	}

	public void setTeacher(User teacher) {
		this.teacher = teacher;
	}

	public Class getClasses() {
		return classes;
	}

	public void setClasses(Class classes) {
		this.classes = classes;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getClassId() {
		return this.classId;
	}

	public void setClassId(Long classId) {
		this.classId = classId;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public String getTeacherName() {
		return this.teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

}
