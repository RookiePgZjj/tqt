package com.yaorange.tqt.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Description
 * @Author
 * @Date 2020-03-10
 */

@Entity
@Table ( name ="tea_quesstion" )
public class TeaQuesstion  implements Serializable {

	private static final long serialVersionUID =  8239876532330361533L;

   	@Column(name = "id" )
	private Integer id;

   	@Column(name = "title" )
	private String title;

	/**
	 * 描述
	 */
   	@Column(name = "discribe" )
	private String discribe;

   	@Column(name = "class_id" )
	private Integer classId;

	/**
	 * 老师
	 */
   	@Column(name = "user_id" )
	private Integer userId;

	/**
	 * 调查项目
	 */
   	@Column(name = "items" )
	private String items;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDiscribe() {
        return discribe;
    }

    public void setDiscribe(String discribe) {
        this.discribe = discribe;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }
}
