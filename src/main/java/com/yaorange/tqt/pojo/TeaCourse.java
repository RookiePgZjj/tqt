package com.yaorange.tqt.pojo;
import javax.persistence.*;
import java.io.Serializable;

/**
 * @Description  
 * @Author
 * @Date 2020-03-06 
 */

@Entity
@Table ( name ="tea_course" )
public class TeaCourse  implements Serializable {

	private static final long serialVersionUID =  7213754974831798333L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   	@Column(name = "course_id" )
	private Long courseId;

	/**
	 * 课程名
	 */
   	@Column(name = "name" )
	private String name;

	/**
	 * 状态：0未启用，1启用
	 */
   	@Column(name = "status" )
	private Long status;

	public Long getCourseId() {
		return this.courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getStatus() {
		return this.status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}
}
