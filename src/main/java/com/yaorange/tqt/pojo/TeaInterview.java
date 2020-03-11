package com.yaorange.tqt.pojo;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Table(name = "tea_interview")
@Entity
@Data
public class TeaInterview {
    @Id
    private Long id;
    private String title;
    private String answer;
    private Long courseId;
    private Long knowledgeId;
    @Transient
    private TeaCourse course;
    @Transient
    private TeaKnowledge knowledgePoint;

    @Override
    public String toString() {
        return "TeaInterview{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", answer='" + answer + '\'' +
                ", courseId=" + courseId +
                ", knowledgeId=" + knowledgeId +
                ", course=" + course +
                ", knowledgePoint=" + knowledgePoint +
                '}';
    }
}
