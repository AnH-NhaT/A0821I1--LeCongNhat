package com.example.exam.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class QuestionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "id")
    private List<QuestionContent> questionContentList;
    public QuestionType() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<QuestionContent> getQuestionContentList() {
        return questionContentList;
    }

    public void setQuestionContentList(List<QuestionContent> questionContentList) {
        this.questionContentList = questionContentList;
    }
}
