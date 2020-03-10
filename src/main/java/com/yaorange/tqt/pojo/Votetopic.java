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
	 * 调查项目
	 */
   	@Column(name = "items" )
	private String items;

   	@Column
    private Integer total_count;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public Integer getTotal_count() {
        return total_count;
    }

    public void setTotal_count(Integer total_count) {
        this.total_count = total_count;
    }
}
