package com.yaorange.tqt.pojo;

import javax.persistence.*;
import java.io.Serializable;

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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   	@Column(name = "id" )
	private Long id;

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
	 * 调查项目
	 */
   	@Column(name = "items" )
	private String items;

	/**
	 * 老师名字
	 */
   	@Column(name = "teacherName" )
	private String teacherName;


	/**
	 * 班级名
	 */
	@Column(name = "className" )
	private String className;


	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

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

	public String getItems() {
		return this.items;
	}

	public void setItems(String items) {
		this.items = items;
	}

	public String getTeacherName() {
		return this.teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

}
