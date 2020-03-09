package com.yaorange.tqt.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "tea_knowledge")
public class TeaKnowledge {
    @Id
    private Long knowledgeId;

    @Column(name = "knowledge_name")
    private String name;

    private Long courseId;



    public Long getKnowledgeId() {
        return knowledgeId;
    }

    public void setKnowledgeId(Long knowledgeId) {
        this.knowledgeId = knowledgeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }


    @Override
    public String toString() {
        return "TeaKnowledge{" +
                "knowledgeId=" + knowledgeId +
                ", name='" + name + '\'' +
                ", courseId=" + courseId +
                '}';
    }
}
